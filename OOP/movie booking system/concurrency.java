import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Customer extends Person {

  public boolean makeBooking(Booking booking) {
    List<ShowSeat> seats = booking.getSeats();
    Integer seatIds[] = new Integer[seats.size()];
    int index = 0;
    for(ShowSeat seat : seats) {
      
      [index++] = seat.getShowSeatId();
    }

    Connection dbConnection = null;
    try {
      dbConnection = getDBConnection();
      dbConnection.setAutoCommit(false);
      // ‘Serializable’ is the highest isolation level and guarantees safety from
      // Dirty, Nonrepeatable, and Phantoms reads
      dbConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

      Statement st = dbConnection.createStatement();
      String selectSQL = "Select * From ShowSeat where ShowID=? && ShowSeatID in (?) && isReserved=0";
      PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
      preparedStatement.setInt(1, booking.getShow().getShowId());
      Array array = dbConnection.createArrayOf("INTEGER", seatIds);
      preparedStatement.setArray(2, array);

      ResultSet rs = preparedStatement.executeQuery();
      // With TRANSACTION_SERIALIZABLE all the read rows will have the write lock, so we can
      // safely assume that no one else is modifying them.
      if (rs.next()) {
        rs.last(); // move to the last row, to calculate the row count
        int rowCount = rs.getRow();
        // check if we have expected number of rows, if not, this means another process is
        // trying to process at least one of the same row, if that is the case we
        // should not process this booking.
        if(rowCount == seats.size()) {
          // update ShowSeat table...
          // update Booking table ...
          dbConnection.commit();
          return true;
        }
      }
    } catch (SQLException e) {
      dbConnection.rollback();
      System.out.println(e.getMessage());
    }
    return false;
  }
}



隔離性是交易的保證之一，表示交易與交易之間不互相干擾，好像同時間就只有自己的交易存在一樣，隔離性保證的基本方式是在資料庫層面，對資料庫或相關欄位鎖定，在同一時間內只允許一個交易進行更新或讀取。

先來看看沒有對資料庫進行鎖定下，可能發生的問題：
更新遺失（lost update）
基本上就是指某個交易對欄位進行更新的資訊，因另一個交易的介入而遺失。

例如，兩個以上交易在進行同一欄位的更新時，若沒有對欄位進行鎖定，若交易A進行COMMIT，交易B因故ROLLBACK，則交易A所作的更新就會發生遺失的問題：
交易A更新欄位1
交易B更新欄位1
交易A COMMIT
交易B ROLLBACK
另一種可能的情況是，如果交易A在交易B前後進行更新與COMMIT，則交易B所作的更新將會遺失，又稱為二次更新遺失（second lost update），例如：
交易A更新欄位1
交易B更新欄位1
交易B COMMIT
交易A COMMIT
在以上的情況，交易B所進行的更新將會遺失。

髒讀（dirty read）
兩個交易同時進行，其中一個交易更新資料，另一個交易讀取了尚未COMMIT的資料，就有可能發生髒讀問題。例如：
交易A更新欄位1
交易B讀取欄位1
交易A ROLLBACK
交易B COMMIT
在以上的情況下，交易B讀取的是不正確的資料。

無法重複的讀取（unrepeatable read）
某個交易兩次讀取同一欄位的資料並不一致，例如，如果交易A在交易B前後進行資料的讀取，則會得到不同的結果。
交易A讀取欄位1
交易B更新欄位1
交易B COMMIT
交易A讀取欄位1
在以上的情況，交易A讀取兩次欄位1，但卻得到不同的結果。

幻讀（phantom read）
如果交易A進行兩次查詢，在兩次查詢之中有個交易B插入一筆新資料或刪除一筆新資料，第二次查詢時得到的資料多了第一次查詢時所沒有的筆數，或者少了一筆。
交易A進行查詢得到五筆資料
交易B插入一筆資料
交易B COMMIT
交易A進行查詢得到六筆資料

隔離交易的基本方式是鎖定資料庫，但完全的鎖定資料庫實務上並不會這麼作，因為完全的鎖定資料庫將導致嚴重的效能問題，因此實務上會根據資料讀寫更新的頻繁性，設定不同的交易隔離層級（transaction isolation level）：
read uncommited
至少保證：「A交易已更新但尚未確認的資料，B交易僅可作讀取動作」。

基本作法是，A交易在更新但未提交，B交易的更新會被延後至A提交之後。

至少可避免更新遺失的問題。

交易資料庫引擎會採取的最低隔離層級，這個隔離層級讀取錯誤資料的機率太高，一般不會採用這種隔離層級。
read commited
比read uncommited嚴格一些，至少要保證：「交易讀取的資料必須是已確認的資料」。

基本作法是， 讀取的交易不會阻止其它的交易，一個未確認的更新交易會阻止其它所有的交易，但這影響效能較大，另一個基本作法是交易正在更新，尚未確定前都先操作暫存表格。

至少可避免 dirty read 以下問題。
repeatable read
比read commited嚴格，至少保證：「同一交易內兩次讀取的資料必須相同」。

基本作法是， 讀取交易不會阻止其它讀取的交易，但阻止其它寫入的交易，但這影響效能較大，另一基本作法是，一個交易正在讀取，尚未確認前，另一交易要更新給予暫存表格。

至少可避免 unrepeatable read 以下問題。
serializable
最嚴格的隔離層級，只要有資料不一致的疑慮，交易必須可以循序，也就是一個一個來（正是serializable名稱的由來）。

基本作法是…A交易讀取時，B交易若要更新，就必須循序，A交易更新時，B交易無論讀取或更新都必須循序。

可避免phantom Read以下問題。

read uncommited出錯的機率太大，大部份的應用程式會選用read commited或repeatable read的隔離層級，而serializable執行完全的鎖定，交易只能循序進行，可能嚴重傷害系統效能。

真 正的鎖定系統是在資料庫系統上實作的，依各家廠商而有所不同，實際上資料庫會有自己的作法，未必直接阻止其它交易或真的循序進行，只要符合四個交易隔離要 求，各資料庫會尋求最有效能的解決方式，必須參考廠商的說明書，了解不同的隔離層級對應用程式的效能與擴展性有何影響。

以下整理隔離層級對多個交易並行處理的影響，YES表示可能會發生問題：

隔離層級  Dirty Read  Unrepeatable Read Phantom Read
Read uncommitted  YES YES YES
Read committed  NO  YES YES
Repreatable read  NO  NO  YES
Serializable  NO  NO  NO
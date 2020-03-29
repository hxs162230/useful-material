public class Table {
  private int tableID;
  private TableStatus status;
  private int maxCapacity;
  private int locationIdentifier;

  private List<TableSeat> seats;

  public boolean isTableFree();
  public boolean addReservation();

  public static List<Table> search(int capacity, Date startTime) {
    // return all tables with the given capacity and availability
  }
}

public class TableSeat {
  private int tableSeatNumber;
  private SeatType type;

  public boolean updateSeatType(SeatType type);
}

public class Reservation {
  private int reservationID;
  private Date timeOfReservation;
  private int peopleCount;
  private ReservationStatus status;
  private String notes;
  private Date checkinTime;
  private Customer customer;

  private Table[] tables;
  private List<Notification> notifications;
  public boolean updatePeopleCount(int count);
}

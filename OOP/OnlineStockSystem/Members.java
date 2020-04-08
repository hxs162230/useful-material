Member: Members will be buying and selling stocks:

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

public abstract class Account {
  private String id;
  private String password;
  private String name;
  private AccountStatus status;
  private Location address;
  private String email;
  private String phone;

  public boolean resetPassword();
}

public class Member extends Account {
  private double availableFundsForTrading;
  private Date dateOfMembership;

  private HashMap<string, StockPosition> stockPositions;

  private HashMap<Integer, Order> activeOrders;

  public ErrorCode placeSellLimitOrder(
    string stockId,
    float quantity,
    int limitPrice,
    TimeEnforcementType enforcementType )
  {
    // check if member has this stock position
    if(!stockPositions.containsKey(stockId)){
      return NO_STOCK_POSITION;
    }

    StockPosition stockPosition = stockPosition.get(stockId);
    // check if the member has enough quantity available to sell
    if(stockPosition.getQuantity() < quantity){
      return INSUFFICIENT_QUANTITY;
    }

    LimitOrder order =
      new LimitOrder(stockId, quantity, limitPrice, enforcementType);
    order.isBuyOrder = false;
    order.saveInDB();
    boolean success = StockExchange::placeOrder(order);
    if(!success){
      order.setStatus(OrderStatus::FAILED);
      order.saveInDB();
    } else {
      activeOrders.add(orderId, order);
    }
    return success;
  }

  public ErrorCode placeBuyLimitOrder(
    string stockId,
    float quantity,
    int limitPrice,
    TimeEnforcementType enforcementType)
  {
    // check if the member has enough funds to buy this stock
    if(availableFundsForTrading < quantity * limitPrice ){
      return INSUFFICIENT_FUNDS;
    }

    LimitOrder order =
      new LimitOrder(stockId, quantity, limitPrice, enforcementType);
    order.isBuyOrder = true;
    order.saveInDB();
    boolean success = StockExchange::placeOrder(order);
    if(!success){
      order.setStatus(OrderStatus::FAILED);
      order.saveInDB();
    } else {
      activeOrders.add(orderId, order);
    }
    return success;
  }

  // this function will be invoked whenever there is an update from
  // stock exchange against an order
  public void callbackStockExchange(int orderId, List<OrderPart> orderParts, OrderStatus status) {
    Order order = activeOrders.get(orderId);
    order.addOrderParts(orderParts);
    order.setStatus(status);
    order.updateInDB();

    if (status == OrderStatus::FILLED || status == OrderStatus::CANCELLEd) {
      activeOrders.remove(orderId);
    }
  }
}
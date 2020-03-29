public class Kitchen {
  private String name;
  private Chef[] chefs;

  private boolean assignChef();
}

public class Branch {
  private String name;
  private Address location;
  private Kitchen kitchen;

  public Address addTableChart();
}

public class Restaurant {
  private String name;
  private List<Branch> branches;

  public boolean addBranch(Branch branch);
}

public class TableChart {
  private int tableChartID;
  private byte[] tableChartImage;

  public bool print();
}
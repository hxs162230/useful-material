// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public setter function.

public class Account {
  private String id;
  private String password;
  private Address address;
  private AccountStatus status;

  public boolean resetPassword();
}

public abstract class Person {
  private String name;
  private String email;
  private String phone; 
}


public abstract class Employee extends Person {
  private int employeeID;
  private Date dateJoined;
  
  private Account account;
}

public class Receptionist extends Employee {
  public boolean createReservation();
  public List<Customer> searchCustomer(String name);
}

public class Manager extends Employee {
  public boolean addEmployee();
}

public class Chef extends Employee {
  public boolean takeOrder();
}

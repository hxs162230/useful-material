public class MenuItem {
  private int menuItemID;
  private String title;
  private String description;
  private double price;

  public boolean updatePrice(double price);
}

public class MenuSection {
  private int menuSectionID;
  private String title;
  private String description;
  private List<MenuItem> menuItems;

  public boolean addMenuItem(MenuItem menuItem);
}

public class Menu {
  private int menuID;
  private String title;
  private String description;
  private List<MenuSection> menuSections;

  public boolean addMenuSection(MenuSection menuSection);
  public boolean print();
}

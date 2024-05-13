package model;

public class Product {
    private int id;
    private String name;
    private String nameProductCategory;
    private double price;
    private int quantity;

    public Product(int id, String name, String nameProductCategory, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.nameProductCategory = nameProductCategory;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(){
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNameProductCategory() {

        return nameProductCategory;
    }

    public void setNameProductCategory(String nameProductCategory) {

        this.nameProductCategory = nameProductCategory;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }
}

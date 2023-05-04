package entity;

public class Sale {
    private String name;
    private String good;
    private String price;
    private String number;
 
    public Sale() {
    }
 
    public Sale(String name, String good,String price,String number) {
        this.name = name;
        this.good = good;
        this.price = price;
        this.number = number;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getGood() {
        return good;
    }
 
    public void setGood(String good) {
        this.good = good;
    }

    public String getPrice() {
        return price;
    }
 
    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }
 
    public void setNumber(String number) {
        this.number = number;
    }
}
package entity;
public class Cart {
    private String name;
    private String good;
    private String number;
 
    public Cart() {
    }
 
    public Cart(String name, String good, String number) {
        this.name = name;
        this.good = good;
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
 
    public String getnumber() {
        return number;
    }
 
    public void setnumber(String number) {
        this.number = number;
    }
}
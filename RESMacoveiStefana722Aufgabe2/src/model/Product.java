package model;

public class Product {
    private String name;
    private String region;
    private int price;

    public Product(String name, int price, String region){
        this.name=name;
        this.price=price;
        this.region=region;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", price=" + price +
                '}';
    }

    public void setPrice(int Price) {
        this.price = Price;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public int getId() {
        return price;
    }

    public void setId(int Price) {
        this.price = Price;
    }
}

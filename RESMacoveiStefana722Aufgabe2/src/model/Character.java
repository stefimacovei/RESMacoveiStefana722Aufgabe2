package model;

import java.util.List;

public class Character {
    private int id;
    private String name;

    private String region;
    List<Product> products;

    public Character(int id, String name,  String region,List<Product> productList){
        this.id=id;
        this.name=name;

        this.region=region;
        this.products=productList;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setId(int id){this.id=id;}
    public void setDiagnosis(String region){this.region=region;}

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId(){return  id;}
    public List<Product> getProducts(){return products;}
    public void setProducts(List<Product> getProducts){
        this.products=getProducts;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", region='" + region + '\'' +
                ", products=" + products +
                '}';
    }
}

package controller;

import repo.CharacterRepo;
import repo.ProductRepo;
import model.Product;
import model.Character;
import java.util.List;

public class Controller {
    private ProductRepo productRepo;
    private CharacterRepo characterRepo;

    public Controller( ProductRepo productRepo, CharacterRepo characterRepo){
        this.productRepo=productRepo;
        this.characterRepo=characterRepo;
    }
    public void addProduct(String name, int price, String region){
        Product product=new Product(name, price, region);
        productRepo.save(product);
    }
    public void updateProduct(String name, String newname, int price, String region){
        List<Product> productList=productRepo.getObjects();
        for (Product product : productList){
            if(product.getName().equals(name)){
                product.setName(newname);
                product.setPrice(price);
                product.setRegion(region);
            }
        }
        System.out.println("Updated product.");
    }
    public void deleteProduct(String name){
        Product product2=productRepo.getByName(name);
        productRepo.delete(product2);
    }
    public List<Product> getAllProducts(){
        List<Product> productList=productRepo.getObjects();
        return productList;
    }

    public void showAllProducts(){
        List<Product> productList=productRepo.getObjects();
        for (Product product : productList){System.out.println(product);}
        //System.out.println(productRepo.getObjects());
    }
    public void addCharacter(int id, String name, int age, String region,List<Product> charactericineList ){
        Character character=new Character(id, name, region, charactericineList);
        characterRepo.save(character);
    }
    public void updateCharacter(int id, String name, int age, String region,List<Product> charactericineList){
        List<Character> characterList=characterRepo.getObjects();
        for (Character character : characterList){
            if(character.getId()==id){
                character.setName(name);
                character.setId(id);
                character.setDiagnosis(region);
              
                character.setProducts(charactericineList);
            }
        }
        System.out.println("Updated character.");
    }
    public List<Character> showAllCharacters(){
        List<Character> characterients=characterRepo.getObjects();
        for(Character character:characterients){System.out.println(character);}
        return characterients;
    }
    public void deleteCharacter(int id){
        Character character2=characterRepo.getById(id);
        characterRepo.delete(character2);
    }


}

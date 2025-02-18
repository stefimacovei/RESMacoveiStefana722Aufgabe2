package controller;

import repo.CharacterRepo;
import repo.ProductRepo;
import model.Product;
import model.Character;

import java.util.ArrayList;
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
    public void addCharacter(int id, String name, String region,List<Product> charactericineList ){
        Character character=new Character(id, name, region, charactericineList);
        characterRepo.save(character);
    }
    public void updateCharacter(int id, String name, int age, String region,List<Product> charactericineList){
        List<Character> characterList=characterRepo.getObjects();
        for (Character character : characterList){
            if(character.getId()==id){
                character.setName(name);
                character.setId(id);
                character.setRegion(region);
              
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
    public void filterRegion(String diagnosis){
        List<Character> characterList=characterRepo.getObjects();
        for (Character character : characterList){
            if(character.getRegion().equals(diagnosis)) System.out.println(character);
        }
    }
    public void showCharactersProductForRegion(String diagnosis){
        List<Character> sortedOutput=new ArrayList<Character>();
        List<Character> characterList=characterRepo.getObjects();
        for (Character character : characterList){
            List<Product> prodList=productRepo.getObjects();
            for (Product prod : prodList){
                if(prod.getRegion().equals(diagnosis)){sortedOutput.add(character);}
            }
        }
        sortedOutput.sort((m1, m2) -> CharSequence.compare(m1.getRegion(), m2.getRegion()));
        for(Character character:sortedOutput){System.out.println(character);}
    }
    public void sortProductList(String characterName, boolean ascending){
        List<Character> characterientList=characterRepo.getObjects();
        Character character = null;
        boolean found=false;
        for (Character character2 : characterientList){
            if(character2.getName().equals(characterName)){character=character2;
                found=true;}
        }
        if(!found){
            System.out.println("Character not found.");
            return;
        }
        List<Product> medList=character.getProducts();
        medList.sort((m1, m2) -> ascending ? Integer.compare(m1.getPrice(), m2.getPrice()) : Integer.compare(m2.getPrice(), m1.getPrice()));
        for(Character character2 : characterientList){
            System.out.println(character2);
        }
    }


}

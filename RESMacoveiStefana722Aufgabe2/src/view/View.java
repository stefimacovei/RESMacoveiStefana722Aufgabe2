package view;

import java.util.*;

import model.*;
import repo.ProductRepo;
import repo.CharacterRepo;
import controller.Controller;

public class View {
    private Controller controller;

    private static ProductRepo medRepo;

    public View(Controller controller, ProductRepo medRepo) {
        this.medRepo=medRepo;
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("Select an option:\n\n1. Enter a new character \n2. Update a character\n3. Delete character\n4. Show all characters\n5. Add a product\n6. Update a product\n7. Delete a product\n8. SHow all medications\n9. Filter characters for specific region \n10. Filter thing\n11.Sorting thing \n0. Exit\n");

            String option = scanner.nextLine();
            Product med1=new Product("Nume1", 122, "ligma");
            Product med2=new Product("Nume2", 112, "raceala");
            Product med3=new Product("Caletra", 555, "ebola(neironic)");
            List<Product> medListProv=List.of(med1, med2, med3);
            switch (option) {
                case "0":
                    continueLoop = false;
                    break;
                case "1":
                    controller.addCharacter(readId(scanner), readName(scanner), readRegion(scanner), readProducts(scanner));
                    break;
                case "2":
                    controller.updateCharacter(readId(scanner), readName(scanner), readAge(scanner), readRegion(scanner), readProducts(scanner));
                    break;
                case "3":
                    controller.deleteCharacter(readId(scanner));
                    break;
                case "4":
                    controller.showAllCharacters();
                    break;
                case "5":
                    controller.addProduct(readName(scanner), readPrice(scanner), readRegion(scanner));
                    break;
                case "6":
                    controller.updateProduct(readName(scanner),readName(scanner), readPrice(scanner), readRegion(scanner));
                    break;
                case "7":
                    controller.deleteProduct( readName(scanner));
                    break;
                case "8":
                    controller.showAllProducts();
                    break;
                case "9":
                    controller.filterRegion(readRegion(scanner));
                    break;
                case "10":
                    controller.showCharactersProductForRegion(readRegion(scanner));
                    break;
                case "11":
                    controller.sortProductList(readName(scanner), readSortingOrder(scanner));
                    break;
                default:
            }
        }

    }
    private static int readId(Scanner scanner) {
        System.out.println("Enter ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readAge(Scanner scanner) {
        System.out.println("Enter age: ");
        return Integer.parseInt(scanner.nextLine());
    }
    private static int readPrice(Scanner scanner) {
        System.out.println("Enter price: ");
        return Integer.parseInt(scanner.nextLine());
    }
    private static String readName(Scanner scanner) {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }
    private static String readRegion(Scanner scanner) {
        System.out.println("Enter region: ");
        return scanner.nextLine();
    }
    private static boolean readSortingOrder(Scanner scanner) {
        System.out.println("Enter sorting order: (true fo ascending and false for descending) ");
        return Boolean.parseBoolean(scanner.nextLine());
    }
    private List<Product> readProducts(Scanner scanner) {
        System.out.println("Enter medicines(entering 0 breaks the readng): ");
        List<Product> medicineList=new ArrayList<>();
        List<Product> allMeds=medRepo.getObjects();
        Product med=null;
        boolean idk=true;
        String nname=readName(scanner);
        while (!nname.equals("0")){
            for(Product m:allMeds){
                if(m.getName().equals(nname)){med=m;break;}
            }
            if(med != null)
                medicineList.add(med);
            else System.out.println("Didnt find med");
            nname=readName(scanner);
            if(nname.equals("0")) idk=false;
        }

        return medicineList;
    }
}

package repo;
import model.Product;
import model.Character;
import java.util.*;

public class ProductRepo {
    private List<Product> Products;

    /**
     * Singleton instance of the {@code ProductRepo}.
     */
    private static ProductRepo instance;

    /**
     * Constructs a new {@code ProductRepo}.
     * Initializes the internal list for storing {@link Product} objects.
     */
    public ProductRepo() {
        this.Products=new ArrayList<>();
    }

    /**
     * Retrieves all Products managed by the Repo.
     *
     * @return a {@code List} of all {@link Product} objects
     */

    public List<Product> getObjects(){
        return Products;
    }

    /**
     * Saves a new {@link Product} object to the Repo.
     *
     * @param entity the {@link Product} object to be saved
     */

    public void save(Product entity) {
        Products.add(entity);
    }

    /**
     * Updates an existing {@link Product} object in the Repo.
     * Replaces the target {@code entity} with the given {@code ProductRepl}.
     *
     * @param entity      the {@link Product} object to be updated
     * @param ProductRepl the {@link Product} object to replace the target entity
     */

    public void update(Product entity, Product ProductRepl) {
        int index = Products.indexOf(entity);
        if (index != -1) {
            Products.set(index, ProductRepl);
        }
    }

    /**
     * Deletes a {@link Product} object from the Repo.
     *
     * @param object the {@link Product} object to be deleted
     */

    public void delete(Product object) {
        Products.remove(object);
    }

    /**
     * Retrieves a {@link Product} object by its unique identifier.
     *
     * @param id the unique ID of the {@link Product}
     * @return the {@link Product} object with the specified ID, or {@code null} if not found
     */
    public Product getById(Integer id){
        for (Product Product : Products) {
            if (Product.getId() == id)
                return Product;
        }
        return null;
    }

    public Product getByName(String Name){
        for (Product Product : Products) {
            if (Objects.equals(Product.getName(), Name))
                return Product;
        }
        return null;
    }

    public static ProductRepo getInstance() {
        if (instance == null) {
            instance = new ProductRepo();
        }
        return instance;
    }
}

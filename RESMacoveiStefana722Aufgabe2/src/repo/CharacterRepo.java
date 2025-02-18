package repo;
import model.Product;
import model.Character;
import java.util.*;

public class CharacterRepo {
    private List<Character> Characters;

    /**
     * Singleton instance of the {@code CharacterRepo}.
     */
    private static CharacterRepo instance;

    /**
     * Constructs a new {@code CharacterRepo}.
     * Initializes the internal list for storing {@link Character} objects.
     */
    public CharacterRepo() {
        this.Characters=new ArrayList<>();
    }

    /**
     * Retrieves all Characters managed by the Repo.
     *
     * @return a {@code List} of all {@link Character} objects
     */

    public List<Character> getObjects(){
        return Characters;
    }

    /**
     * Saves a new {@link Character} object to the Repo.
     *
     * @param entity the {@link Character} object to be saved
     */

    public void save(Character entity) {
        Characters.add(entity);
    }

    /**
     * Updates an existing {@link Character} object in the Repo.
     * Replaces the target {@code entity} with the given {@code CharacterRepl}.
     *
     * @param entity      the {@link Character} object to be updated
     * @param CharacterRepl the {@link Character} object to replace the target entity
     */

    public void update(Character entity, Character CharacterRepl) {
        int index = Characters.indexOf(entity);
        if (index != -1) {
            Characters.set(index, CharacterRepl);
        }
    }

    /**
     * Deletes a {@link Character} object from the Repo.
     *
     * @param object the {@link Character} object to be deleted
     */

    public void delete(Character object) {
        Characters.remove(object);
    }

    /**
     * Retrieves a {@link Character} object by its unique identifier.
     *
     * @param id the unique ID of the {@link Character}
     * @return the {@link Character} object with the specified ID, or {@code null} if not found
     */
    public Character getById(Integer id){
        for (Character Character : Characters) {
            if (Character.getId() == id)
                return Character;
        }
        return null;
    }

    public static CharacterRepo getInstance() {
        if (instance == null) {
            instance = new CharacterRepo();
        }
        return instance;
    }
}

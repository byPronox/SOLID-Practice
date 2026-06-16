package srp.repositories;

public class UserRepository {
    public void save(String email, String password) {
        System.out.println("Saving user to the database...");
        System.out.println("Email: " + email + " | Password: " + password);
    }
}
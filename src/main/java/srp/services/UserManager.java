package srp.services;
import srp.repositories.UserRepository;

public class UserManager {
    private UserValidator validator = new UserValidator();
    private UserRepository repository = new UserRepository();
    private NotificationService notifier = new NotificationService();

    public void addUser(String email, String password) {
        if (validator.isValidEmail(email) && validator.isValidPassword(password)) {
            repository.save(email, password);
            notifier.sendWelcomeEmail(email);
        } else {
            System.out.println("Invalid email or password. User not added.");
        }
    }
}
package srp;

import srp.services.UserManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TEST SRP ---");
        UserManager userManager = new UserManager();
        userManager.addUser("example@domain.com", "password123");
        userManager.addUser("invalid-email", "1234");
    }
}
package lsp;
import lsp.models.Dog;
import lsp.models.Fish;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TEST LSP ---");
        Dog dog = new Dog();
        Fish fish = new Fish();

        dog.makeSound();
        dog.walk();

        fish.makeSound();
    }
}
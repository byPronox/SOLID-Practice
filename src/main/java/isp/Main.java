package isp;
import isp.models.DisposableCamera;
import isp.models.Phone;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TEST ISP ---");
        Phone phone = new Phone();
        DisposableCamera camera = new DisposableCamera();

        phone.turnOn();
        phone.charge();
        camera.turnOn();
    }
}
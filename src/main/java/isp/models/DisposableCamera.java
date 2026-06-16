package isp.models;
import isp.interfaces.Switchable;

public class DisposableCamera implements Switchable {
    @Override
    public void turnOn() { System.out.println("Camera is turning on."); }
    @Override
    public void turnOff() { System.out.println("Camera is turning off."); }
}
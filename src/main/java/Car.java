public class Car {
    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }
    
    public int calculateDistance() {
        return speed * 24;
    }

}

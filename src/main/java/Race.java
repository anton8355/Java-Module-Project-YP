public class Race {
    private final Car[] cars;

    Race(Car[] cars) {
        this.cars = cars;
    }

    public Car findLeader() {
        Car leader = cars[0];
        for (Car car : cars) {
            if (car.calculateDistance() > leader.calculateDistance()) {
                leader = car;
            }
        }
        return leader;
    }
}

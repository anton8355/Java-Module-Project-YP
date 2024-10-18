import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Car[] cars = new Car[3];
        Set<String> usedNames = new HashSet<>(); //Здесь будет храниться список введенных названий машин
        for (int i = 0; i < 3; i++) {
            String carName;
            int carSpeed;

            while (true) {
                System.out.printf("Введите название машины №%d: ", i + 1);
                carName = inputCarName(i);
                if (!usedNames.contains(carName)) {
                    usedNames.add(carName);
                    break;
                } else {
                    System.out.printf("Машина %s уже существует. Пожалуйста, введите другое название.\n", carName);
                }
            }
            carSpeed = inputCarSpeed(i);
            cars[i] = new Car(carName, carSpeed);
        }

        Race race = new Race(cars);
        Car leader = race.findLeader();

        System.out.printf("Самая быстрая машина: %s", leader.getName());

    }

    public static String inputCarName(int i) {
        while (true) {
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.println("Введено пустое название. Пожалуйста, введите название автомобиля.");
                System.out.printf("Введите название машины №%d: ", i + 1);
            }
        }
    }

    public static int inputCarSpeed(int i) {
        while (true) {
            System.out.printf("Введите скорость машины №%d: ", i + 1);
            try {
                int speed = scanner.nextInt();
                scanner.nextLine();
                if (speed > 0 && speed <= 250) {
                    return speed;
                } else {
                    System.out.println("Неправильная скорость");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число");
                scanner.nextLine();
            }
        }
    }
}

package racingcar.Domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }


    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }


    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }


    public List<Car> getCars() {
        return cars;
    }
}
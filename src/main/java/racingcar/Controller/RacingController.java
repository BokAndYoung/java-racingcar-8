package racingcar.Controller;

import racingcar.Domain.Car;
import racingcar.IO.Input;
import racingcar.IO.Output;

import java.util.List;
import java.util.stream.Collectors;


public class RacingController {
    private final Input input;
    private final Output output;

    public RacingController() {
        this.input = new Input();
        this.output = new Output();
    }

    /**
     * 게임을 시작하고 전체 과정을 진행합니다.
     */
    public void run() {
        output.promptForCarNames();
        List<String> carNames = input.readCarNames();
        List<Car> cars = createCarsFromNames(carNames);

        output.promptForMoveCount();
        int moveCount = input.readMoveCount();


    }


    private List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
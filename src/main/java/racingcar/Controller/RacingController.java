package racingcar.Controller;

import racingcar.Domain.Car;
import racingcar.Domain.Game;
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


    public void run() {
        // 1. Get Car Names
        output.promptForCarNames();
        List<String> carNames = input.readCarNames();
        List<Car> cars = createCarsFromNames(carNames);

        // 2. Get Move Count
        output.promptForMoveCount();
        int moveCount = input.readMoveCount();

        // 3. Create and Run Game
        Game game = new Game(cars);
        output.printExecutionResultHeader();

        for (int i = 0; i < moveCount; i++) {
            game.playRound();
            output.printRoundResult(game.getCars());
        }

        // 4. Print Winners
        List<String> winners = game.getWinners();
        output.printWinners(winners);
    }


    private List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
package racingcar;

import racingcar.Controller.RacingController;

public class Application {
    public static void main(String[] args) {
        //TODO Domain & SRP
        RacingController racingController = new RacingController();
        racingController.run();
    }
}

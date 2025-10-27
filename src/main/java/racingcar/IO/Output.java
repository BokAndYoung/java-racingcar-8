package racingcar.IO;

import racingcar.Domain.Car;

import java.util.List;

public class Output {

    private static final String POSITION_MARKER = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void promptForMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }


    public void printExecutionResultHeader() {
        System.out.println("\n실행 결과");
    }


    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String positionString = getPositionString(car.getPosition());
            System.out.printf("%s : %s\n", car.getName(), positionString);
        }
        System.out.println();
    }


    private String getPositionString(int position) {
        return POSITION_MARKER.repeat(position);
    }


    public void printWinners(List<String> winnerNames) {
        String winners = String.join(WINNER_DELIMITER, winnerNames);
        System.out.printf("최종 우승자 : %s\n", winners);
    }
}
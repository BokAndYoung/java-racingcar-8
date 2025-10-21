package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
            }
        }

        return carNames;
    }



    public static int readAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        int attempts = Integer.parseInt(input);

        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }

        return attempts;
    }


}

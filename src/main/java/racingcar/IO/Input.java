package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Input {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";


    public List<String> readCarNames() {
        String input = Console.readLine();
        String[] names = input.split(NAME_DELIMITER);
        validateCarNames(names);
        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }


    private void validateCarNames(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }


    public int readMoveCount() {
        String input = Console.readLine();
        validateMoveCount(input);
        return Integer.parseInt(input);
    }


    private void validateMoveCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}

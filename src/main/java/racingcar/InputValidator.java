package racingcar;


class InputValidator {
    public static void validateNameInput(String[] names) throws IllegalArgumentException {
        if (names.length == 0) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
        for (String name : names) {
            validateSingleName(name);
        }
    }

    public static void validateCountInput(String input) throws IllegalArgumentException {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }

    }

    private static void validateSingleName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 입력할 수 있습니다.");
        }
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RacingCarGame implements GameInterface {
    private int count;
    private List<Car> cars = new ArrayList<>();

    @Override
    public void initialize() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        InputValidator.validateNameInput(names);
        initializeData(names);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = Console.readLine();
        InputValidator.validateCountInput(inputCount);
        count = Integer.parseInt(inputCount);
    }

    private void initializeData(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    @Override
    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            calculate();
            printResult();
        }
        printFinalResult();
    }

    private void calculate() {
        for (Car car : cars) {
            if (isGoForward()) {
                car.move();
            }
        }
    }

    private void printResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printFinalResult() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private boolean isGoForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}

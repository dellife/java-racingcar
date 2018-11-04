package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAXIMUM_BOUND = 10;

    private int move;
    private List<Car> cars;

    public RacingGame(int numOfCars, int move) {
        initializeCars(numOfCars);
        initializeMove(move);
    }

    public void move() {
        for (Car car : cars) {
            car.moveForward(generateMoveScore());
        }

        move--;
    }

    public boolean hasNextRound() {
        return move > 0;
    }

    public List<Car> getCarsInGame() {
        return cars;
    }

    private void initializeMove(int move) {
        this.move = move;
    }

    private void initializeCars(int numOfCars) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    private int generateMoveScore() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_BOUND);
    }
}
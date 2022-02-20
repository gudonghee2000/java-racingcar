package racingcargame.model.movevaluegenerator;

import racingcargame.model.movevaluegenerator.randomnumbergenerator.NumberGenerator;

public class MoveValueGeneratorByRandomNumber implements MoveValueGenerator {
    private static final int MAX_BOUNDARY_NUMBER = 10;
    private static final int NUMBER_MAKE_MOVE_POSSIBLE = 4;

    private final NumberGenerator numberGenerator;

    public MoveValueGeneratorByRandomNumber(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int generateMoveValue() {
        int randomNumber = numberGenerator.generateNumber(MAX_BOUNDARY_NUMBER);
        if (randomNumber > NUMBER_MAKE_MOVE_POSSIBLE) {
            return 1;
        }
        return 0;
    }
}

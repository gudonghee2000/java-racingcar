package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 입력받은_자동차_개수_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("gl");
        CarRepository carRepository = new CarRepository(carNames);

        assertThat(carRepository.getCars().size()).isEqualTo(2);
    }
}
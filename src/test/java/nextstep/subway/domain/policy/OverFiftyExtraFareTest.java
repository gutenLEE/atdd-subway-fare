package nextstep.subway.domain.policy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OverFiftyExtraFareTest {

    private FarePolicy overFiftyExtraFare;

    @BeforeEach
    void setUp() {
        overFiftyExtraFare = new OverFiftyExtraFare();
    }

    @DisplayName("OverFiftyExtraFare 는 50km 초과 시 적용한다.")
    @ParameterizedTest(name = "#{index} - 거리={0}km")
    @CsvSource(value = {"10:false", "50:false", "51:true"}, delimiter = ':')
    void support(int distance, boolean expected) {
        assertThat(overFiftyExtraFare.supports(distance)).isEqualTo(expected);
    }

    @DisplayName("OverFiftyExtraFare 요금정책은 8km 마다 100원씩 추가요금이 적용된다.")
    @ParameterizedTest(name = "#{index} - 거리={0}km, 추가요금={1}")
    @CsvSource(value = {"51:100", "59:200", "67:300"}, delimiter = ':')
    void fare(int distance, int expected) {
        assertAll(() -> {
            assertThat(overFiftyExtraFare.supports(distance)).isTrue();
            assertThat(overFiftyExtraFare.fare(distance)).isEqualTo(expected);
        });
    }

}
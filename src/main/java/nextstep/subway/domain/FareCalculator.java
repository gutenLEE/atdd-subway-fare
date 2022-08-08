package nextstep.subway.domain;

public class FareCalculator {

    private static final int DEFAULT_FARE = 1250;

    private static final int DIVISION_1_MINIMUM = 10;
    private static final int DIVISION_1_KM = 5;
    private static final int DIVISION_1_KM_FARE = 100;

    private static final int DIVISION_2_MINIMUM = 50;
    private static final int DIVISION_2_KM = 8;
    private static final int DIVISION_2_KM_FARE = 100;

    public static int calculateFare(int distance) {
        int fare = DEFAULT_FARE;
        
        if (distance > DIVISION_2_MINIMUM) {
            fare += calculateOverFareInDivision2(distance - DIVISION_2_MINIMUM);
            distance = DIVISION_2_MINIMUM;
        }

        if (distance > DIVISION_1_MINIMUM) {
            fare += calculateOverFareInDivision1(distance - DIVISION_1_MINIMUM);
        }

        return fare;
    }

    private static int calculateOverFareInDivision1(int distance) {
        return (int) ((Math.ceil((distance - 1) / DIVISION_1_KM) + 1) * DIVISION_1_KM_FARE);
    }

    private static int calculateOverFareInDivision2(int distance) {
        return (int) ((Math.ceil((distance - 1) / DIVISION_2_KM) + 1) * DIVISION_2_KM_FARE);
    }
}

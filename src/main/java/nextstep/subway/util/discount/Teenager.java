package nextstep.subway.util.discount;

public class Teenager implements DiscountAgePolicy {

    private static final double DISCOUNT_RATE = 0.2;

    @Override
    public boolean support(int age) {
        return age >= 13 && age < 19;
    }

    @Override
    public int discount(int fare) {
        return (int) (fare - ((fare - DEDUCTION_FARE) * DISCOUNT_RATE));
    }
}

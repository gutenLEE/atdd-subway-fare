package nextstep.subway.util.discount;

public class Children implements DiscountAgePolicy {

    private static final double DISCOUNT_RATE = 0.5;

    @Override
    public boolean support(int age) {
        return age >= 6 && age < 13;
    }

    @Override
    public int discount(int fare) {
        return (int) (fare - ((fare - DEDUCTION_FARE) * DISCOUNT_RATE));
    }
}

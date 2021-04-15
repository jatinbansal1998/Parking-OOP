package parking.rate;

import java.math.BigDecimal;

public class TwoWheelerRateStrategy extends RateStrategy {

    BigDecimal firstHourRate = new BigDecimal("70");
    BigDecimal secondHourRate = new BigDecimal("50");
    BigDecimal onwardsRate = new BigDecimal("25");

    public TwoWheelerRateStrategy() {
        setRateValues(firstHourRate, secondHourRate, onwardsRate);
    }
}

package parking.rate;

import java.math.BigDecimal;

public class CarRateStrategy extends RateStrategy {

    private BigDecimal firstHourRate = new BigDecimal("100");
    private BigDecimal secondHourRate = new BigDecimal("75");
    private BigDecimal onwardsRate = new BigDecimal("50");

    public CarRateStrategy() {
        setRateValues(firstHourRate, secondHourRate, onwardsRate);
    }
}

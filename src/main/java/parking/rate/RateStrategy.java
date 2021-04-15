package parking.rate;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class RateStrategy implements IRateStrategy {
    private BigDecimal firstHourRate;
    private BigDecimal secondHourRate;
    private BigDecimal onwardsRate;

    public void setRateValues(BigDecimal firstHourRate, BigDecimal secondHourRate, BigDecimal onwardsRate) {
        this.firstHourRate = firstHourRate;
        this.secondHourRate = secondHourRate;
        this.onwardsRate = onwardsRate;
    }

    @Override
    public BigDecimal calculateParkingTicketAmount(LocalDateTime entranceTime, LocalDateTime exitTime) {
        Duration duration = RateStrategyUtil.getTimeDifference(entranceTime, exitTime);
        BigDecimal returnValue = BigDecimal.ZERO;
        System.out.println("Charges for: " + duration.toHours() + " hours");
        returnValue = returnValue.add(firstHourRate);
        if (duration.toHours() > 1) {
            returnValue = returnValue.add(secondHourRate);
        }
        if (duration.toHours() > 2) {
            returnValue = returnValue.add(onwardsRate.multiply(new BigDecimal(duration.toHours() - 2)));
        }
        return returnValue;
    }
}

package parking.rate;

import parking.VehicleType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RateStrategyExecutor {

    private IRateStrategy carRateStrategy = new CarRateStrategy();
    private IRateStrategy twoWheelerRateStrategy = new TwoWheelerRateStrategy();


    public BigDecimal executeRateStrategy(VehicleType vehicleType, LocalDateTime entranceTime, LocalDateTime exitTime) {
        BigDecimal returnValue = BigDecimal.ZERO;
        switch (vehicleType) {
            case CAR:
                returnValue = carRateStrategy.calculateParkingTicketAmount(entranceTime, exitTime);
                break;
            case TWO_WHEELER:
                returnValue = twoWheelerRateStrategy.calculateParkingTicketAmount(entranceTime, exitTime);
                break;
        }
        return returnValue;
    }
}

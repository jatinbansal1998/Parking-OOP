package parking.rate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IRateStrategy {
    BigDecimal calculateParkingTicketAmount(LocalDateTime entranceTime, LocalDateTime exitTime);
}

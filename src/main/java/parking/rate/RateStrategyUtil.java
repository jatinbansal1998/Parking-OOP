package parking.rate;

import java.time.Duration;
import java.time.LocalDateTime;

public class RateStrategyUtil {
    public static Duration getTimeDifference(LocalDateTime entranceTime, LocalDateTime exitTime) {
        return Duration.between(entranceTime, exitTime);
    }
}

package parking;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class VehicleDetails {
    private String vehicleLicenceNumber;
    private VehicleType vehicleType;
    private LocalDateTime entranceTime;
    private LocalDateTime exitTime;
    private BigDecimal chargesCharged = BigDecimal.ZERO;
    private Boolean isParked;

    public VehicleDetails(String vehicleLicenceNumber, VehicleType vehicleType, LocalDateTime entranceTime) {
        this.vehicleLicenceNumber = vehicleLicenceNumber;
        this.vehicleType = vehicleType;
        this.entranceTime = entranceTime;
    }
}

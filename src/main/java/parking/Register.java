package parking;

import parking.rate.RateStrategyExecutor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static parking.VehicleType.CAR;

public class Register {
    private static Register register;
    private Map<String, VehicleDetails> vehicleDetailsMap;
    private RateStrategyExecutor rateStrategyExecutor;

    private Register() {
        this.vehicleDetailsMap = new HashMap<>();
        this.rateStrategyExecutor = new RateStrategyExecutor();
    }

    public static Register getRegister() {
        if (Register.register == null)
            Register.register = new Register();
        return Register.register;
    }

    public void enterVehicle(VehicleDetails vehicleDetails) {
        if (vehicleDetails.getVehicleType().equals(CAR) && Parking.getParkingInstance().getUsedCarCapacity() + 1 <= Parking.getCarCapacity()) {
            this.vehicleDetailsMap.put(vehicleDetails.getVehicleLicenceNumber(), vehicleDetails);
            Parking.getParkingInstance().setUsedCarCapacity(Parking.getParkingInstance().getUsedCarCapacity() + 1);
            vehicleDetails.setIsParked(Boolean.TRUE);
            System.out.println(new StringBuilder("inserted ").append(vehicleDetails));
        } else if (vehicleDetails.getVehicleType().equals(VehicleType.TWO_WHEELER) && Parking.getParkingInstance().getUsedTwoWheelerCapacity() + 1 <= Parking.getTwoWheelerCapacity()) {
            this.vehicleDetailsMap.put(vehicleDetails.getVehicleLicenceNumber(), vehicleDetails);
            Parking.getParkingInstance().setUsedTwoWheelerCapacity(Parking.getParkingInstance().getUsedTwoWheelerCapacity() + 1);
            vehicleDetails.setIsParked(Boolean.TRUE);
            System.out.println(new StringBuilder("inserted ").append(vehicleDetails));
        } else System.out.println("no parking spot available for " + vehicleDetails.getVehicleType().getValue());
    }

    public BigDecimal exitVehicle(String vehicleLicenceNumber, LocalDateTime exitTime) {
        BigDecimal parkingCharges = new BigDecimal("0");
        if (vehicleDetailsMap.containsKey(vehicleLicenceNumber)) {
            VehicleDetails vehicleDetails = vehicleDetailsMap.get(vehicleLicenceNumber);
            vehicleDetails.setExitTime(exitTime);
            parkingCharges = rateStrategyExecutor.executeRateStrategy(vehicleDetails.getVehicleType(), vehicleDetails.getEntranceTime(), exitTime);
            vehicleDetails.setChargesCharged(vehicleDetails.getChargesCharged().add(parkingCharges));
            vehicleDetails.setIsParked(Boolean.FALSE);
            switch (vehicleDetails.getVehicleType()) {
                case CAR:
                    Parking.getParkingInstance().setUsedCarCapacity(Parking.getParkingInstance().getUsedCarCapacity() - 1);
                    break;
                case TWO_WHEELER:
                    Parking.getParkingInstance().setUsedTwoWheelerCapacity(Parking.getParkingInstance().getUsedTwoWheelerCapacity() - 1);
                    break;
            }
        } else
            System.out.println(new StringBuilder("Licence Number: ").append(vehicleLicenceNumber).append(" not found").toString());
        return parkingCharges;
    }

    public void getAllDetails() {
        System.out.println(vehicleDetailsMap);
    }
}

package parking;

import java.time.LocalDateTime;

public class RunnerClass {
    public static void main(String[] args) {
        Parking parking = Parking.getParkingInstance(2, 2);
        //add car
        Register register = Register.getRegister();
        //enter car 1
        VehicleDetails vehicleDetails1 = new VehicleDetails("DL1010", VehicleType.CAR, LocalDateTime.of(2021, 04, 12, 10, 10));
        register.enterVehicle(vehicleDetails1);
        //enter car 2
        VehicleDetails vehicleDetails2 = new VehicleDetails("DL10101", VehicleType.CAR, LocalDateTime.of(2021, 04, 12, 11, 10));
        register.enterVehicle(vehicleDetails2);
        //enter two 1
        VehicleDetails vehicleDetails3 = new VehicleDetails("DL101011", VehicleType.TWO_WHEELER, LocalDateTime.of(2021, 04, 12, 12, 10));
        register.enterVehicle(vehicleDetails3);
        //enter two 2
        VehicleDetails vehicleDetails4 = new VehicleDetails("DL1010111", VehicleType.TWO_WHEELER, LocalDateTime.of(2021, 04, 12, 13, 10));
        register.enterVehicle(vehicleDetails4);
        //enter car 3
        VehicleDetails vehicleDetails5 = new VehicleDetails("DL10101111", VehicleType.CAR, LocalDateTime.of(2021, 04, 12, 14, 10));
        register.enterVehicle(vehicleDetails5);
        //enter two 3
        VehicleDetails vehicleDetails6 = new VehicleDetails("DL101011111", VehicleType.TWO_WHEELER, LocalDateTime.of(2021, 04, 12, 15, 10));
        register.enterVehicle(vehicleDetails6);
        //exit car 1
        System.out.println(register.exitVehicle("DL1010", LocalDateTime.of(2021, 04, 12, 12, 10)));
        //exit two 2
        System.out.println(register.exitVehicle("DL1010111", LocalDateTime.of(2021, 04, 12, 16, 10)));
        //enter car 3
        register.enterVehicle(vehicleDetails5);
        //enter two 3
        register.enterVehicle(vehicleDetails6);
        //getAllDetails
        register.getAllDetails();
    }
}

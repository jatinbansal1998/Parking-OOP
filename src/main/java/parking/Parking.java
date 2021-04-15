package parking;

public class Parking {
    private static int twoWheelerCapacity;
    private static int carCapacity;
    private static Parking parking;
    private int usedTwoWheelerCapacity = 0;
    private int usedCarCapacity = 0;

    private Parking() {
    }

    public static Parking getParkingInstance(int twoWheelerCapacity, int carCapacity) {
        if (parking == null) {
            parking = new Parking();
            Parking.twoWheelerCapacity = twoWheelerCapacity;
            Parking.carCapacity = carCapacity;
        }
        return parking;
    }

    public static Parking getParkingInstance() {
        if (parking == null) {
            parking = new Parking();
            Parking.twoWheelerCapacity = 100;
            Parking.carCapacity = 100;
        }
        return parking;
    }

    public static int getTwoWheelerCapacity() {
        return twoWheelerCapacity;
    }

    public static int getCarCapacity() {
        return carCapacity;
    }

    public int getUsedTwoWheelerCapacity() {
        return usedTwoWheelerCapacity;
    }

    public void setUsedTwoWheelerCapacity(int usedTwoWheelerCapacity) {
        this.usedTwoWheelerCapacity = usedTwoWheelerCapacity;
    }

    public int getUsedCarCapacity() {
        return usedCarCapacity;
    }

    public void setUsedCarCapacity(int usedCarCapacity) {
        this.usedCarCapacity = usedCarCapacity;
    }
}

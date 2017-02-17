package Map;

import java.math.BigInteger;

/**
 * Created by Jose Salinas on 2/12/2017.
 */
public class Vehicle {

    long entryTime;
    long pickupTime;
    long exitTime;
    long loopCount;
    boolean hasPassenger;

    public Vehicle() {
        entryTime = 0;
        pickupTime = 0;
        exitTime = 0;
        loopCount = 0;
        hasPassenger = false;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public long getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(long loopCount) {
        this.loopCount = loopCount;
    }

    public void loopVehicle() {
        this.loopCount++;
    }

    public boolean hasPassenger() {
        return hasPassenger;
    }

    public void setHasPassenger(boolean hasPassenger) {
        this.hasPassenger = hasPassenger;
    }
}

package ObjectOrientedDesign.DesignCallCenter;

public class Director extends Employee {

    public Director(int id, String name, Rank rank, CallCenter callCenter) {
        super(id, name, rank, callCenter);
    }
    @Override
    public void escalateCall() {
        throw new UnsupportedOperationException("Directors must handle all calls.");
    }
}


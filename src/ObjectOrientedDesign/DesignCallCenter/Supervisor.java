package ObjectOrientedDesign.DesignCallCenter;

public class Supervisor extends Employee {


    public Supervisor(int id, String name, Rank rank, CallCenter callCenter) {
        super(id, name, rank, callCenter);
    }
    @Override
    public void escalateCall() {
        if (currentCall != null) {
            currentCall.setRank(Rank.DIRECTOR);
            callCenter.notifyCallEscalated(currentCall);
            System.out.println("Call escalated by Supervisor " + name + " to Director.");
            currentCall = null;
        }
    }
}


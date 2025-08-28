package ObjectOrientedDesign.DesignCallCenter;

public class Operator extends Employee {

    public Operator(int id, String name, Rank rank, CallCenter callCenter) {
        super(id, name, rank, callCenter);
    }

    @Override
    public void escalateCall() {
        if (currentCall != null) {
            currentCall.setRank(Rank.SUPERVISOR);
            callCenter.notifyCallEscalated(currentCall);
            System.out.println("Call escalated by Operator " + name + " to Supervisor.");
            currentCall = null;
        }
    }
}


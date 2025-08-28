package ObjectOrientedDesign.DesignCallCenter;

public abstract class Employee {
    protected int id;
    protected String name;
    protected Rank rank;
    protected Call currentCall;
    protected CallCenter callCenter;

    public Employee(int id, String name, Rank rank, CallCenter callCenter) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.callCenter = callCenter;
    }

    public boolean isAvailable() {
        return currentCall == null;
    }

    public void takeCall(Call call) {
        this.currentCall = call;
        call.setHandler(this);
        call.setState(CallState.IN_PROGRESS);
        System.out.println(this.name + " (" + rank + ") is taking the call.");
    }

    public void completeCall() {
        if (currentCall != null) {
            currentCall.setState(CallState.COMPLETE);
            callCenter.notifyCallCompleted(currentCall);
            System.out.println(this.name + " completed the call.");
            currentCall = null;
        }
    }
    public abstract void escalateCall();
}




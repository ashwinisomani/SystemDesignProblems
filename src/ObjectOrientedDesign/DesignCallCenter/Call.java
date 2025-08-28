package ObjectOrientedDesign.DesignCallCenter;

public class Call {
    private Rank rank;
    private CallState state;
    private Employee handler;

    public Call(Rank rank) {
        this.state = CallState.READY;
        this.rank = rank;
    }

    public CallState getState() {
        return state;
    }

    public Rank getRank() {
        return rank;
    }

    public Employee getHandler() {
        return handler;
    }

    public void setState(CallState state) {
        this.state = state;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }
}




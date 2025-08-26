package ObjectOrientedDesign.DesignCallCenter;

import java.util.ArrayList;
import java.util.Arrays;

public class CallCenterMain {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(
                Arrays.asList(
                        new Operator(1, "Alice", Rank.OPERATOR, null),
                        new Operator(2, "Bob", Rank.OPERATOR, null)),
                Arrays.asList(
                        new Supervisor(3, "Charlie", Rank.SUPERVISOR, null)),
                Arrays.asList(
                        new Director(4, "Diana", Rank.DIRECTOR, null))
        );

        // Inject callCenter into employees after initialization
        callCenter = new CallCenter(
                Arrays.asList(
                        new Operator(1, "Alice", Rank.OPERATOR, callCenter),
                        new Operator(2, "Bob", Rank.OPERATOR, callCenter)),
                Arrays.asList(
                        new Supervisor(3, "Charlie", Rank.SUPERVISOR, callCenter)),
                Arrays.asList(
                        new Director(4, "Diana", Rank.DIRECTOR, callCenter))
        );

        Call call1 = new Call(Rank.OPERATOR);
        Call call2 = new Call(Rank.OPERATOR);
        Call call3 = new Call(Rank.OPERATOR);
        Call call4 = new Call(Rank.OPERATOR);

        callCenter.dispatchCall(call1);
        callCenter.dispatchCall(call2);
        callCenter.dispatchCall(call3);
        callCenter.dispatchCall(call4);
    }
}
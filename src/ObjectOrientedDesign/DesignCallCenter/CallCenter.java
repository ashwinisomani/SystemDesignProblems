package ObjectOrientedDesign.DesignCallCenter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCenter {
    private List<Operator> operators;
    private List<Supervisor> supervisors;
    private List<Director> directors;
    private Queue<Call> queuedCalls;

    public CallCenter(List<Operator> operators, List<Supervisor> supervisors, List<Director> directors) {
        this.operators = operators;
        this.supervisors = supervisors;
        this.directors = directors;
        this.queuedCalls = new LinkedList<>();
    }
    public void dispatchCall(Call call) {
        Employee employee = null;

        if (call.getRank() == Rank.OPERATOR) {
            employee = findAvailableEmployee(operators, call);
        }
        if (employee == null && call.getRank() != Rank.DIRECTOR) {
            employee = findAvailableEmployee(supervisors, call);
        }
        if (employee == null) {
            employee = findAvailableEmployee(directors, call);
        }

        if (employee == null) {
            queuedCalls.add(call);
            System.out.println("No available employee. Call is queued.");
        }
    }

    private Employee findAvailableEmployee(List<? extends Employee> employees, Call call) {
        for (Employee e : employees) {
            if (e.isAvailable()) {
                e.takeCall(call);
                return e;
            }
        }
        return null;
    }
    public void notifyCallEscalated(Call call) {
        dispatchCall(call);
    }

    public void notifyCallCompleted(Call call) {
        System.out.println("Call completed. Checking for queued calls...");
        for (Operator op : operators) {
            if (op.isAvailable() && !queuedCalls.isEmpty()) {
                dispatchCall(queuedCalls.poll());
                return;
            }
        }
        for (Supervisor sup : supervisors) {
            if (sup.isAvailable() && !queuedCalls.isEmpty()) {
                dispatchCall(queuedCalls.poll());
                return;
            }
        }
        for (Director dir : directors) {
            if (dir.isAvailable() && !queuedCalls.isEmpty()) {
                dispatchCall(queuedCalls.poll());
                return;
            }
        }
    }
}



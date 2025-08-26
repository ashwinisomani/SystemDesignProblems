# Call Center Simulation in Java

This project simulates a simple call center with employees of different ranks (Operator, Supervisor, Director) handling incoming calls. It demonstrates call dispatching, queuing, and escalation based on employee availability and rank.

## Classes Overview

### `Rank.java`  
Defines employee hierarchy: **OPERATOR, SUPERVISOR, DIRECTOR**.

### `CallState.java`  
Represents call status: **READY, IN_PROGRESS, COMPLETE**.

### `Call.java`  
Stores call details: required rank, state, and handler.

**Methods:**
- `getState()` / `setState(CallState state)` – Get or update the call’s current state.  
- `getRank()` / `setRank(Rank rank)` – Get or update the required employee rank.  
- `getHandler()` / `setHandler(Employee handler)` – Get or assign the employee handling the call.  

### `Employee.java`  
Abstract class for employees; manages calls and escalation.

**Methods:**
- `isAvailable()` – Returns `true` if the employee is free to take a call.  
- `takeCall(Call call)` – Assigns a call to the employee and sets it IN_PROGRESS.  
- `completeCall()` – Marks the call COMPLETE and notifies the call center.  
- `escalateCall()` – Abstract method; escalates the call to a higher rank.  

### `Operator.java` / `Supervisor.java` / `Director.java`  
Employee subclasses handling calls based on rank.

**Methods:**
- `escalateCall()` –  
  - Operator escalates to Supervisor  
  - Supervisor escalates to Director  
  - Director cannot escalate  

### `CallCenter.java`  
Manages employees, dispatches calls, and handles queuing and escalation.

**Methods:**
- `dispatchCall(Call call)` – Assigns a call to the first available employee of required rank; queues if none available.  
- `findAvailableEmployee(List<? extends Employee> employees, Call call)` – Helper to find a free employee in the given list.  
- `notifyCallEscalated(Call call)` – Re-dispatches a call after escalation.  
- `notifyCallCompleted(Call call)` – Checks queued calls and assigns to available employees.  

### `Main.java`  
Demonstrates employee creation, call center setup, and dispatching multiple calls.


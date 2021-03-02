package projectManagement.sprintStates;

import projectManagement.Sprint;

public class FinishedState extends AbstractSprintState {

    Sprint sprint;

    public FinishedState(Sprint sprint) {
        this.sprint = sprint;
    }

}

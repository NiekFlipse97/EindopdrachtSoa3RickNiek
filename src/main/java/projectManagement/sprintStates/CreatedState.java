package projectManagement.sprintStates;

import projectManagement.Sprint;

public class CreatedState extends AbstractSprintState {

    Sprint sprint;

    public CreatedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void startSprint() {
        sprint.setState(sprint.getInProgressState());
    }

}

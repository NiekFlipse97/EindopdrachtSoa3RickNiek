package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class CreatedState extends AbstractSprintState {

    Sprint sprint;

    public CreatedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toInProgressState() {
        sprint.setState(sprint.getInProgressState());
    }

}

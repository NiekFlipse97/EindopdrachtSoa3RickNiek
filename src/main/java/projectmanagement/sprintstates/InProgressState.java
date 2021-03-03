package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class InProgressState extends AbstractSprintState {

    Sprint sprint;

    public InProgressState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toFinishedState() {
        sprint.setState(sprint.getFinishedState());
    }

}
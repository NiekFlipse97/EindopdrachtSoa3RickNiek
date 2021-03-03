package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class FinishedState extends AbstractSprintState {

    Sprint sprint;

    public FinishedState(Sprint sprint) {
        this.sprint = sprint;
    }

}

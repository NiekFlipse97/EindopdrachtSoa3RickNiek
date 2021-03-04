package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class CanceledState extends AbstractSprintState{

    Sprint sprint;

    public CanceledState(Sprint sprint) {
        this.sprint = sprint;
    }
}

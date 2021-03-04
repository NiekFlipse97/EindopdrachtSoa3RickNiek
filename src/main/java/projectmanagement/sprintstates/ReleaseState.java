package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class ReleaseState extends AbstractSprintState {

    Sprint sprint;

    public ReleaseState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void startPipeline() {
        System.out.println("Start Pipeline");
    }
}

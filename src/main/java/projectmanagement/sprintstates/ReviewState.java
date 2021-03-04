package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class ReviewState extends AbstractSprintState {

    Sprint sprint;

    public ReviewState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toReleaseState() {
        sprint.setState(sprint.getReleaseState());
    }

    @Override
    public void toCanceledState() {
        sprint.setState(sprint.getCanceledState());
    }
}

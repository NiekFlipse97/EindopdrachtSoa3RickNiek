package projectmanagement.sprintstates;

import projectmanagement.Sprint;

public class ReviewState extends AbstractSprintState {

    Sprint sprint;

    public ReviewState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toReleaseState() {
        if (Boolean.TRUE.equals(sprint.hasSummary())) {
            sprint.setState(sprint.getReleaseState());
        }
    }

    @Override
    public void toCanceledState() {
        if (Boolean.TRUE.equals(sprint.hasSummary())) {
            sprint.setState(sprint.getCanceledState());
        }
    }
}

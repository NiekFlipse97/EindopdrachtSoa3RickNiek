package projectmanagement.sprintstates;

import projectmanagement.Sprint;
import projectmanagement.SprintType;

public class FinishedState extends AbstractSprintState {

    Sprint sprint;

    public FinishedState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toReviewState() {
        if (sprint.getSprintType() == SprintType.REVIEW) {
            sprint.setState(sprint.getReviewState());
        }
    }

    @Override
    public void toReleaseState() {
        if (sprint.getSprintType() == SprintType.RELEASE) {
            sprint.setState(sprint.getReleaseState());
        }
    }
}

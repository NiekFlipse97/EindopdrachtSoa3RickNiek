package projectManagement;

import projectManagement.sprintStates.*;

import java.time.LocalDateTime;

public class Sprint {

    AbstractSprintState createdState;
    AbstractSprintState inProgressState;
    AbstractSprintState finishedState;
    AbstractSprintState reviewState;
    AbstractSprintState releaseState;

    AbstractSprintState currentState;

    public String name;
    public LocalDateTime startDate;
    public LocalDateTime endDate;

    public Sprint() {
        createdState = new CreatedState(this);
        inProgressState = new InProgressState(this);
        finishedState = new FinishedState(this);
        reviewState = new ReviewState(this);
        releaseState = new ReleaseState(this);

        currentState = createdState;
    }

    public void startSprint() {
        currentState.startSprint();
    }

    public void toFinishedState() {
        currentState.toFinishedState();
    }

    public void toReviewState() {
        currentState.toReviewState();
    }

    public void setState(AbstractSprintState state) {
        this.currentState = state;
    }

    public AbstractSprintState getCreatedState() {
        return createdState;
    }

    public AbstractSprintState getInProgressState() {
        return inProgressState;
    }

    public AbstractSprintState getFinishedState() {
        return finishedState;
    }

    public AbstractSprintState getReviewState() {
        return reviewState;
    }

    public AbstractSprintState getReleaseState() {
        return releaseState;
    }

    public AbstractSprintState getCurrentState() {
        return currentState;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}

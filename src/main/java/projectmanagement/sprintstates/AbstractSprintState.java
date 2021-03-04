package projectmanagement.sprintstates;

public abstract class AbstractSprintState {

    public void toInProgressState() {
        throw new UnsupportedOperationException();
    }

    public void toFinishedState() {
        throw new UnsupportedOperationException();
    }

    public void toReviewState() {
        throw new UnsupportedOperationException();
    }

    public void toReleaseState() {
        throw new UnsupportedOperationException();
    }

    public void toCanceledState() {
        throw new UnsupportedOperationException();
    }

    public void startPipeline() {
        throw new UnsupportedOperationException();
    }

}

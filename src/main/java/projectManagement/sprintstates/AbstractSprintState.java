package projectManagement.sprintstates;

public abstract class AbstractSprintState {

    public void startSprint() {
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

    public void startPipeline() {
        throw new UnsupportedOperationException();
    }

}

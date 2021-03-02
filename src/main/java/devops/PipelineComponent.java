package devops;

public abstract class PipelineComponent {

    public void add(PipelineComponent pipelineComponent) {
        throw new UnsupportedOperationException();
    }

    void remove(PipelineComponent pipelineComponent) {
        throw new UnsupportedOperationException();
    }

    PipelineComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    void print() {
        throw new UnsupportedOperationException();
    }
}

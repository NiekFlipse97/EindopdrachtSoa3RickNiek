package discussionthreads;

public abstract class FormComponent {
    public void add(FormComponent formComponent) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public FormComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
}

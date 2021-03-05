package discussionthreads;

import users.Developer;

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

    public void setClosed(boolean isClosed) {
        throw new UnsupportedOperationException();
    }

    public Developer getDeveloper() {
        throw new UnsupportedOperationException();
    }

    public FormComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
}

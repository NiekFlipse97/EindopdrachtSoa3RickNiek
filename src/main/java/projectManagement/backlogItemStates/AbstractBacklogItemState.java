package projectManagement.backlogItemStates;

public class AbstractBacklogItemState {
    public void moveItemToTodo() {
        throw new UnsupportedOperationException();
    }

    public void itemInProgress() {
        throw new UnsupportedOperationException();
    }

    public void itemReadyForTest() {
        throw new UnsupportedOperationException();
    }

    public void testingItem() {
        throw new UnsupportedOperationException();
    }

    public void itemTested() {
        throw new UnsupportedOperationException();
    }

    public void confirmDoDItem() {
        throw new UnsupportedOperationException();
    }

    public void itemDone() {
        throw new UnsupportedOperationException();
    }
}

package projectManagement.backlogitemstates;

import projectManagement.BacklogItem;

public class TestingState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TestingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void moveItemToTodo() {
        backlogItem.setState(backlogItem.todoState);
    }

    @Override
    public void itemTested() {
        backlogItem.setState(backlogItem.testedState);
    }
}

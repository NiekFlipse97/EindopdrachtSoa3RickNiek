package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

public class TestingState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TestingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void moveItemToTodo() {
        backlogItem.setState(backlogItem.getTodoState());
    }

    @Override
    public void itemTested() {
        backlogItem.setState(backlogItem.getTestedState());
    }
}

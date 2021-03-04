package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class TestingState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TestingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemTodo() {
        backlogItem.setState(backlogItem.getTodoState());
        backlogItem.getCurrentState().notifyObservers("A BacklogItem has failed testing and set back to Todo State");
    }

    @Override
    public void itemTested() {
        backlogItem.setState(backlogItem.getTestedState());
        backlogItem.getCurrentState().notifyObservers("A BacklogItem has been tested is and waiting for a DoD Confirmation");
    }
}

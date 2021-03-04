package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class DoingState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemReadyForTest() {
        backlogItem.setState(backlogItem.getReadyForTestState());
        backlogItem.getCurrentState().notifyObservers("A BacklogItem is Ready for Testing");
    }
}

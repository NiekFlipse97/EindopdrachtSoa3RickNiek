package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class TodoState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TodoState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemInProgress() {
        backlogItem.setState(backlogItem.getDoingState());
    }
}

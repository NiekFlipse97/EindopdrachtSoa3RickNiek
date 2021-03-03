package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

public class TodoState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TodoState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void itemInProgress() {
        backlogItem.setState(backlogItem.getDoingState());
    }
}

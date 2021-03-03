package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

public class DoneState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoneState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void itemDone() {
        backlogItem.setState(backlogItem.getDoneState());
    }
}

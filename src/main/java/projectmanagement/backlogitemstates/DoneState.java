package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class DoneState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoneState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemDone() {
        backlogItem.setState(backlogItem.getDoneState());
    }
}

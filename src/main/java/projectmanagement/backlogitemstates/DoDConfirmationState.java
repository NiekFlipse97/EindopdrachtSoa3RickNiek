package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class DoDConfirmationState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoDConfirmationState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemReadyForTest() {
        backlogItem.setState(backlogItem.getReadyForTestState());
    }

    @Override
    public void itemDone() {
        if (backlogItem.areActivitiesDone()) {
            backlogItem.setState(backlogItem.getDoneState());
        }
    }
}

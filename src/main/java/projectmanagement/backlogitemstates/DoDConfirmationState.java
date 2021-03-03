package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

public class DoDConfirmationState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoDConfirmationState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void itemReadyForTest() {
        backlogItem.setState(backlogItem.getReadyForTestState());
    }

    @Override
    public void itemDone() {
        backlogItem.setState(backlogItem.getDoneState());
    }
}

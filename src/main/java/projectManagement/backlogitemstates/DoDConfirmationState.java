package projectManagement.backlogitemstates;

import projectManagement.BacklogItem;

public class DoDConfirmationState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoDConfirmationState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void itemReadyForTest() {
        backlogItem.setState(backlogItem.readyForTestState);
    }

    @Override
    public void itemDone() {
        backlogItem.setState(backlogItem.doneState);
    }
}

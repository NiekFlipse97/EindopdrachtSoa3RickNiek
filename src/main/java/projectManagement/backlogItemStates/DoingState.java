package projectManagement.backlogItemStates;

import projectManagement.BacklogItem;

public class DoingState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void itemReadyForTest() {
        backlogItem.setState(backlogItem.readyForTestState);
    }
}

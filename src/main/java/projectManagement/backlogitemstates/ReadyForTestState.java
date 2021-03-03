package projectManagement.backlogitemstates;

import projectManagement.BacklogItem;

public class ReadyForTestState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public ReadyForTestState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void testingItem() {
        backlogItem.setState(backlogItem.testingState);
    }
}

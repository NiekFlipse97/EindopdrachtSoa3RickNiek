package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

public class DoingState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public DoingState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void itemReadyForTest() {
        backlogItem.setState(backlogItem.getReadyForTestState());
    }
}

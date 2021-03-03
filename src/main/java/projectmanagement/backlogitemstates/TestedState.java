package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

public class TestedState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TestedState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    @Override
    public void confirmDoDItem() {
        backlogItem.setState(backlogItem.getDoDConfirmationState());
    }
}

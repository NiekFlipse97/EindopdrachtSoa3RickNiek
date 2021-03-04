package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class TestedState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public TestedState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemConfirmDoD() {
        backlogItem.setState(backlogItem.getDoDConfirmationState());
    }
}

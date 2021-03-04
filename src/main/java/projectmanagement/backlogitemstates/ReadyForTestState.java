package projectmanagement.backlogitemstates;

import projectmanagement.BacklogItem;

import java.util.ArrayList;

public class ReadyForTestState extends AbstractBacklogItemState {
    BacklogItem backlogItem;

    public ReadyForTestState(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
        this.observers = new ArrayList<>();
    }

    @Override
    public void itemTesting() {
        backlogItem.setState(backlogItem.getTestingState());
    }
}

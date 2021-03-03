package projectManagement;

import discussionThreads.FormComponent;
import projectManagement.backlogItemStates.*;
import users.Developer;

import java.util.List;

public class BacklogItem {
    public AbstractBacklogItemState todoState = new TodoState(this);
    public AbstractBacklogItemState doingState = new DoingState(this);
    public AbstractBacklogItemState readyForTestState = new ReadyForTestState(this);
    public AbstractBacklogItemState testingState = new TestingState(this);
    public AbstractBacklogItemState testedState = new TestedState(this);
    public AbstractBacklogItemState doDConfirmationState = new DoDConfirmationState(this);
    public AbstractBacklogItemState doneState = new DoneState(this);

    public AbstractBacklogItemState currentState = todoState;

    public Developer developer;
    public List<Activity> activities;
    public List<FormComponent> discussionThreads;

    public boolean areActivitiesDone() {
        for(int i = 0; i < activities.size(); i++) {
            if (!activities.get(i).completed) {
                return false;
            }
        }
        return true;
    }

    public void setState(AbstractBacklogItemState state) {
        this.currentState = state;
    }

    public void addFormComponent(FormComponent formComponent) {
        discussionThreads.add(formComponent);
    }
}
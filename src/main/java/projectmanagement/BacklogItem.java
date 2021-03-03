package projectmanagement;

import discussionThreads.FormComponent;
import projectmanagement.backlogitemstates.*;
import users.Developer;

import java.util.List;

public class BacklogItem {
    private AbstractBacklogItemState todoState = new TodoState(this);
    private AbstractBacklogItemState doingState = new DoingState(this);
    private AbstractBacklogItemState readyForTestState = new ReadyForTestState(this);
    private AbstractBacklogItemState testingState = new TestingState(this);
    private AbstractBacklogItemState testedState = new TestedState(this);
    private AbstractBacklogItemState doDConfirmationState = new DoDConfirmationState(this);
    private AbstractBacklogItemState doneState = new DoneState(this);

    private AbstractBacklogItemState currentState = todoState;

    private Developer developer;
    private List<Activity> activities;
    private List<FormComponent> discussionThreads;

    public boolean areActivitiesDone() {
        for(int i = 0; i < activities.size(); i++) {
            if (Boolean.FALSE.equals(activities.get(i).getCompleted())) {
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

    public AbstractBacklogItemState getTodoState() {
        return todoState;
    }

    public AbstractBacklogItemState getDoingState() {
        return doingState;
    }

    public AbstractBacklogItemState getReadyForTestState() {
        return readyForTestState;
    }

    public AbstractBacklogItemState getTestingState() {
        return testingState;
    }

    public AbstractBacklogItemState getTestedState() {
        return testedState;
    }

    public AbstractBacklogItemState getDoDConfirmationState() {
        return doDConfirmationState;
    }

    public AbstractBacklogItemState getDoneState() {
        return doneState;
    }

    public AbstractBacklogItemState getCurrentState() {
        return currentState;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<FormComponent> getDiscussionThreads() {
        return discussionThreads;
    }
}
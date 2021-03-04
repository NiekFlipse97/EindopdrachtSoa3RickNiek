package projectmanagement;

import discussionthreads.FormComponent;
import observers.*;
import projectmanagement.backlogitemstates.*;
import users.Developer;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem {
    private AbstractBacklogItemState todoState;
    private AbstractBacklogItemState doingState;
    private AbstractBacklogItemState readyForTestState;
    private AbstractBacklogItemState testingState;
    private AbstractBacklogItemState testedState;
    private AbstractBacklogItemState doDConfirmationState;
    private AbstractBacklogItemState doneState;

    private AbstractBacklogItemState currentState = todoState;

    private Developer developer;
    private List<Activity> activities;
    private List<FormComponent> discussionThreads;
    private TeamObserver teamObserver;

    private String description;

    public BacklogItem(String description, Developer developer, TesterObserver testerObserver, ScrumMasterObserver scrumMasterObserver, LeadDeveloperObserver leadDeveloperObserver, TeamObserver teamObserver) {
        this.todoState = new TodoState(this);
        this.doingState = new DoingState(this);
        this.readyForTestState = new ReadyForTestState(this);
        this.testingState = new TestingState(this);
        this.testedState = new TestedState(this);
        this.doDConfirmationState = new DoDConfirmationState(this);
        this.doneState = new DoneState(this);

        this.readyForTestState.registerObserver(testerObserver);
        this.todoState.registerObserver(scrumMasterObserver);
        this.testedState.registerObserver(leadDeveloperObserver);

        this.developer = developer;
        this.teamObserver = teamObserver;
        this.description = description;
        this.activities = new ArrayList<>();
        this.discussionThreads = new ArrayList<>();
    }

    public boolean areActivitiesDone() {
        for (Activity activity : activities) {
            if (Boolean.FALSE.equals(activity.getCompleted())) {
                return false;
            }
        }
        return true;
    }

    public void setState(AbstractBacklogItemState state) {
        this.currentState = state;
    }

    public void addFormComponent(FormComponent formComponent) {
        if (currentState != doneState) {
            discussionThreads.add(formComponent);
            teamObserver.update("There is a new message created for BacklogItem " + this.description);
        }
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

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<FormComponent> getDiscussionThreads() {
        return discussionThreads;
    }
}
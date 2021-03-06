package projectmanagement;

import discussionthreads.FormComponent;
import observers.LeadDeveloperObserver;
import observers.ScrumMasterObserver;
import observers.TeamObserver;
import observers.TesterObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.Developer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BacklogItemTest {

    private BacklogItem backlogItem;
    private final Developer dev = mock(Developer.class);
    private final TesterObserver testerObs = mock(TesterObserver.class);
    private final ScrumMasterObserver scrumMasterObs = mock(ScrumMasterObserver.class);
    private final LeadDeveloperObserver leadDevObs = mock(LeadDeveloperObserver.class);
    private final TeamObserver teamObs = mock(TeamObserver.class);

    @BeforeEach
    public void setUpStreams() {
        this.backlogItem = new BacklogItem("desc", dev, testerObs, scrumMasterObs, leadDevObs, teamObs);
    }


    @Test
    @DisplayName("BacklogItem can change to Doing state")
    void changeStateToDoing() {
        //Arrange


        //Act
        backlogItem.getCurrentState().itemInProgress();

        //Assert
        assertEquals(backlogItem.getDoingState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to Ready for testing state")
    void changeStateToReadyForTesting() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();

        //Act
        backlogItem.getCurrentState().itemReadyForTest();

        //Assert
        assertEquals(backlogItem.getReadyForTestState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to Testing state")
    void changeStateToTesting() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();

        //Act
        backlogItem.getCurrentState().itemTesting();

        //Assert
        assertEquals(backlogItem.getTestingState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to Todo state from testing")
    void changeStateToTodoFromTesting() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();

        //Act
        backlogItem.getCurrentState().itemTodo();

        //Assert
        assertEquals(backlogItem.getTodoState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to Tested state")
    void changeStateToTested() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();

        //Act
        backlogItem.getCurrentState().itemTested();

        //Assert
        assertEquals(backlogItem.getTestedState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to DoD Confirmation state")
    void changeStateToDoDConfirmation() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();
        backlogItem.getCurrentState().itemTested();

        //Act
        backlogItem.getCurrentState().itemConfirmDoD();

        //Assert
        assertEquals(backlogItem.getDoDConfirmationState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to Ready for testing state when false Confirmation")
    void changeStateToReadyForTestingWhenFalseConfirmation() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();
        backlogItem.getCurrentState().itemTested();
        backlogItem.getCurrentState().itemConfirmDoD();

        //Act
        backlogItem.getCurrentState().itemReadyForTest();

        //Assert
        assertEquals(backlogItem.getReadyForTestState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can change to Ready for testing state when true Confirmation and all activities done")
    void changeStateToReadyForTestingWhenTrueConfirmationWithDoneActivities() {
        //Arrange
        Activity activity = mock(Activity.class);
        when(activity.getCompleted()).thenReturn(true);
        backlogItem.addActivity(activity);
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();
        backlogItem.getCurrentState().itemTested();
        backlogItem.getCurrentState().itemConfirmDoD();

        //Act
        backlogItem.getCurrentState().itemDone();

        //Assert
        assertEquals(backlogItem.getDoneState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can not change to Ready for testing state when true Confirmation and all activities not Done")
    void changeStateToReadyForTestingWhenTrueConfirmationWithNotDoneActivities() {
        //Arrange
        Activity activity = mock(Activity.class);
        when(activity.getCompleted()).thenReturn(false);
        backlogItem.addActivity(activity);
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();
        backlogItem.getCurrentState().itemTested();
        backlogItem.getCurrentState().itemConfirmDoD();

        //Act
        backlogItem.getCurrentState().itemDone();

        //Assert
        assertEquals(backlogItem.getDoDConfirmationState(), backlogItem.getCurrentState());

    }

    @Test
    @DisplayName("BacklogItem can have multiple activities")
    void multipleActivitiesOnBacklogItem() {
        //Arrange
        Activity activity = mock(Activity.class);
        when(activity.getCompleted()).thenReturn(true);
        backlogItem.addActivity(activity);
        backlogItem.addActivity(activity);
        backlogItem.addActivity(activity);
        backlogItem.addActivity(activity);

        //Act


        //Assert
        assertEquals(4, backlogItem.getActivities().size());

    }

    @Test
    @DisplayName("BacklogItem can only have 1 Developer")
    void singleDeveloperOnBacklogItem() {
        //Arrange
        Developer dev = backlogItem.getDeveloper();

        //Act

        //Assert
        assertNotNull(dev);
    }

    @Test
    @DisplayName("Notification send to testers when Ready for testing state")
    void readyForTestingNotificationSendToTesters() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();

        //Act
        backlogItem.getCurrentState().itemReadyForTest();

        //Assert
        verify(testerObs, times(1)).update("A BacklogItem is Ready for Testing");

    }

    @Test
    @DisplayName("Notification send to ScrumMaster when back to todo state")
    void todoNotificationSendToScrumMaster() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();

        //Act
        backlogItem.getCurrentState().itemTodo();

        //Assert
        verify(scrumMasterObs, times(1)).update("A BacklogItem has failed testing and set back to Todo State");

    }

    @Test
    @DisplayName("Notification send to Lead Dev when to tested state")
    void testedNotificationSendToLeadDev() {
        //Arrange
        backlogItem.getCurrentState().itemInProgress();
        backlogItem.getCurrentState().itemReadyForTest();
        backlogItem.getCurrentState().itemTesting();

        //Act
        backlogItem.getCurrentState().itemTested();

        //Assert
        verify(leadDevObs, times(1)).update("A BacklogItem has been tested is and waiting for a DoD Confirmation");

    }

    @Test
    @DisplayName("Notification send if discussion is started")
    void discussionNotificationSendToTeam() {
        //Arrange

        //Act
        backlogItem.addFormComponent(mock(FormComponent.class));

        //Assert
        verify(teamObs, times(1)).update("There is a new message created for BacklogItem " + backlogItem.getDescription());
    }
}

package projectmanagement;

import observers.LeadDeveloperObserver;
import observers.ScrumMasterObserver;
import observers.TeamObserver;
import observers.TesterObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.Developer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BacklogItemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private BacklogItem backlogItem;


    @BeforeEach
    public void setUpStreams() {
        Developer dev = mock(Developer.class);
        TesterObserver testerObs = mock(TesterObserver.class);
        ScrumMasterObserver scrumMasterObs = mock(ScrumMasterObserver.class);
        LeadDeveloperObserver leadDevObs = mock(LeadDeveloperObserver.class);
        TeamObserver teamObs = mock(TeamObserver.class);
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
}

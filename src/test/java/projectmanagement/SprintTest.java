package projectmanagement;

import discussionthreads.FormComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectmanagement.backlogitemstates.DoneState;
import users.AbstractUser;
import users.Developer;
import users.ProductOwner;
import users.ScrumMaster;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SprintTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private Sprint sprintReview;
    private Sprint sprintRelease;
    private ArrayList<AbstractUser> users;
    private Developer rick;
    private Developer niek;

    @BeforeEach
    public void setUpStreams() {
        this.sprintReview = new Sprint(3,5, SprintType.REVIEW);
        this.sprintRelease = new Sprint(3,5, SprintType.RELEASE);
        users = new ArrayList<>();
        rick = mock(Developer.class);
        when(rick.getName()).thenReturn("Rick");

        niek = mock(Developer.class);
        when(niek.getName()).thenReturn("Niek");

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("Sprint can contain multiple BacklogItems")
    void compareSizeOfBacklogItemListInSprint() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);

        //Act
        sprintReview.addBacklogItem(bi);
        sprintReview.addBacklogItem(bi);
        sprintReview.addBacklogItem(bi);
        sprintReview.addBacklogItem(bi);

        //Assert
        assertEquals(4, sprintReview.getBacklogItems().size());

    }

    @Test
    @DisplayName("Sprint can change state to InProgress")
    void changeStateToInProgress() {
        //Arrange


        //Act
        sprintReview.getCurrentState().toInProgressState();

        //Assert
        assertEquals(sprintReview.getInProgressState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint can change state to Finished with all backlogItemsDone")
    void changeStateToFinishedWithAllBacklogItemsDone() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        DoneState ds = mock(DoneState.class);
        when(bi.getCurrentState()).thenReturn(ds);
        when(bi.getDoneState()).thenReturn(ds);

        sprintReview.addBacklogItem(bi);
        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(2999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();

        //Act
        sprintReview.getCurrentState().toFinishedState();

        //Assert
        assertEquals(sprintReview.getFinishedState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint can change state to Finished after EndDate")
    void changeStateToFinishedAfterEndDate() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();

        //Act
        sprintReview.getCurrentState().toFinishedState();

        //Assert
        assertEquals(sprintReview.getFinishedState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint can change state to Review when SprintType is Review")
    void changeStateToReviewWhenSprintTypeReview() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();
        sprintReview.getCurrentState().toFinishedState();

        //Act
        sprintReview.getCurrentState().toReviewState();

        //Assert
        assertEquals(sprintReview.getReviewState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint cannot change state to Review when SprintType is Release")
    void changeStateToReviewWhenSprintTypeRelease() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintRelease.addBacklogItem(bi);
        sprintRelease.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintRelease.getCurrentState().toInProgressState();
        sprintRelease.getCurrentState().toFinishedState();

        //Act
        sprintRelease.getCurrentState().toReviewState();

        //Assert
        assertEquals(sprintRelease.getFinishedState(), sprintRelease.getCurrentState());
    }

    @Test
    @DisplayName("Sprint can change state to Release when SprintType is Release")
    void changeStateToReleaseWhenSprintTypeRelease() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintRelease.addBacklogItem(bi);
        sprintRelease.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintRelease.getCurrentState().toInProgressState();
        sprintRelease.getCurrentState().toFinishedState();

        //Act
        sprintRelease.getCurrentState().toReleaseState();

        //Assert
        assertEquals(sprintRelease.getReleaseState(), sprintRelease.getCurrentState());
    }

    @Test
    @DisplayName("Sprint cannot change state to Release when SprintType is Review")
    void changeStateToReleaseWhenSprintTypeReview() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();
        sprintReview.getCurrentState().toFinishedState();

        //Act
        sprintReview.getCurrentState().toReleaseState();

        //Assert
        assertEquals(sprintReview.getFinishedState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint starts pipeline in Release State")
    void startPipelineInReleaseState() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintRelease.addBacklogItem(bi);
        sprintRelease.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintRelease.getCurrentState().toInProgressState();
        sprintRelease.getCurrentState().toFinishedState();
        sprintRelease.getCurrentState().toReleaseState();

        //Act
        sprintRelease.getCurrentState().startPipeline();

        //Assert
        String content = outContent.toString();
        assertTrue(content.contains("Start Pipeline"));
    }

    @Test
    @DisplayName("Sprint cannot change state to Release or Canceled when summary is not provided")
    void changeStateToReleaseWhenNoSummary() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();
        sprintReview.getCurrentState().toFinishedState();
        sprintReview.getCurrentState().toReviewState();

        //Act
        sprintReview.getCurrentState().toReleaseState();
        sprintReview.getCurrentState().toCanceledState();

        //Assert
        assertEquals(sprintReview.getReviewState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint can change state to Release when summary is provided")
    void changeStateToReleaseWhenSummaryProvided() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();
        sprintReview.getCurrentState().toFinishedState();
        sprintReview.getCurrentState().toReviewState();

        //Act
        sprintReview.addSummary("Summary");
        sprintReview.getCurrentState().toReleaseState();

        //Assert
        assertEquals(sprintReview.getReleaseState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Sprint can change state to Canceled when summary is provided")
    void changeStateToCanceledWhenSummaryProvided() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        when(bi.getCurrentState()).thenReturn(mock(DoneState.class));
        when(bi.getDoneState()).thenReturn(mock(DoneState.class));

        sprintReview.addBacklogItem(bi);
        sprintReview.setEndDate(LocalDateTime.of(1999,12,31, 23, 59,59));

        sprintReview.getCurrentState().toInProgressState();
        sprintReview.getCurrentState().toFinishedState();
        sprintReview.getCurrentState().toReviewState();

        //Act
        sprintReview.addSummary("Summary");
        sprintReview.getCurrentState().toCanceledState();

        //Assert
        assertEquals(sprintReview.getCanceledState(), sprintReview.getCurrentState());
    }

    @Test
    @DisplayName("Test if a sprint has a Project")
    void SprintHasAProject() {
        // Arrange
        Project p = new Project(mock(ProductOwner.class), "AvansDevops", "Avans");

        // Act
        p.addSprint(sprintRelease, mock(List.class), "v1.0", mock(ScrumMaster.class));
        Project project = sprintRelease.getProject();

        // Assert
        assertNotNull(project);
    }

    @Test
    @DisplayName("Variables can be changed in Created state")
    void variableChangedInCreatedState() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        LocalDateTime ldt = LocalDateTime.now();

        //Act
        sprintReview.addBacklogItem(bi);
        sprintReview.setSprintName("Sprint name");
        sprintReview.setStartDate(ldt);
        sprintReview.setEndDate(ldt);

        //Assert
        assertEquals(bi, sprintReview.getBacklogItems().get(0));
        assertEquals("Sprint name", sprintReview.getSprintName());
        assertEquals(ldt, sprintReview.getStartDate());
        assertEquals(ldt, sprintReview.getEndDate());
    }

    @Test
    @DisplayName("Variables cannot be changed outside of Created state")
    void variableNotChangedOutsideCreatedState() {
        //Arrange
        BacklogItem bi = mock(BacklogItem.class);
        BacklogItem bi2 = mock(BacklogItem.class);
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2999, 12, 31, 23, 59, 59);

        //Act
        sprintReview.addBacklogItem(bi);
        sprintReview.setSprintName("Sprint name");
        sprintReview.setStartDate(ldt);
        sprintReview.setEndDate(ldt);

        sprintReview.getCurrentState().toInProgressState();

        sprintReview.addBacklogItem(bi2);
        sprintReview.setSprintName("Second Sprint name");
        sprintReview.setStartDate(ldt2);
        sprintReview.setEndDate(ldt2);

        //Assert
        assertEquals(bi, sprintReview.getBacklogItems().get(0));
        assertEquals("Sprint name", sprintReview.getSprintName());
        assertEquals(ldt, sprintReview.getStartDate());
        assertEquals(ldt, sprintReview.getEndDate());
    }

    @Test
    @DisplayName("Test if a sprint has multiple developers")
    void SprintHasMultipleDevelopers() {
        // Arrange
        users.add(rick);
        users.add(niek);
        sprintRelease.setUsers(users);

        // Act
        List<AbstractUser> developers = sprintRelease.getUsers();
        int size = developers.size();

        // Assert
        assertEquals(2, size);
        assertNotNull(developers);

    }
}

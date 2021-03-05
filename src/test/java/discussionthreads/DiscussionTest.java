package discussionthreads;

import observers.LeadDeveloperObserver;
import observers.ScrumMasterObserver;
import observers.TeamObserver;
import observers.TesterObserver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectmanagement.BacklogItem;
import users.Developer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DiscussionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private BacklogItem backlogItem;
    private FormComponent threadNiek;
    private FormComponent threadRick;
    private FormComponent threadNiek1;
    private FormComponent commentNullPointer;
    private FormComponent commentAfterDone;
    private FormComponent commentThreadRick;
    private FormComponent commentStateRick;
    private FormComponent commentStateNiek;
    private Developer rick;
    private Developer niek;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @BeforeEach
    public void setObjects() {
        rick = mock(Developer.class);
        when(rick.getName()).thenReturn("Rick");

        niek = mock(Developer.class);
        when(niek.getName()).thenReturn("Niek");

        backlogItem = new BacklogItem("BacklogItem", niek, mock(TesterObserver.class), mock(ScrumMasterObserver.class), mock(LeadDeveloperObserver.class), mock(TeamObserver.class));
        threadNiek = new Thread(niek, "The First Thread", "Null pointer in Main java class");
        threadRick = new Thread(rick, "The Second Thread", "Can't find the error. pls help");
        threadNiek1 = new Thread(niek, "The Third Thread", "I can not change state on this backlog item!");

        commentNullPointer = new Comment(rick, "Your called object is not initialized.");
        commentThreadRick = new Comment(niek, "You missed a semicolon...");
        commentAfterDone = new Comment(niek, "Thank you!");
        commentStateRick = new Comment(rick, "Have you tried turning it off and on again?");
        commentStateNiek = new Comment(niek, "Oops....");
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("Test if backlog items can have a Thread")
    void BacklogItemsCanHaveAThread(){
        // Arrange
        backlogItem.addFormComponent(this.threadNiek);

        // Act
        List<FormComponent> components = backlogItem.getDiscussionThreads();
        int size = components.size();

        // Assert
        assertEquals(size, 1);
        assertEquals(components.get(0).getName(), this.threadNiek.getName());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            components.get(1);
        });
    }

    @Test
    @DisplayName("Test if backlog items can have a Comment under a Thread")
    void BacklogItemsCanHaveCommentUnderAThread() {
        // Arrange
        threadNiek.add(commentNullPointer);
        threadRick.add(commentThreadRick);

        threadNiek1.add(commentStateRick);
        threadNiek1.add(commentStateNiek);

        backlogItem.addFormComponent(threadNiek);
        backlogItem.addFormComponent(threadRick);
        backlogItem.addFormComponent(threadNiek1);

        String indent = " ^--- ";

        // Act
        for (FormComponent x : backlogItem.getDiscussionThreads()) {
            x.print();
        }

        // Assert
//        assertTrue(true);
        String content = outContent.toString().trim();
        assertTrue(content.contains(indent.trim()));
        assertTrue(content.contains(threadNiek1.getName()));
        assertTrue(content.contains(threadNiek1.getDescription()));
        assertTrue(content.contains(commentNullPointer.getDescription().trim()));
    }

    @Test
    @DisplayName("Test if backlog items cannot get new Comments under a thread if backlog item is in Done state")
    void BacklogItemsCanNotGetNewCommentsUnderAThreadIfBacklogItemIsInDoneState() {
        // Arrange
        backlogItem.addFormComponent(threadNiek);
        threadNiek.add(commentNullPointer);

        backlogItem.setState(backlogItem.getDoneState());
        threadNiek.add(commentAfterDone);

        // Act
        for (FormComponent formComponent : backlogItem.getDiscussionThreads()) {
            formComponent.print();
        }

        // Assert
//        assertTrue(true);
        String content = outContent.toString().trim();
        assertTrue(content.contains(threadNiek.getDescription()));
        assertTrue(content.contains(commentNullPointer.getDescription()));
        assertFalse(content.contains(commentAfterDone.getDescription()));
    }

}

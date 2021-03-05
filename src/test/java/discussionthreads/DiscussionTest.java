package discussionthreads;

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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DiscussionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("Discussion with threads and comments")
    void printDiscussionWithMultipleThreads() {
        // Arrange
        BacklogItem backlogItemMock = mock(BacklogItem.class);
        Developer rick = mock(Developer.class);
        when(rick.getName()).thenReturn("Rick");
        Developer niek = mock(Developer.class);
        when(niek.getName()).thenReturn("Niek");

        FormComponent thread = new Thread(niek, "The First Thread", "Null pointer in Main java class");
        FormComponent thread1 = new Thread(rick, "The Second Thread", "Can't find the error. pls help");
        FormComponent thread2 = new Thread(niek, "The Third Thread", "I can not change state on this backlog item!");
        FormComponent comment = new Comment(rick, "The object you called is not initialized");
        FormComponent comment1 = new Comment(niek, "You missed a semicolon...");
        FormComponent comment2 = new Comment(rick, "Have you tried turning it off and on again?");
        FormComponent comment3 = new Comment(niek, "Oops....");

        thread.add(comment);
        thread1.add(comment1);

        thread2.add(comment2);
        thread2.add(comment3);

        List<FormComponent> form = new ArrayList<>();
        form.add(thread);
        form.add(thread1);
        form.add(thread2);

        when(backlogItemMock.getDiscussionThreads()).thenReturn(form);

        String indent = " ^--- ";

        // Act
        for (FormComponent x : backlogItemMock.getDiscussionThreads()) {
            x.print();
        }

        // Assert
//        assertTrue(true);
        String content = outContent.toString().trim();
        assertTrue(content.contains(indent.trim()));
        assertTrue(content.contains(thread2.getName()));
        assertTrue(content.contains(thread2.getDescription()));
        assertTrue(content.contains(comment.getDescription().trim()));
    }

}

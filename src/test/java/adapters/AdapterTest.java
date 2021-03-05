package adapters;

import discussionthreads.Comment;
import discussionthreads.Thread;
import notifiers.MailNotifier;
import notifiers.SkypeNotifier;
import notifiers.SlackNotifier;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AdapterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final SlackNotifier slackNotifier = new SlackNotifier();
    private final MailNotifier mailNotifier = new MailNotifier();
    private final SkypeNotifier skypeNotifier = new SkypeNotifier();

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
    @DisplayName("Mail Adapter Adapts Mail for PseudoLibrary")
    void mailAdapterCalled() {
        //Arrange


        //Act
        mailNotifier.notify("Mail Notification");

        //Assert
        String content = outContent.toString().trim();
        assertTrue(content.contains("Mail V1: Mail Notification"));
    }

    @Test
    @DisplayName("Slack Adapter Adapts Slack for PseudoLibrary")
    void SlackAdapterCalled() {
        //Arrange


        //Act
        slackNotifier.notify("Slack Notification");

        //Assert
        String content = outContent.toString().trim();
        assertTrue(content.contains("Slack V1: Slack Notification"));
    }

    @Test
    @DisplayName("Skype Adapter Adapts Skype for PseudoLibrary")
    void SkypeAdapterCalled() {
        //Arrange


        //Act
        skypeNotifier.notify("Skype Notification");

        //Assert
        String content = outContent.toString().trim();
        assertTrue(content.contains("Skype V1: Skype Notification"));
    }
}

package notifiers;

import observers.DeveloperObserver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.Developer;

import static org.mockito.Mockito.*;

class NotifierTest {
    private final DeveloperObserver developerObserver = mock(DeveloperObserver.class);
    private final Developer developer = new Developer(developerObserver, "Rick");
    private final MailNotifier mailNotifier = mock(MailNotifier.class);
    private final SkypeNotifier skypeNotifier = mock(SkypeNotifier.class);
    private final SlackNotifier slackNotifier = mock(SlackNotifier.class);

    @Test
    @DisplayName("Notifier calls Mail Adapter")
    void mailAdapterCalled() {
        //Arrange
        developer.addNotifier(mailNotifier);

        //Act
        developer.notify("New Mail Message");

        //Assert
        verify(mailNotifier, times(1)).notify("New Mail Message");
    }

    @Test
    @DisplayName("Notifier calls Slack Adapter")
    void slackAdapterCalled() {
        //Arrange
        developer.addNotifier(slackNotifier);

        //Act
        developer.notify("New Slack Message");

        //Assert
        verify(slackNotifier, times(1)).notify("New Slack Message");
    }

    @Test
    @DisplayName("Notifier calls Skype Adapter")
    void skypeAdapterCalled() {
        //Arrange
        developer.addNotifier(skypeNotifier);

        //Act
        developer.notify("New Skype Message");

        //Assert
        verify(skypeNotifier, times(1)).notify("New Skype Message");
    }
}

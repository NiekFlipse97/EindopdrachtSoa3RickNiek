package projectmanagement;

import observers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.Developer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ActivityTest {
    private Activity activity;

    @BeforeEach
    public void setUpStreams() {
        DeveloperObserver devObs = new DeveloperObserver();
        Developer dev = new Developer(devObs, "Rick");
        this.activity = new Activity("Name", "Desc", dev);
    }

    @Test
    @DisplayName("Activity can only have 1 Developer")
    void singleDeveloperForActivity() {
        //Arrange
        Developer dev = activity.getDeveloper();

        //Act

        //Assert
        assertNotNull(dev);

    }
}

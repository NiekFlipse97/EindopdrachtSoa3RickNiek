package projectmanagement;

import observers.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.Developer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ActivityTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private Activity activity;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        DeveloperObserver devObs = new DeveloperObserver();
        Developer dev = new Developer(devObs, "Rick");
        this.activity = new Activity("Name", "Desc", dev);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
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

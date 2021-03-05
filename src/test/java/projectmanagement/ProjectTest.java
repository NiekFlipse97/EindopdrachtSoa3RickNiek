package projectmanagement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.AbstractUser;
import users.ProductOwner;
import users.ScrumMaster;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectTest {

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
    @DisplayName("Project can contain multiple Sprints")
    void compareSizeOfSprintListInProject() {
        //Arrange
        ProductOwner po = mock(ProductOwner.class);
        ScrumMaster sm = mock(ScrumMaster.class);
        ArrayList<AbstractUser> users = mock(ArrayList.class);
        Project p = new Project(po, "Test Project", "Test Business Name");
        Sprint one = mock(Sprint.class);
        Sprint two = mock(Sprint.class);
        Sprint three = mock(Sprint.class);
        Sprint four = mock(Sprint.class);

        //Act
        p.addSprint(one, users, "1", sm);
        p.addSprint(two, users, "1", sm);
        p.addSprint(three, users, "1", sm);
        p.addSprint(four, users, "1", sm);

        //Assert
        assertEquals(4, p.getSprints().size());
    }
}

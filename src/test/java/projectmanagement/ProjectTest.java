package projectmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.AbstractUser;
import users.ProductOwner;
import users.ScrumMaster;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectTest {

    private Project p;
    private ProductOwner po;
    private ScrumMaster sm;

    @BeforeEach
    public void setUpStreams() {
        p = new Project(po, "Test Project", "Test Business Name");
        po = mock(ProductOwner.class);
        sm = mock(ScrumMaster.class);
    }

    @Test
    @DisplayName("Project can contain multiple Sprints")
    void compareSizeOfSprintListInProject() {
        //Arrange
        ArrayList<AbstractUser> users = mock(ArrayList.class);
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

    @Test
    @DisplayName("Test if a project has 1 and only 1 product owner")
    void projectHasOneProductOwner() {
        // Arrange
        p.setProductOwner(po);

        // Act
        ProductOwner productOwner = p.getProductOwner();

        // Assert
        assertNotNull(productOwner);
    }
}

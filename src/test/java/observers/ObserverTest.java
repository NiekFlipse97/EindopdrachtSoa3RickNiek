package observers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class ObserverTest {

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
    @DisplayName("Developer gets notified from its Observer")
    void developerGetsNotifiedByObserver() {
        //Arrange
        Developer developer = mock(Developer.class);
        DeveloperObserver developerObserver = new DeveloperObserver();
        developerObserver.addUser(developer);

        //Act
        developerObserver.update("Message for Developers");

        //Assert
        verify(developer, times(1)).notify("Message for Developers");

    }

    @Test
    @DisplayName("ProductOwner gets notified from its Observer")
    void productOwnerGetsNotifiedByObserver() {
        //Arrange
        ProductOwner productOwner = mock(ProductOwner.class);
        ProductOwnerObserver productOwnerObserver = new ProductOwnerObserver();
        productOwnerObserver.addUser(productOwner);

        //Act
        productOwnerObserver.update("Message for ProductOwners");

        //Assert
        verify(productOwner, times(1)).notify("Message for ProductOwners");

    }

    @Test
    @DisplayName("Stakeholder gets notified from its Observer")
    void stakeholderGetsNotifiedByObserver() {
        //Arrange
        Stakeholder stakeholder = mock(Stakeholder.class);
        StakeholderObserver stakeholderObserver = new StakeholderObserver();
        stakeholderObserver.addUser(stakeholder);

        //Act
        stakeholderObserver.update("Message for Stakeholders");

        //Assert
        verify(stakeholder, times(1)).notify("Message for Stakeholders");

    }

    @Test
    @DisplayName("Tester gets notified from its Observer")
    void testerGetsNotifiedByObserver() {
        //Arrange
        Tester tester = mock(Tester.class);
        TesterObserver testerObserver = new TesterObserver();
        testerObserver.addUser(tester);

        //Act
        testerObserver.update("Message for Testers");

        //Assert
        verify(tester, times(1)).notify("Message for Testers");

    }

    @Test
    @DisplayName("ScrumMaster gets notified from its Observer")
    void scrumMasterGetsNotifiedByObserver() {
        //Arrange
        ScrumMaster scrumMaster = mock(ScrumMaster.class);
        ScrumMasterObserver scrumMasterObserver = new ScrumMasterObserver();
        scrumMasterObserver.addUser(scrumMaster);

        //Act
        scrumMasterObserver.update("Message for ScrumMasters");

        //Assert
        verify(scrumMaster, times(1)).notify("Message for ScrumMasters");

    }

    @Test
    @DisplayName("LeadDeveloper gets notified from its Observer")
    void leadDeveloperGetsNotifiedByObserver() {
        //Arrange
        LeadDeveloper leadDeveloper = mock(LeadDeveloper.class);
        LeadDeveloperObserver leadDeveloperObserver = new LeadDeveloperObserver();
        leadDeveloperObserver.addUser(leadDeveloper);

        //Act
        leadDeveloperObserver.update("Message for LeadDevelopers");

        //Assert
        verify(leadDeveloper, times(1)).notify("Message for LeadDevelopers");

    }

    @Test
    @DisplayName("Team gets notified from its Observer")
    void teamGetsNotifiedByObserver() {
        //Arrange
        Developer developer = mock(Developer.class);
        TeamObserver teamObserver = new TeamObserver();
        teamObserver.addUser(developer);

        //Act
        teamObserver.update("Message for Team");

        //Assert
        verify(developer, times(1)).notify("Message for Team");

    }
}

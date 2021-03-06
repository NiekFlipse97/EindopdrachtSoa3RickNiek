package export;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectmanagement.Sprint;
import projectmanagement.SprintType;
import users.AbstractUser;
import users.Developer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private Report report;
    private Header header;
    private Footer footer;
    private List<AbstractUser> users;
    private Sprint sprint;

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

    @BeforeEach
    public void setObjects() {
        users = new ArrayList<>();
        Developer rick = mock(Developer.class);
        Developer niek = mock(Developer.class);
        when(rick.getName()).thenReturn("Rick");
        when(niek.getName()).thenReturn("Niek");
        users.add(rick);
        users.add(niek);

        int max = 10;
        int min = 0;
        int burnDown = new Random().nextInt(max - min + 1) + min;
        int effort = new Random().nextInt(max - min + 1) + min;

        sprint = new Sprint(effort, burnDown, SprintType.RELEASE);
        sprint.setUsers(users);
        sprint.setBusinessName("Avans");
        sprint.setProjectName("AvansDevops");
        sprint.setVersion("v1.0");

        header = new Header("Avans", "AbansDevops");
        header.setLogo("Logo");

        footer = new Footer(LocalDateTime.now(), "v1.0");

        report = new Report(header, users, burnDown, effort, footer);
    }

    @Test
    @DisplayName("Test if a report always had a header and footer")
    void ReportHasAHeaderAndFooter() {
        // Arrange

        // Act
        Header h = report.getHeader();
        Footer f = report.getFooter();

        // Assert
        assertNotNull(h);
        assertNotNull(f);
    }

    @Test
    @DisplayName("Test if a report can export to PNG")
    void ReportCanExportToPNG() {
        // Arrange
        String prefix = "PNG";
        String falsePrefix = "PDF";
        // Act
        sprint.exportReport(ExportTypes.PNG);

        // Assert
//        assertTrue(true);
        String content = outContent.toString().trim();
        assertTrue(content.contains(prefix.trim()));
        assertFalse(content.contains(falsePrefix.trim()));
    }

    @Test
    @DisplayName("Test if a report can export to PDF")
    void ReportCanExportToPDF() {
        // Arrange
        String prefix = "PDF";
        String falsePrefix = "PNG";

        // Act
        sprint.exportReport(ExportTypes.PDF);

        // Asset
        assertTrue(true);
        String content = outContent.toString().trim();
        assertTrue(content.contains(prefix.trim()));
        assertFalse(content.contains(falsePrefix.trim()));
    }

    @Test
    @DisplayName("Test if export factory returns null if no export type is given")
    void ExportFactoryReturnsNullIsNoValidExportTypeIsGiven() {
        // Arrange

        // Act
        // Assert
        assertThrows(NullPointerException.class, () -> {
            sprint.exportReport(null);
        });
    }

}

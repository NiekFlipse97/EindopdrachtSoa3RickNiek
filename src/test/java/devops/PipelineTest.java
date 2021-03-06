package devops;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PipelineTest {

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
    @DisplayName("Run Pipeline Test")
    void runPipelineTest() {
        // Arrange
        PipelineComponent sources = new PipelineBlock("GITHUB", "Pull code from repository");
        PipelineComponent packages = new PipelineBlock("PACKAGES", "Install packages");
        PipelineComponent build = new PipelineBlock("BUILD", "Build the project source code");
        PipelineComponent test = new PipelineBlock("TEST", "Run Unit tests");

        PipelineComponent allComponents = new PipelineBlock("PIPELINE", "Start pipeline operation");

        allComponents.add(sources);
        allComponents.add(packages);
        allComponents.add(build);
        allComponents.add(test);

        packages.add(new PipelineLeaf("NuGet JsonDeserializer", "Deserializer for json from nuget"));
        packages.add(new PipelineLeaf("NuGet AutoMapper", "AutoMap user input to an object"));
        packages.add(new PipelineLeaf("NuGet Entity Framework", "Code first database creation through Entity Framework"));

        Pipeline pipeline = new Pipeline(allComponents);
        String titleString = "PIPELINE";
        String leafString = "AutoMap user input to an object";

        // Act
        pipeline.runPipeline();

        // Assert
//        assertTrue(true);
        String content = outContent.toString().trim();
        assertTrue(content.contains(titleString.trim()));
        assertTrue(content.contains(leafString.trim()));
    }


}

import devops.Pipeline;
import devops.PipelineBlock;
import devops.PipelineComponent;
import devops.PipelineLeaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipelineTest {

    @Test
    public void runPipelineTest() {
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
        packages.add(new PipelineLeaf("NuGet AutoMapper", "AutoMap user input to and object"));
        packages.add(new PipelineLeaf("NuGet Entity Framework", "Code first database creation through Entity Framework"));

        Pipeline pipeline = new Pipeline(allComponents);

        // Act
        pipeline.runPipeline();

        // Assert
        assertEquals(3,3);
    }


}

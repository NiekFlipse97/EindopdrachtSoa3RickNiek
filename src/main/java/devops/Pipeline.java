package devops;

public class Pipeline {

    private PipelineComponent allComponents;

    public Pipeline(PipelineComponent allComponents) {
        this.allComponents = allComponents;
    }

    /**
     * Start the pipeline and iterate through all the pipeline components.
     */
    public void runPipeline() {
        allComponents.print();
    }

}

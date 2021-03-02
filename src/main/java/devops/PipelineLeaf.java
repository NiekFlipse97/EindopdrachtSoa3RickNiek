package devops;

public class PipelineLeaf extends PipelineComponent {

    private final String name;
    private final String description;

    public PipelineLeaf(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("  - " + getName());
        System.out.println("      - " + getDescription());
    }

}

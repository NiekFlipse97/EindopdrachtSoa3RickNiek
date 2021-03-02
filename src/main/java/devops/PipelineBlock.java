package devops;

import java.util.ArrayList;
import java.util.Iterator;

public class PipelineBlock extends PipelineComponent {

    private ArrayList<PipelineComponent> pipelineComponents = new ArrayList<>();
    private String name;
    private String description;

    public PipelineBlock(String name, String description) {
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
    public void add(PipelineComponent pipelineComponent) {
        this.pipelineComponents.add(pipelineComponent);
    }

    @Override
    public void print() {
        System.out.println("\n" + getName());
        System.out.println("---------------------------");
        System.out.println(getDescription());

        Iterator<PipelineComponent> iterator = pipelineComponents.iterator();
        while(iterator.hasNext()) {
            PipelineComponent pipelineComponent = iterator.next();
            pipelineComponent.print();
        }
    }


}

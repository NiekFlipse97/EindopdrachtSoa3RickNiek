package discussionThreads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Thread extends FormComponent {
    private List<FormComponent> formComponentList = new ArrayList<>();
    private String name;
    private String description;

    public Thread(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void add(FormComponent formComponent) {
        this.formComponentList.add(formComponent);
    }

    @Override
    public void print() {
        System.out.println("\n " + getName());
        System.out.println("Message: " + getDescription());

        Iterator<FormComponent> iterator = formComponentList.iterator();
        while(iterator.hasNext()) {
            FormComponent formComponent = iterator.next();
            formComponent.print();
        }
    }
}

package discussionthreads;

import observers.TeamObserver;
import users.Developer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Thread extends FormComponent {
    private List<FormComponent> formComponentList = new ArrayList<>();
    private String name;
    private String description;
    private Developer developer;
    private TeamObserver teamObserver;

    private boolean closed = false;

    public Thread(Developer developer, String name, String description, TeamObserver teamObserver) {
        this.developer = developer;
        this.name = name;
        this.description = description;
        this.teamObserver = teamObserver;
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
    public void setClosed(boolean isClosed) {
        this.closed = isClosed;
    }

    public boolean getClosed() {
        return this.closed;
    }

    @Override
    public void add(FormComponent formComponent) {
        if (!closed) {
            this.formComponentList.add(formComponent);
            teamObserver.update("Comment is placed under thread: " + getName());
        }
    }

    @Override
    public Developer getDeveloper() {
        return developer;
    }

    @Override
    public void print() {
        System.out.println("\n-{" + getDeveloper().getName() + "}-" );
        System.out.print(getName());
        System.out.println(" - " + getDescription());

        Iterator<FormComponent> iterator = formComponentList.iterator();
        while(iterator.hasNext()) {
            FormComponent formComponent = iterator.next();
            formComponent.print();
        }
    }
}

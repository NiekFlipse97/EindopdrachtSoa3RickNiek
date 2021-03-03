package projectManagement;

import export.*;
import projectManagement.sprintStates.*;
import users.AbstractUser;

import javax.xml.stream.FactoryConfigurationError;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Sprint {

    AbstractSprintState createdState;
    AbstractSprintState inProgressState;
    AbstractSprintState finishedState;
    AbstractSprintState reviewState;
    AbstractSprintState releaseState;

    AbstractSprintState currentState;

    public String sprintName;
    public LocalDateTime startDate;
    public LocalDateTime endDate;

    private List<AbstractUser> users;
    private String businessName;
    private String projectName;
    private String version;
    private int effort;
    private int burnDownChart;

    public Sprint(int effort, int burnDownChart) {
        createdState = new CreatedState(this);
        inProgressState = new InProgressState(this);
        finishedState = new FinishedState(this);
        reviewState = new ReviewState(this);
        releaseState = new ReleaseState(this);

        currentState = createdState;

        this.effort = effort;
        this.burnDownChart = burnDownChart;
    }

    /**
     * TODO: BURNDOWN CHART
     */
    public void exportReport(ExportTypes exportTypes) {
        Header header = new Header(businessName, projectName);
        Footer footer = new Footer(LocalDateTime.now(), version);
        Report report = new Report(header, users, burnDownChart, effort, footer);

        FileExportFactory fileExportFactory = new FileExportFactory();
        fileExportFactory.getFileExporter(exportTypes).export(report);
    }

    public void startSprint() {
        currentState.startSprint();
    }

    public void toFinishedState() {
        currentState.toFinishedState();
    }

    public void toReviewState() {
        currentState.toReviewState();
    }

    public void setState(AbstractSprintState state) {
        this.currentState = state;
    }

    public AbstractSprintState getCreatedState() {
        return createdState;
    }

    public AbstractSprintState getInProgressState() {
        return inProgressState;
    }

    public AbstractSprintState getFinishedState() {
        return finishedState;
    }

    public AbstractSprintState getReviewState() {
        return reviewState;
    }

    public AbstractSprintState getReleaseState() {
        return releaseState;
    }

    public AbstractSprintState getCurrentState() {
        return currentState;
    }

    public String getSprintName() {
        return sprintName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}

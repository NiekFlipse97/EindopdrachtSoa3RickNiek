package projectmanagement;

import export.*;
import projectmanagement.sprintstates.*;
import users.AbstractUser;
import users.Developer;
import users.ScrumMaster;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sprint {
    AbstractSprintState createdState;
    AbstractSprintState inProgressState;
    AbstractSprintState finishedState;
    AbstractSprintState reviewState;
    AbstractSprintState releaseState;
    AbstractSprintState canceledState;

    AbstractSprintState currentState;

    private String sprintName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<BacklogItem> backlogItems;
    private List<AbstractUser> users;
    private String businessName;
    private String projectName;
    private String version;
    private final int effort;
    private final int burnDownChart;
    private SprintType sprintType;
    private String summary = null;
    private ScrumMaster scrumMaster;

    public Sprint(int effort, int burnDownChart, SprintType sprintType) {
        createdState = new CreatedState(this);
        inProgressState = new InProgressState(this);
        finishedState = new FinishedState(this);
        reviewState = new ReviewState(this);
        releaseState = new ReleaseState(this);
        canceledState = new CanceledState(this);

        currentState = createdState;

        this.backlogItems = new ArrayList<>();
        this.effort = effort;
        this.burnDownChart = burnDownChart;
        this.sprintType = sprintType;
    }

    public void exportReport(ExportTypes exportTypes) {
        Header header = new Header(businessName, projectName);
        Footer footer = new Footer(LocalDateTime.now(), version);
        Report report = new Report(header, users, burnDownChart, effort, footer);

        FileExportFactory fileExportFactory = new FileExportFactory();
        fileExportFactory.getFileExporter(exportTypes).export(report);
    }

    public void addBacklogItem(BacklogItem item) {
        if (currentState != createdState) return;

        backlogItems.add(item);
    }

    public void addSummary(String summary) {
        this.summary = summary;
    }

    public Boolean hasSummary() {
        if (summary != null) {
            return true;
        }
        return false;
    }

    public Boolean allBacklogItemsDone() {
        for (BacklogItem backlogItem : backlogItems) {
            if (backlogItem.getCurrentState() != backlogItem.getDoneState()) {
                return false;
            }
        }
        return true;
    }

    public void setSprintName(String name) {
        if (currentState != createdState) return;

        this.sprintName = name;
    }

    public void setStartDate(LocalDateTime dateTime) {
        if (currentState != createdState) return;

        this.startDate = dateTime;
    }

    public void setEndDate(LocalDateTime dateTime) {
        if (currentState != createdState) return;

        this.endDate = dateTime;
    }

    public void setUsers(List<AbstractUser> users) {
        this.users = users;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setState(AbstractSprintState state) {
        this.currentState = state;
    }

    public void setScrumMaster(ScrumMaster scrumMaster) {
        this.scrumMaster = scrumMaster;
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

    public AbstractSprintState getCanceledState() {
        return canceledState;
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

    public SprintType getSprintType() {
        return sprintType;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }
}

package projectmanagement.sprintstates;

import projectmanagement.Sprint;

import java.time.LocalDateTime;

public class InProgressState extends AbstractSprintState {

    Sprint sprint;

    public InProgressState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toFinishedState() {
        if (Boolean.TRUE.equals(sprint.allBacklogItemsDone()) || LocalDateTime.now().isAfter(sprint.getEndDate())) {
            sprint.setState(sprint.getFinishedState());
        }
    }

}

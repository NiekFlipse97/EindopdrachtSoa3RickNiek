package projectmanagement.sprintstates;

import projectmanagement.Sprint;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class InProgressState extends AbstractSprintState {

    Sprint sprint;

    public InProgressState(Sprint sprint) {
        this.sprint = sprint;
    }

    @Override
    public void toFinishedState() {
        if (sprint.allBacklogItemsDone() || LocalDateTime.now().isAfter(sprint.getEndDate())) {
            sprint.setState(sprint.getFinishedState());
        }
    }

}

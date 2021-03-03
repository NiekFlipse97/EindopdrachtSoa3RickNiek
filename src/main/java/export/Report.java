package export;

import users.AbstractUser;

import java.util.List;

public class Report {

    private final Header header;

    private final List<AbstractUser> users;
    private final int burnDownChart;
    private final int effort;

    private final Footer footer;

    public Report(Header header, List<AbstractUser> users, int burnDownChart, int effort, Footer footer) {
        this.header = header;
        this.users = users;
        this.burnDownChart = burnDownChart;
        this.effort = effort;
        this.footer = footer;
    }

    public Header getHeader() {
        return header;
    }

    public String getUserNames() {
        StringBuilder names = new StringBuilder();

        for (AbstractUser user : users) {
            names.append(String.format("\n %s", user.getName()));
        }

        return names.toString();
    }

    public int getBurnDownChart() {
        return burnDownChart;
    }

    public int getEffort() {
        return effort;
    }

    public Footer getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "| " + getHeader().toString() + "\n\n" + getUserNames() + "\n" + getBurnDownChart() + "\n" + getEffort() + "\n\n" + getFooter().toString();
    }
}

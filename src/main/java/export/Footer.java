package export;

import java.time.LocalDateTime;

public class Footer {

    private LocalDateTime dateTime;
    private String version;

    public Footer(LocalDateTime dateTime, String version) {
        this.dateTime = dateTime;
        this.version = version;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return String.format("| %s - %s", dateTime.toString(), version);
    }
}

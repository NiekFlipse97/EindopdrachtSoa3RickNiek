package adapters;

import externalpseudolibraries.SlackNotifierV1;

public class SlackNotifierAdapterV1 implements INotifierAdapter {
    private String newMessage = "Slack V1: ";
    private SlackNotifierV1 notifier = new SlackNotifierV1();

    @Override
    public void passMessage(String message) {
        newMessage += message;
        notifier.notify(newMessage);
    }
}

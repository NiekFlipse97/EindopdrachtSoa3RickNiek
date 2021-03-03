package adapters;

import externalpseudolibraries.SlackNotifierV2;

public class SlackNotifierAdapterV2 implements INotifierAdapter {
    private String newMessage = "Slack V2: ";
    private SlackNotifierV2 notifier = new SlackNotifierV2();

    @Override
    public void passMessage(String message) {
        newMessage += message;
        notifier.notify(newMessage);
    }
}

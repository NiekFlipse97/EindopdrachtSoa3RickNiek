package adapters;

import externalpseudolibraries.MailNotifierV1;

public class MailNotifierAdapterV1 implements INotifierAdapter {
    private String newMessage = "Mail V1: ";
    private MailNotifierV1 notifier = new MailNotifierV1();

    @Override
    public void passMessage(String message) {
        newMessage += message;
        notifier.notify(newMessage);
    }
}

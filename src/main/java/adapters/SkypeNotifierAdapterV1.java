package adapters;

import externalPseudoLibraries.SkypeNotifierV1;

public class SkypeNotifierAdapterV1 implements INotifierAdapter{
    private String newMessage = "Skype V1: ";
    private SkypeNotifierV1 notifier = new SkypeNotifierV1();

    @Override
    public void passMessage(String message) {
        newMessage += message;
        notifier.notify(newMessage);
    }
}
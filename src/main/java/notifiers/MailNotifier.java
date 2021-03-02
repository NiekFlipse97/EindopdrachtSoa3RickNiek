package notifiers;

import adapters.INotifierAdapter;
import adapters.MailNotifierAdapterV1;

public class MailNotifier implements INotifier {
    private INotifierAdapter adapter = new MailNotifierAdapterV1();

    @Override
    public void notify(String message) {
        adapter.passMessage(message);
    }
}

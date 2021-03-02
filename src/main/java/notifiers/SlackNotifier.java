package notifiers;

import adapters.INotifierAdapter;
import adapters.SlackNotifierAdapterV1;

public class SlackNotifier implements INotifier {
    private INotifierAdapter adapter = new SlackNotifierAdapterV1();

    @Override
    public void notify(String message) {
        adapter.passMessage(message);
    }
}

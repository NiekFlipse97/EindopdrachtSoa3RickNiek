package notifiers;

import adapters.INotifierAdapter;
import adapters.SlackNotifierAdapterV1;
import adapters.SlackNotifierAdapterV2;

public class SlackNotifier implements INotifier {
    private INotifierAdapter adapter = new SlackNotifierAdapterV1();
    private INotifierAdapter adapter2 = new SlackNotifierAdapterV2();

    @Override
    public void notify(String message) {
        adapter.passMessage(message);
        adapter2.passMessage(message);
    }
}

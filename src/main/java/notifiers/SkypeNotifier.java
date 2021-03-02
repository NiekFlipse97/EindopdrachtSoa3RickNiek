package notifiers;

import adapters.INotifierAdapter;
import adapters.SkypeNotifierAdapterV1;

public class SkypeNotifier implements INotifier {
    private INotifierAdapter adapter = new SkypeNotifierAdapterV1();

    @Override
    public void notify(String message) {
        adapter.passMessage(message);
    }
}

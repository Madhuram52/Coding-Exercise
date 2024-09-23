import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Channel implements Subject {
    private List<Subscriber> subscribers;
    private String title;
    private static final Logger logger = Logger.getLogger(Channel.class.getName());

    public Channel() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber sub) {
        if (sub == null || subscribers.contains(sub)) {
            logger.warning("Subscriber is either null or already subscribed.");
            return;
        }
        subscribers.add(sub);
        logger.info(sub.getName() + " has subscribed to the channel.");
    }

    @Override
    public void unsubscribe(Observer sub) {
        if (sub == null || !subscribers.contains(sub)) {
            logger.warning("Subscriber is either null or not subscribed.");
            return;
        }
        subscribers.remove(sub);
        logger.info("A subscriber has been unsubscribed.");
    }

    @Override
    public void notifySubscriber() {
        for (Observer sub : subscribers) {
            sub.update();
        }
    }

    @Override
    public void upload(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
        logger.info("New video uploaded: " + title);
        notifySubscriber();
    }

    public String getTitle() {
        return this.title;
    }

    // New method to get the list of subscribers
    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}

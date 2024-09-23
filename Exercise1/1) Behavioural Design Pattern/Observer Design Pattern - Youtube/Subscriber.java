public class Subscriber implements Observer {
    private String name;
    private Channel channel;

    public Subscriber(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Subscriber name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public void update() {
        if (channel == null || channel.getTitle() == null) {
            return;
        }
        System.out.println("Hey " + name + ", a new video titled '" + channel.getTitle() + "' has been uploaded.");
    }

    @Override
    public void subscribeChannel(Channel ch) {
        if (ch == null) {
            throw new IllegalArgumentException("Channel cannot be null.");
        }
        this.channel = ch;
    }

    public String getName() {
        return this.name;
    }
}

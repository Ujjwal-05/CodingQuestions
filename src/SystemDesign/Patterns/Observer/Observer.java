package SystemDesign.Patterns.Observer;
import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String videoTitle);
}

class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " got notification: New video uploaded -> " + videoTitle);
    }
}

class YouTubeChannel {

    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void uploadVideo(String title) {
        System.out.println("Channel uploaded: " + title);
        notifySubscribers(title);
    }

    private void notifySubscribers(String title) {
        for (Subscriber s : subscribers) {
            s.update(title);
        }
    }
}

public class Observer {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Subscriber u1 = new User("Ujjwal");
        Subscriber u2 = new User("Aman");

        channel.subscribe(u1);
        channel.subscribe(u2);

        channel.uploadVideo("Observer Design Pattern in Java");
    }
}


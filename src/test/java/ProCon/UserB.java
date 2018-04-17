package ProCon;

/**
 * Created by Lidd on 2018/4/17.
 */
public class UserB implements Receiver {

    public void receive(Message message) {
        System.out.println("userB receive " + message.title());
    }

    public void subscribe(Sender sender) {
        sender.add(this);
    }
}

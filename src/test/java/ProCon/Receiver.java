package ProCon;

/**
 * Created by Lidd on 2018/4/17.
 */
public interface Receiver {

    void receive(Message message);

    void subscribe(Sender sender);
}

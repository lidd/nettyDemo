package ProCon;

/**
 * Created by Lidd on 2018/4/17.
 */
public interface Sender {

    void send(Message msg);

    void add(Receiver receiver);
}

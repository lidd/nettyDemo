package ProCon;

import com.zsy.netty.demo.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lidd on 2018/4/17.
 */
public class TopicASender implements Sender {

    private Set<Receiver> receivers = new HashSet<Receiver>();

    public void send(Message msg) {
        for (Receiver user : receivers) {
            user.receive(msg);
        }
    }

    public void add(Receiver receiver) {
        receivers.add(receiver);
    }
}

package ProCon;

/**
 * Created by Lidd on 2018/4/17.
 */
public class UserA implements Receiver {

    public void receive(Message message){
        System.out.println("userA receive " + message.content());
    }

    public void subscribe(Sender sender) {
        sender.add(this);
    }

    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserA userA = (UserA) o;

        return id == userA.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public UserA(int id) {
        this.id = id;
    }
}

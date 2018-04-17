package ProCon;

/**
 * Created by Lidd on 2018/4/17.
 */
public class Test {
    public static void main(String[] args) {
        TopicASender topicASender = new TopicASender();

        UserA userA = new UserA(1);
        userA.subscribe(topicASender);
        UserB userB = new UserB();
        userB.subscribe(topicASender);
        UserA userA1 = new UserA(2);
        topicASender.add(userA);
        topicASender.add(userA1);
        topicASender.add(userB);

        Message todayMessage = new MakeMoneyMessage();

        topicASender.send(todayMessage);
    }
}

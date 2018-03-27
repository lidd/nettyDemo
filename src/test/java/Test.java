import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lidd on 2018/3/27.
 */
public class Test {

    public static void main(String[] args){
        List<Handler> handlers = new ArrayList<Handler>();

        handlers.add(new ADecoder());

        handlers.add(new BEncoder());

        handlers.add(new CCodec());

        System.out.println("数据进入(readBytes)");

        for (Handler handler : handlers) {
            handler.decode();
        }

        System.out.println("数据流出(writeAndFlush)");
        for (Handler handler : handlers) {
            handler.encode();
        }
    }
}

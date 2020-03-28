package inf112.RoboRally.app.Lan;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public void clientInit() throws IOException {
        Socket s = new Socket("127.0.0.1", 1337);
    }

}

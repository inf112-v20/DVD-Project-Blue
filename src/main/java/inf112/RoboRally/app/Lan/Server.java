package inf112.RoboRally.app.Lan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static int PORT = 1337;
    private static int[] ID = {1, 2, 3, 4, 5, 6, 7, 8};
    //static int connectedUsers = -1;

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    static int identities = clients.size();

    private static ExecutorService pool = Executors.newFixedThreadPool(8);

    public static void serverInit() throws IOException {

        ServerSocket ss = new ServerSocket(PORT);

        while (true) {
            System.out.println("Waiting for clients to connect...");
            Socket client = ss.accept();
            System.out.println("Client connected");
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);

            pool.execute(clientThread);

        }
    }

    public static int getRandomID() {

        return ID[identities];
    }
}

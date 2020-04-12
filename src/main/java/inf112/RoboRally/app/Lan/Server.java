package inf112.RoboRally.app.Lan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Server {




    private static int PORT = 1337;
    private static int[] ID = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final ReentrantLock lock = new ReentrantLock();
    //static int connectedUsers = -1;

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    //static int identities = clients.size();

    private static ExecutorService pool = Executors.newFixedThreadPool(8);

    public static void serverInit(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(PORT);

        while (true) {
            System.out.println("Waiting for clients to connect...");
            Socket client = ss.accept();
            System.out.println("Client connected");
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);

            pool.execute(clientThread);

        }
    }


    // Replace 1-8 ID with random generated IDs.
    // Needs to be done for security.
    public static int getRandomID() {

        lock.lock();
        try {
            int identities = clients.size();
            return ID[identities - 1];
        } finally {
            lock.unlock();
        }
    }




}

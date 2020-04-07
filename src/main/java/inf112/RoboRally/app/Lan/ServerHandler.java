package inf112.RoboRally.app.Lan;

import java.io.*;
import java.net.Socket;

public class ServerHandler implements Runnable {

    private Socket server;
    private BufferedReader in;


    public ServerHandler(Socket s) throws IOException {

        server = s;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));

    }


    boolean runnning = true;

    @Override
    public void run() {
        try {
            while (runnning) {
                String serverResponse = null;
                serverResponse = in.readLine();
                if (serverResponse == null) break;
                System.out.println("Response: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

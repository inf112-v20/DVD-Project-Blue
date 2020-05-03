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




                // Handle responses from the Server
                // E.G., (uses methods from the Client class)
                if (serverResponse.equals("test")) {
                    System.out.println("test");
                    Client.test();
                }


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

package inf112.RoboRally.app.Lan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);

    }



    boolean runnning = true;

    @Override
    public void run() {

        try {
            while (runnning) {
                String request = in.readLine();
                if (request.contains("IDnum")) {
                    out.println(Server.getRandomID());
                } else {
                    out.println("get an ID number");
                }
            }
        } catch (IOException e){
          System.err.println("error: " + e.getStackTrace());
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                System.err.println("error: " + e.getStackTrace());
            }
        }
    }
}

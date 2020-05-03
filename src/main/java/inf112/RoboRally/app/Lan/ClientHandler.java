package inf112.RoboRally.app.Lan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);

    }


    // Send method will send to all clients!
    private void send(String msg) {
        for (ClientHandler aClient : clients) {
            aClient.out.println(msg);
        }
    }


    boolean runnning = true;

    String message = "Succsess!";

    @Override
    public void run() {

        try {
            while (runnning) {
                String request = in.readLine();
                /*
                Responds with ID
                Need to make it so that client asks for ID when connecting and store their unique ID.
                Need to make a way to avoid two clients getting same ID!
                 */
                if (request.contains("getID")) {
                    out.println(Server.getRandomID());

                /*
                Need to store positions variables somehow and respond... (client side? If so needs to make server ask for clients
                posititons...) (Server.getPositions(); ???)
                atm it will just respond to all users with strings...
                 */
                } else if (request.startsWith("getPos")){
                    int firstSpace = request.indexOf(" ");
                    if (firstSpace != 1) {
                        send(request.substring(firstSpace + 1));
                    }

                /*
                respond HP...
                 */
                } else if (request.startsWith("getHP")) {

                    send(message);
                    //out.println(message);

                } else if (request.startsWith("test")) {
                out.println(Server.responseTest());




                } else {
                    // All clients must all have their own unique ID.
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

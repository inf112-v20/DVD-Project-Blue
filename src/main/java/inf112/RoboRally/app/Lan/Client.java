package inf112.RoboRally.app.Lan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 1337;


    public void clientInit() throws IOException {
        Socket s = new Socket(IP, PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);


        Boolean running = true;



        // TODO: change from chat client to game client
        // E.G., remove keyboard interaction.

        while (running) {
            System.out.println(">_ ");
            String command = keyboard.readLine();

            if (command.equals("disconnect")) break;

            out.println(command);

            String serverResponse = input.readLine();
            System.out.println("Response: " + serverResponse);

        }
    }
}

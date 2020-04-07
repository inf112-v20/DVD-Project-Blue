package inf112.RoboRally.app.Lan;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 1337;

    public static void clientInit(String[] args) throws IOException {
        Socket s = new Socket(IP, PORT);


        ServerHandler fromServer = new ServerHandler(s);

        new Thread(fromServer).start();



        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);


        Boolean running = true;

        while (running) {
            System.out.println(">_ ");
            String command = keyboard.readLine();

            // Figure out how to replace keyboard -> send message when connecting!


            // TODO: make disconnect send a disconnect message to server
            if (command.equals("disconnect")) break;

            out.println(command);

        }
        s.close();
    }
}
package inf112.RoboRally.app.lan;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{

    private static final String IP = "127.0.0.1";
    private static final int PORT = 1337;

    private static int ID = 0;

    private static Socket s;

    // Player vars
    // Get them from somewhere...
    private int HP = 9;
    private int lives = 3;
    private int posX = 0;
    private int posY = 0;



    public void clientInit(String ip) throws IOException {
        s = new Socket(ip, PORT);


        ServerHandler fromServer = new ServerHandler(s);

        new Thread(fromServer).start();



        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);


        Boolean running = true;


        // Getting ID when connecting
        // Stuff that happends once when connecting
        out.println("getID");
        out.println("test");



        while (running) {


            // Temp keyboard functions for troubleshooting & testing!
            System.out.println(">_ ");
            String command = keyboard.readLine();


            // TODO: make disconnect send a disconnect message to server
            if (command.equals("disconnect")) break;

            out.println(command);

        }
        s.close();
    }

    // Here goes methods for sending stuff to server
    // Figure out what format to send information
    // Send like csv? e.g.,
    // 1,3,9,5,5 (ID, Lives, HP, Xpos, Ypos)
    // send state or moves?
    // E.g.,
    public static void test() {
        try {
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("test");
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println(e);
        }
    }

    @Override
    public void run() {

        try {
            clientInit("127.0.0.1");
        } catch (IOException e) {
            System.out.println("serverInit error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
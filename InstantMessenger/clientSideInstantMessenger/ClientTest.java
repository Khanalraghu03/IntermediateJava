package InstantMessenger.clientSideInstantMessenger;

import javax.swing.JFrame;

public class ClientTest {
    public static void main(String[] args) {
        Client c = new Client("127.0.0.1"); //server in same computer
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.startRunning();

    }

}


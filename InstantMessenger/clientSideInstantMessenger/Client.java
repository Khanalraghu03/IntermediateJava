package InstantMessenger.clientSideInstantMessenger;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String serverIP; //server's ip address
    private Socket connection;

    public Client(String host) {
        super("Client ");
        serverIP = host;
        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(
                (e) -> {
                    sendMessage(e.getActionCommand());
                    userText.setText("");
                });
        add(userText, BorderLayout.NORTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow), BorderLayout.CENTER);
        setSize(300,150);
        setVisible(true);

    }

    //connect to the server
    public void startRunning() {
        try {
            connectToServer();
            setUpStreams();
            whileChatting();

        } catch (EOFException e) {
            showMessage("\n Client terminated connection");
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            closeChat(); //close streams and sockets
        }
    }
    //connectToServer
    private void connectToServer() throws IOException {
        showMessage("Attempting connection... \n");
        connection = new Socket(InetAddress.getByName(serverIP), 6789);
        showMessage("Connected to: " + connection.getInetAddress().getHostName());

    }
    //setUpStreams
    private void setUpStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\nStreams are now good to go!\n");
    }
    //whileChatting
    private void whileChatting() throws IOException {
        ableToType(true);
        do {
            try {
                message = (String) input.readObject();
                showMessage("\n" + message);
            } catch (ClassNotFoundException e) {
                showMessage("\n I don't know that object type");
            }
        } while(!message.equals("SERVER - END"));
    }
    //closeChat: close the streams and sockets
    private void closeChat() {
        showMessage("\n closing chat down");
        ableToType(false);
        try {
            output.close();
            input.close();
            connection.close();
        } catch(IOException e) {e.printStackTrace();}


    }

    //sendMessage
    private void sendMessage(String message) {
        try {
            output.writeObject("CLIENT - " + message);
            output.flush();
            showMessage("\nCLIENT - "+ message);
        } catch(IOException e) {
            chatWindow.append("\n something messed up sending messagep");
        }
    }


    //showMessage
    private void showMessage(String text) {
        SwingUtilities.invokeLater(() -> chatWindow.append(text));
    }

    //ableToType
    private void ableToType(final boolean condition) {
        SwingUtilities.invokeLater(() -> userText.setEditable(condition));

    }

}


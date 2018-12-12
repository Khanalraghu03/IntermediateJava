package InstantMessenger.serverSideInstantMessenger;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends JFrame {
    private JTextField userText; //message from user
    private JTextArea chatWindow; //window to show message
    private ObjectOutputStream output; //flows from my computer to client
    private ObjectInputStream input; //{input is opposite}
    private ServerSocket server; //wait for everyone to connect to InstantMessenger.serverSideInstantMessenger {port, #poeple wait to connect}
    private Socket connection;

    //set up the GUI instant messaging
    public Server() {
        //add title on the window
        super("Instant Messenger");

        userText = new JTextField();
        userText.setEditable(false); //InstantMessenger.serverSideInstantMessenger is not allowed to put message until connected to user
        userText.addActionListener((e) -> {
                    //Whenever user sends a message do this:
                    sendMessage(e.getActionCommand());
                    userText.setText("");

            });
        add(userText, BorderLayout.NORTH);

        //This is where all the text is going to show up
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(300,150);
        setVisible(true);

    }
    //Set up and run the InstantMessenger.serverSideInstantMessenger
    public void startRunning() {
        try {
            //set up the InstantMessenger.serverSideInstantMessenger and give port number
            //backlog: how many people can wait to access the instant messenger
                //I only want 100 people to sit and wait
                //because that's how much my InstantMessenger.serverSideInstantMessenger can handle
            server = new ServerSocket(6789, 100);
            while(true) {
                try {
                    //connect and have conversation
                    waitForConnection();
                    setUpStreams(); //Stream Output and Input
                    whileChatting();

                } catch(EOFException e) { //End of connection error
                    //when conversation ended: show this message
                    showMessage("\n Server ended the connection");
                } finally {
                    closeChat();
                }
            }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    //wait for connection, once connected:
        //display connection info
    private void waitForConnection() throws IOException {
        showMessage("Waiting for someone to connect... \n");
        //Once someone wants to have conversation
            //InstantMessenger.serverSideInstantMessenger accepts a connection
        //Only accepts one time, does not accept nothing
        connection = server.accept(); //throws IOException
        showMessage(" Now connected to " + connection.getInetAddress().getHostName()); //IP address

    }

    //pathway to connection: to and from {get steam to send and receive data}
    private void setUpStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        //sometimes Bytes(BIOs) gets left over and you want to flush it out
        //send it to other person
        output.flush();

        input = new ObjectInputStream(connection.getInputStream());
        //only users can flush their BIOs

        showMessage("\n Steams are now setup! \n");

    }

    //whileChatting -> during the chat conversation
    private void whileChatting() throws IOException{
        String message = " You are now connected! ";
        sendMessage(message);
        ableToType(true);
        do {
            //have a conversation while conversation is not ended
                //by InstantMessenger.serverSideInstantMessenger and/or client
            try {
                message = (String) input.readObject();
                showMessage("\n" + message);
            } catch(ClassNotFoundException cNFE) {
                showMessage("\n user sent something weired {maybe trying to hack}");
            }
        } while(!message.equals("CLIENT - END"));

    }
    //closeChat:  close Streams and Sockets...
    private void closeChat() {
        showMessage("\n Closing connection...\n");
        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();

        }catch(IOException e) {
            e.printStackTrace();
        }

    }
    //sendMessage: send a message to client
    private void sendMessage(String message) {
        try{
            //whenever InstantMessenger.serverSideInstantMessenger sends stuff
            //Sends a message -> SERVER - "message"
            output.writeObject("SERVER - " + message);
            output.flush();//flush out the leftovers
            showMessage("\nSERVER - " + message);
        } catch(IOException e) {
            //append: stick this into the chat area so it is visible
            chatWindow.append("\n Message cannot be sent\n");

        }
    }
    //showMessage: updates chatWindow
    private void showMessage(final String text) {
        //set aside a thread: updates the part of the GUI
        SwingUtilities.invokeLater(() -> chatWindow.append(text));

    }
    //ableToType: let the InstantMessenger.serverSideInstantMessenger/user be able to type into their box
    private void ableToType(final boolean condition) {
        SwingUtilities.invokeLater(() -> userText.setEditable(condition));

    }

}

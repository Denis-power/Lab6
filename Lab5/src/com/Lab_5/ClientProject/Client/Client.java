package com.Lab_5.ClientProject.Client;

import com.Lab_5.ClientProject.Support.InputConsole;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

//установим связь с сервером
public class Client {

//    private static Charset charset = Charset.forName("UTF8");
    private static ByteBuffer readBuffer;
    private static String response;
    public static Socket clientSocket; //сокет для общения

    public static ObjectOutputStream out;

    //    public static DataOutputStream out2;

    public static DataInputStream in;
    private static byte[] readBytes = new byte[256];


    public static void main(String[] args) {
        try {
            try {

                System.out.println("Connecting to server...");
                // адрес - локальный хост, порт - 9093, такой же как у сервера
                clientSocket = new Socket("localhost", 9093); // этой строкой мы запрашиваем подключение к серверу
                System.out.println("Connecting to server " + clientSocket.getRemoteSocketAddress().toString() + " is succeed.");

                out = new ObjectOutputStream(clientSocket.getOutputStream());

                in = new DataInputStream(clientSocket.getInputStream());

                MyCommand myCommand = new MyCommand();
                    while (true) {
                        try {
                        myCommand = InputConsole.inputCommand();
                        if(myCommand.getCommandName().equals("exit")) {
                            System.out.println("The end of the client Program. Goodbye!");
                            break;
                        }

                        out.writeObject(myCommand);
                        out.flush();

                        in.read(readBytes);

                        response = new String(readBytes);
                        response = response.replaceAll("[^A-Za-zА-Яа-я0-9!?@/=+<>\n\r\s _-]", "");
                        System.out.println(response);
                    }
                        catch (Exception ex){
                            System.err.println(ex);
                            System.err.println("Error was got while getting the command.");
                        }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Client was closed...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

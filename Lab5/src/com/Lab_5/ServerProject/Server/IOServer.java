package com.Lab_5.ServerProject.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static int port = 4005;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(port); // серверсокет прослушивает порт 4004
                System.out.println("Server started!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept(); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться
                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода.
                    // теперь мы можем принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // и отправлять
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

//                    in.read; // ждём пока клиент что-нибудь нам напишет
//                    System.out.println(word);
                    // не долго думая отвечает клиенту
//                    out.write("Hello, It's server! Affirmative, you wrote : " + word + "\n");
                    out.flush(); // выталкиваем все из буфера

                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Server is closed");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

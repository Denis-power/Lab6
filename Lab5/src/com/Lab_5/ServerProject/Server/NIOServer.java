package com.Lab_5.ServerProject.Server;


import com.Lab_5.ClientProject.Client.MyCommand;
import com.Lab_5.ServerProject.Collection.Data;
import com.Lab_5.ServerProject.Support.Deserializer;
import com.Lab_5.ServerProject.Support.EnDeCodeServer;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class NIOServer {
    private Selector selector;
    private Data data;
    private InetSocketAddress listenAddress;
    private final static int PORT = 9093;

    public static void main(String[] args) throws Exception {
        try {
            new NIOServer("localhost", PORT).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NIOServer(String address, int port) throws IOException {
        listenAddress = new InetSocketAddress(address, PORT);
    }

    /**
     * Start the server
     *
     * @throws IOException
     */
    private void startServer() throws Exception {
        int counter = 0;
        boolean afterAccept = false;
        this.selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        // bind server socket channel to port
        serverChannel.socket().bind(listenAddress);
        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port >> " + PORT);
        while (true) {
            // wait for events

            int readyCount = selector.select();
            if (readyCount == 0) {
                continue;
            }

            // process selected keys...
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator iterator = readyKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();

                // Remove key from set so we don't process it twice
                iterator.remove();

                if (!key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) { // Accept client connections
                    this.accept(key);
                } else if (key.isReadable()) { // Read from client
                    System.out.println("Readable");//почему он заходит сюда после аксепта, если я отправлял еще ничего
                    this.read(key);
                } else if (key.isWritable()) {
                    System.out.println("Writable");//почему он сюда заходит, если я не запрашивал читать
                    this.send(key);
                }
            }
        }
    }

    // accept client connection
    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);
        Socket socket = channel.socket();
        SocketAddress remoteAddr = socket.getRemoteSocketAddress();
        System.out.println("Connected to: " + remoteAddr);
        /*
         * Register channel with selector for further IO (record it for read/write
         * operations, here we have used read operation)
         */
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    // read from the socket channel
    private void read(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(65535);

        //через инпуты и оутпуты читать нельзя, неблокирующий режим
        int numRead = -1;
        numRead = socketChannel.read(buffer);
        if (numRead == -1) {
            Socket socket = socketChannel.socket();
            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            System.out.println("Connection closed by client: " + remoteAddr);
            socketChannel.close();
            key.cancel();
        }
        if(numRead == 4) {//если не прочитал ничего, но непонятно почему сюда зашел
            socketChannel.register(this.selector, SelectionKey.OP_WRITE);
        }

        MyCommand myCommand = (MyCommand) Deserializer.byteBufferToObject(buffer, numRead);
        System.out.println(myCommand.toString());
        socketChannel.register(this.selector, SelectionKey.OP_WRITE);

//        byte[] data = new byte[numRead];
//        System.arraycopy(buffer.array(), 0, data, 0, numRead);
//        System.out.println("Got: " + new String(data));
    }

    private void send(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        Charset charset = Charset.forName("UTF-8");
        String strByteBuffer = "Message from Server!!!";
        socketChannel.write(charset.encode(strByteBuffer));//byteBuffer
        System.out.println("Response was send!");
        socketChannel.register(this.selector, SelectionKey.OP_READ);

        // Имеется более одной строки данных, перехватить одну строку данных
//        String outputData = data.substring(0, data.indexOf("\n") + 1);
//        System.out.println(outputData);
//        // Преобразуем строку вывода в байты в соответствии с кодировкой gbk и все равно помещаем в outputBuffer
//        ByteBuffer outputBuffer = EnDeCodeServer.encode("echo" + outputData);
//
//        //outputBuffer.hasRemaining () Определить, есть ли необработанные байты
//        // В неблокирующем режиме не гарантируется, что метод записи отправит все байты outputBuffer за один раз, но соблюдается принцип отправки столько, сколько может быть отправлено, поэтому мы должны принять цикл
//        while (outputBuffer.hasRemaining()) {
//            socketChannel.write(outputBuffer);
//        }
//
//        // Я думаю, это эквивалентно перемещению указателя стека и последующему удалению сегмента данных, на который не указывает
//        ByteBuffer temp = EnDeCodeServer.encode(outputData);
//        // Устанавливаем положение буфера на предел temp
//        buffer.position(temp.limit());
//        // Удаляем обработанные данные в буфере
//        buffer.compact();
//        // Если строка "bye \ r \ n" была выведена, отключите selectionKet и закройте SocketChannel
//        if (outputData.equals("bye\r\n")) {
//            key.cancel();
//            socketChannel.close();
//            System.out.println("Закройте соединение с клиентом !");
//        }
    }
}
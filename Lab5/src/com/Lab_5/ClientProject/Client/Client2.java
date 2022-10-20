//package com.Lab_5.ClientProject.Client;
//
//import java.io.*;
//import java.net.Socket;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.FileChannel;
//import java.nio.channels.ServerSocketChannel;
//import java.nio.channels.SocketChannel;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.EnumSet;
//
//public class Client2 {
//        public static void main(String[] args) throws IOException {
//            ServerSocketChannel serverSocket = null;
//            SocketChannel client = null;
//            serverSocket = ServerSocketChannel.open();
//            serverSocket.socket().bind(new InetSocketAddress(9093));
//            client = serverSocket.accept();
//            System.out.println("Connection Set:  " + client.getRemoteAddress());
//
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//
//
//
//            fileChannel.close();
//            System.out.println("File Received");
//            client.close();
//        }
//}

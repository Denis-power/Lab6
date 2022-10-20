//package com.Lab_5.ServerProject.Server;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.ServerSocket;
//import java.nio.channels.ClosedChannelException;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//import java.util.Iterator;
//import java.util.Set;
//
//public class NIOServer2 {
//    private boolean running;
//    private ServerSocketChannel serverSocketChannel;
//
//
//    public void run() {
//
//        try {
//
//            Selector selector = Selector.open();
//            serverSocketChannel = ServerSocketChannel.open();
//            serverSocketChannel.configureBlocking(false);
//            ServerSocket serverSocket = serverSocketChannel.socket();
//            serverSocket.bind(new InetSocketAddress(4004));
//
//
//            running = true;
//
//            @SuppressWarnings("unused")
//            SelectionKey serverAcceptKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//
//            while (running) {
//
//                try {
//
//                    selector.select();
//                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
//                    Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
//
//                    while (keyIterator.hasNext()) {
//
//                        SelectionKey key = (SelectionKey) keyIterator.next();
//                        keyIterator.remove();
//
//                        if (!key.isValid()) {
//                            continue;
//                        }
//                        CommunicationStatus commsState = (CommunicationStatus) key.attachment();
//
//                        if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
//
//                            acceptConnection(selector, key);
//
//                        } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
//
//                            if (commsState.getCurrentState() == CommunicationStatus.STATE_READ) {
//
//                                commsState.setSelectionKey(key);
//                                readFromSocketChannel(key);
//
//                            }
//                        } else if ((key.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
//
//                            if (commsState.getCurrentState() == CommunicationStatus.STATE_WRITE) {
//
//                                commsState.setSelectionKey(key);
//                                writeToSocketChannel(key);
//
//                            }
//                        }
//                    }
//
//                } catch (IOException e) {
//                    log.error("Selector IOException Occurred", e);
//                }
//            }
//
//        } catch (IOException e) {
//
//            log.error("Firmware Selector Thread: An IOException occurred", e);
//            System.exit(-1);
//
//        } catch (ClosedChannelException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}

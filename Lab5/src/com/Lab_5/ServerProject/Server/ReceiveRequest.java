package com.Lab_5.ServerProject.Server;

import com.Lab_5.ServerProject.Support.EnDeCodeServer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class ReceiveRequest {
    /**
     * Событие готовности процесса чтения
     * Поместите полученные данные в буфер
     *
     * @param key
     * @throws IOException
     */
    protected void receive(SelectionKey key) throws IOException {
        // Получаем вложения, связанные с SelectionKey
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        // Получаем Sockethannel, связанный с SelectionKey
        SocketChannel socketChannel = (SocketChannel) key.channel();
        // Создаем byteBuffer для хранения прочитанных данных
        ByteBuffer readBuffer = ByteBuffer.allocate(32);
        socketChannel.read(readBuffer);
        readBuffer.flip();


        // Устанавливаем ограничение буфера на емкость
        buffer.limit(buffer.capacity());
        // Копируем содержимое readBuffer в буфер
        // Предполагая, что емкость буфера достаточно велика, исключение переполнения буфера не будет
        buffer.put(readBuffer); // помещаем прочитанные данные в буфер
        System.out.println("Read: " + EnDeCodeServer.decode(buffer));
    }
}

package com.Lab_5.ServerProject.Server;

import com.Lab_5.ClientProject.Support.EnDeCodeClient;
import com.Lab_5.ServerProject.Support.EnDeCodeServer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SendResponse {

    /**
     * Обработка событий готовности к записи
     *
     * @param key
     * @throws IOException
     */
//    protected static void send(SelectionKey key) throws IOException {
//        // Получаем вложения, связанные с selectionKey
//        ByteBuffer buffer = (ByteBuffer) key.attachment();
//        SocketChannel socketChannel = (SocketChannel) key.channel();
//        // Есть две функции переворота:
//        // 1. Установить ограничение на текущее значение позиции
//        // 2. Установить позицию на 0
//        // Тогда обработанные данные - это прямые данные от позиции до лимита, то есть данные, которые вы только что прочитали
//        buffer.flip();
//        // Согласно кодировке gbk, конвертируем байты в буфере в строку
//        String data = EnDeCodeServer.decode(buffer);
//        // Если вы не читали строку данных, вернитесь между ними
//        if (data.indexOf("\r\n") == -1)
//            return;
//
//        // Имеется более одной строки данных, перехватить одну строку данных
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
//
//    }
}

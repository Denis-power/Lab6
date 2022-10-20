package com.Lab_5.ClientProject.Support;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class EnDeCodeClient {
    /**
     * Кодирование преобразует строку в ее собственную последовательность
     *
     * @param string
     * @return
     */
    private static ByteBuffer encode(String string, Charset charset) {
//        charset.enc
        return charset.encode(string);
    }

    /**
     * Декодирование Преобразование последовательности байтов в строку
     *
     * @param buffer
     * @return
     */
    private static String decode(ByteBuffer buffer, Charset charset) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }
}

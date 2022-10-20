package com.Lab_5.ServerProject.Support;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class EnDeCodeServer {
    private static Charset charset = Charset.forName("UTF8");
    /**
     * Кодирование преобразует строку в ее собственную последовательность
     *
     * @param string
     * @return
     */
    public static ByteBuffer encode(String string) {
        return charset.encode(string);
    }

    /**
     * Декодирование Преобразование последовательности байтов в строку
     *
     * @param buffer
     * @return
     */
    public static String decode(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }
}

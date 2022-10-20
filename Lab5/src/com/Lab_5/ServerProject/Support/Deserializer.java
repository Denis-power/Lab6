package com.Lab_5.ServerProject.Support;

import java.io.*;
import java.nio.ByteBuffer;

public class Deserializer {
    public static Object byteBufferToObject(ByteBuffer byteBuffer, int numRead)
            throws Exception {
        byte[] bytes = new byte[numRead];

        if(byteBuffer.get(0)!=-84){
            byteBuffer = addHeader(byteBuffer, numRead);
        }

        if(byteBuffer.hasArray())
            bytes = byteBuffer.array();
        else
            byteBuffer.get(bytes);
        Object object = deSerializer(bytes);
        return object;
    }

    public static Object deSerializer(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        return objectInputStream.readObject();
    }
    public static ByteBuffer addHeader(ByteBuffer byteBuffer, int numRead) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(4);
        header.put(0, (byte)-84);
        header.put(1, (byte)-19);
        header.put(2, (byte)0);
        header.put(3, (byte)-5);
        byteBuffer = ByteBuffer.allocate(numRead+4).put(header).put(byteBuffer);
        return byteBuffer;
    }
}

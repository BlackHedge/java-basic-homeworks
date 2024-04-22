package ru.chernov.java.basic.homeworks.homework13;

import java.io.*;

public class ExampleClient implements AutoCloseable {
    private final DataInputStream in;
    private final DataOutputStream out;

    public ExampleClient(InputStream in, OutputStream out) {
        this.in = new DataInputStream(in);
        this.out = new DataOutputStream(out);
    }

    public void send(String message) throws IOException {
        out.writeUTF(message);
        out.flush();
    }

    public void read() throws IOException {
        String inMessage = in.readUTF();
        System.out.println("server: " + inMessage);
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}

package ru.chernov.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler {
    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public ClientHandler(Socket clientSocket, DataInputStream in, DataOutputStream out) {
        this.clientSocket = clientSocket;
        this.in = in;
        this.out = out;
    }
}

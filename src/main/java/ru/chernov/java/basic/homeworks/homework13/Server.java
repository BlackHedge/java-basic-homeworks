package ru.chernov.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final List<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket client = serverSocket.accept();
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            ClientHandler clientHandler = new ClientHandler(client, in, out);
            clientHandlers.add(clientHandler);
            out.writeUTF("Доступные операции: + - * /\nВведите два числа и операцию через пробел: например, 4 + 5");
            out.flush();

            String userInput = in.readUTF();
            System.out.println("user: " + userInput);
            String result = calculateResult(userInput);
            out.writeUTF(result);
            System.out.println("me: " + result);
            out.flush();
        }
    }

    public static String calculateResult(String message) {
        String[] expression = message.split(" ");
        Integer result = 0;
        try {
            switch (expression[1]) {
                case "+":
                    result = Integer.parseInt(expression[0]) + Integer.parseInt(expression[2]);
                    break;
                case "-":
                    result = Integer.parseInt(expression[0]) - Integer.parseInt(expression[2]);
                    break;
                case "*":
                    result = Integer.parseInt(expression[0]) * Integer.parseInt(expression[2]);
                    break;
                case "/":
                    result = Integer.parseInt(expression[0]) / Integer.parseInt(expression[2]);
                    break;
                default:
                    return "Недопустимая команда. Повторите ввод";
            }
        } catch (Exception e) {
            return "Что-то пошло не так";
        }
        return "Ответ: " + result.toString();
    }
}

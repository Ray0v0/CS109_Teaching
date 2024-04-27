package messagingFramework;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    static Socket socket;
    static BufferedReader reader;
    static BufferedWriter writer;
    static TNetworkClient networkClient;

    public static void main(String[] args) {
        start();
        Scanner in = new Scanner(System.in);
        while (true) {
            sendMessage(in.nextLine());
            System.out.println(receiveMessage());
        }
    }
    public static void start() {
        startNetworkClient();
    }

    private static void sendMessage(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("警告：无法连接至服务端！");
        }
    }

    private static String receiveMessage() {
        String ret = null;
        try {
            ret = reader.readLine();
        } catch (IOException e) {
            System.out.println("警告：无法连接至服务端！");
        }
        return ret;
    }

    private static void startNetworkClient() {
        String host = "127.0.0.1";
        try {
            socket = new Socket(host, Configs.port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            System.out.println("提示：成功连接至服务端，开启连接线程");
            networkClient = new TNetworkClient();
            networkClient.start();
        } catch (IOException e) {
            System.out.println("警告：无法连接到服务端，请检查服务端是否已经启动，并检查地址与端口是否一致！");
        }
    }

    private static class TNetworkClient extends Thread {
        private boolean isRunning = false;
        @Override
        public void run() {
            isRunning = true;
            while (isRunning) {
                try {
                    String line = reader.readLine();
                    System.out.println("服务端：" + line);
                } catch (IOException e) {
                    System.out.println("警告：连接已断开，关闭连接线程！");
                    shutdown();
                }
            }
        }

        public boolean isRunning() {
            return isRunning;
        }

        public void shutdown() {
            isRunning = false;
        }
    }
}

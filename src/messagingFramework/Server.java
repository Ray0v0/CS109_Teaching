package messagingFramework;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    static BufferedReader reader;
    static BufferedWriter writer;
    static TNetworkServer networkServer;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        startNetworkServer();
    }

    private static void startNetworkServer() {
        try (ServerSocket ss = new ServerSocket(Configs.port, 0, InetAddress.getByName("127.0.0.1"))){
            System.out.println("提示：网络通讯服务端启动成功，等待客户端连接");
            Socket socket = ss.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            System.out.println("提示：收到连接请求，开启连接线程");
            networkServer = new TNetworkServer();
            networkServer.start();
            while (true) {
                writer.write(in.nextLine());
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("警告：端口" + Configs.port + "被占用，请修改端口后重试！");
            throw new RuntimeException(e);
        }
    }
    private static class TNetworkServer extends Thread {
        private boolean isRunning = false;
        @Override
        public void run() {
            isRunning = true;
            while (isRunning) {
                try {
                    String line = reader.readLine();
                    System.out.println("客户端：" + line);
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

package animation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class PixelControl {

    private static final JFrame frame = new JFrame();

    // 画板的分辨率
    private static final int panelWidth = 1024;
    private static final int panelHeight = 682;

    // 使用JPanel作为画板
    private static JPanel panel;

    // 使用一个int数组存储屏幕上像素的数值
    private static int[] screen;

    // 屏幕图像缓冲区，它提供了在内存中操作屏幕中图像的方法
    private static BufferedImage screenBuffer;

    // 记录帧数
    private static int frameIndex;

    // 设定帧数上限
    private static final int framePerSecond = 60;

    // 希望达到的每频之间的间隔时间 (毫秒)
    private static final int frameInterval = 1000 / framePerSecond;

    // 记录上次绘画时间
    private static long lastDraw;

    // 更新帧率显示时间
    private static final int fpsShowInterval = 1000;

    // 记录上次更新帧率时间
    private static long lastFpsUpdate;

    // 记录平均帧率
    private static int fpsPractical;

    // CPU休息时间
    private static int restTime;

    // CPU占用率
    private static int utilization;

    public static void main(String[] args) {
        // 创建窗体
        frame.setTitle("Java2DPaint");
        panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        panel.setMinimumSize(new Dimension(panelWidth, panelHeight));
        panel.setLayout(null);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 用TYPE_INT_RGB来创建BufferedImage，然后把屏幕的像素数组指向BufferedImage中的DataBuffer。
        // 这样通过改变屏幕的像素数组(screen[])中的数据，并调用panel.drawImage(screenBuffer, 0, 0, frame)方法就可以在屏幕中渲染出图像
        screenBuffer =  new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_RGB);
        DataBuffer dest = screenBuffer.getRaster().getDataBuffer();
        screen = ((DataBufferInt)dest).getData();


        while (true) {

            // ----------------具体绘制方法----------------

            int x = 100;
            int y = 100;
            int speed = 4;
            Color initColor = Color.orange;
            Color targetColor = Color.red;
            int nowColor = Color.orange.getRGB();

            while (true) {
                if (x > 300) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignore) {
                    }
                    break;
                }

                drawBackground();
                drawRectangle(300, 100, 100, 100, initColor);

                for (int i = x; i < x + 100; i++) {
                    for (int j = y; j < y + 100; j++) {
                        if (i < 300) {
                            screen[posTransform(i, j)] = initColor.getRGB();
                        } else {
                            screen[posTransform(i, j)] = nowColor;
                        }
                    }
                }

                x += speed;
                if (x > 200) {
                    nowColor += (targetColor.getRGB() - initColor.getRGB()) / (100 / speed);
                }

                // 计算帧率
                fpsHandle();

                // 显示绘制内容
                panel.getGraphics().drawImage(screenBuffer, 0, 0, frame);
            }
        }
    }

    private static void drawBackground() {
        for (int i = 0; i < panelWidth; i++) {
            for (int j = 0; j < panelHeight; j++) {
                screen[posTransform(i, j)] = Color.gray.getRGB();
            }
        }
    }

    private static void drawRectangle(int x, int y, int width, int height, Color color) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                if (legalPos(i, j)) {
                    screen[posTransform(i, j)] = color.getRGB();
                }
            }
        }
    }

    public static void fpsHandle() {
        frameIndex += 1;

        while (System.currentTimeMillis() - lastDraw < frameInterval) {
            try {
                Thread.sleep(1);
                restTime += 1;
            } catch (InterruptedException ignore) {
            }
        }

        //显示当前刷新率
        Graphics2D g2 = (Graphics2D) screenBuffer.getGraphics();
        g2.setColor(Color.BLACK);
        g2.drawString("FPS: " + fpsPractical + "     " + "Utilization: " + utilization + "%\t", 5, 15);



        if (System.currentTimeMillis() - lastFpsUpdate > fpsShowInterval) {
            fpsPractical = frameIndex;
            frameIndex = 0;
            lastFpsUpdate = System.currentTimeMillis();

            utilization = restTime * 100 / frameInterval / fpsPractical;
            restTime = 0;
        }

        lastDraw = System.currentTimeMillis();
    }

    private static int posTransform(int x, int y) {
        return y * panelWidth + x;
    }

    private static boolean legalPos(int x, int y) {
        return 0 <= x && x < panelWidth && 0 <= y && y < panelHeight;
    }
}

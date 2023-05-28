package lesson17;

import org.apache.log4j.Logger;

public class Pevec2 extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Pevec2.class);
    @Override
    public void run() {
        while (true) {
            synchronized (Monitors.MIKROFON) {
                LOGGER.debug("����� 2 ����");
                try {
                    Monitors.MIKROFON.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                LOGGER.debug("����� 2 ����");
                System.out.println("_______Fa_fa");
                try {
                    Thread.sleep(250);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MIKROFON) {
                Monitors.MIKROFON.notify();
            }
        }
    }
}

package lesson17;

import org.apache.log4j.Logger;

public class Pevec3 extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Pevec3.class);
    @Override
    public void run() {
        while (true) {
            synchronized (Monitors.MIKROFON) {
                LOGGER.debug("Певец 3 ждет");
                try {
                    Monitors.MIKROFON.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                LOGGER.debug("Певец 3 поет");
                System.out.println("___Do_do____");
                try {
                    Thread.sleep(300);
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

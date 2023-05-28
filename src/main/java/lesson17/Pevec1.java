package lesson17;

import org.apache.log4j.Logger;

public class Pevec1 extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Pevec1.class);
    private int count = 5;

    public Pevec1() {
    }
    public Pevec1(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        //лог певец 1 начал петь
        LOGGER.debug("Певец 1 начал петь");
        int j=0;
        while (j < count) {
            for (int i = 0; i < 3; i++) {
                System.out.println("La_la________");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MIKROFON) {
                LOGGER.debug("Певец 1 передал микрофон");
                //лог певец передал микрофон
                Monitors.MIKROFON.notify();
            }
            synchronized (Monitors.MIKROFON) {
                try {
                    LOGGER.debug("Певец 1 ждет");
                    // лог певец ждет
                    Monitors.MIKROFON.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}

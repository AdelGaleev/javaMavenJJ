package lesson17;


import org.apache.log4j.Logger;

public class Vedusiy {
    public static final Logger LOGGER = Logger.getLogger(Vedusiy.class);
    public static void main(String[] args) {
        // ��� ������� �������� �������
        LOGGER.debug("������� �������� �������");
        System.out.println("������� �������");
        Pevec1 pevec1 = new Pevec1();
        pevec1.setDaemon(true);
        Pevec2 pevec2 = new Pevec2();
        pevec2.setDaemon(true);
        Pevec3 pevec3 = new Pevec3();
        pevec3.setDaemon(true);
        // ��� ������� �������� ����� 1
        LOGGER.debug("������� �������� ����� 1");
        pevec1.start();
        LOGGER.debug("������� �������� ����� 2");
        pevec2.start();
        LOGGER.debug("������� �������� ����� 3");
        pevec3.start();


        try {
            Thread.sleep(5000);
        } catch (Exception e) {
           e.printStackTrace();
        }
        System.out.println("������� ����������");
    }
}

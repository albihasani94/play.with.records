package play.with.records;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) {
        // Show off about running on Java 14
        System.out.printf("Java Version: %s", ManagementFactory.getRuntimeMXBean().getVmVersion());
    }
}

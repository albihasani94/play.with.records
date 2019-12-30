package play.with.records;

import javafx.util.Pair;

import java.lang.management.ManagementFactory;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        // Show off about running on Java 14
        System.out.printf("Java Version: %s%n", ManagementFactory.getRuntimeMXBean().getVmVersion());

        // Person class in any java version
        Person first = new Person("Albi", 25);

        Consumer<Person> c1 = System.out::println;
        c1.accept(first);

        // Pair JavaFX prior to java 11
        Pair<String, Integer> nameAgePair = new Pair<>("Albi", 25);

        Consumer<Pair> c2 = System.out::println;
        c2.accept(nameAgePair);

        // Records in java 14
        record personRecord (String name,int age){
        }

    }
}

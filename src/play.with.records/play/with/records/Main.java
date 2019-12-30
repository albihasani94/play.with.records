package play.with.records;

import javafx.util.Pair;

import java.lang.management.ManagementFactory;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

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
        record PersonRecord (String name,int age){
            public PersonRecord(String name, int age){
                if (age > 120) {
                    throw new IllegalArgumentException("Sorry, age(%d) is too high".formatted(age));
                }
                this.name = name;
                this.age = age;
            }

            boolean isWise () {
                return age > 80;
            }
        }

        PersonRecord person = new PersonRecord("Albi", 25);

        Consumer<PersonRecord> c3 = System.out::println;
        c3.accept(person);

        PersonRecord wisePerson = new PersonRecord("Clint Eastwood", 95);

        System.out.printf("Is %s wise? %s%n", person.name, person.isWise() ? "yes" : "no");
        System.out.printf("Is %s wise? %s%n", wisePerson.name, wisePerson.isWise() ? "yes" : "no");

        try {
            PersonRecord reallyTooOldWoman = new PersonRecord("Victoria", 135);
            c3.accept(reallyTooOldWoman);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.INFO, "Exception caught: {0}", e.getMessage());
        }

        System.out.println("After exception");

    }
}

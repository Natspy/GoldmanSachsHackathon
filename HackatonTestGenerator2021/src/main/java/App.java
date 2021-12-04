import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        NonFunctionalTestGenerator nonFunctionalTestGenerator = new NonFunctionalTestGenerator(40);
        String[] funcArgs = {"30"};
        nonFunctionalTestGenerator.generateTest("Supermassive", funcArgs);

    }

}

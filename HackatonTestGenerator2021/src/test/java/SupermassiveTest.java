import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class SupermassiveTest {
@Test
void shouldCalculateCircle() {
Supermassive classObject = new Supermassive();
var methods = Supermassive.class.getDeclaredMethods();
ArrayList<String> methodsNames = new ArrayList<String>();
for (Method method : methods) {
String methodName = method.getName();
methodsNames.add(methodName);
 }
for (String method : methodsNames) {
long before = System.currentTimeMillis();
// function execution
classObject.massiveFunction(30);
// time 2
long now = System.currentTimeMillis();
//measure time
long between = now - before;
Assertions.assertTrue(between <=40);
}
}
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NonFunctionalTestGenerator {

    int tolerance;

    public NonFunctionalTestGenerator(int tolerance) {
        this.tolerance = tolerance;
    }

    public void generateTest(String fileName, String[] args) {

        String revMethod = "";
        String method = "";

        try {

            try {
                String workingDirectory = System.getProperty("user.dir");
                String file = workingDirectory + "/src/main/java/" + fileName + ".java";
                Path path = Paths.get(file);
                String fileContent = Files.readString(path);
                String[] result = fileContent.split("\n");


                for (String line : result) {
                    if (line.contains("(")) {
                        int i = line.indexOf('(');
                        while (line.charAt(i) != ' ') {
                            revMethod += line.charAt(i);
                            --i;
                        }
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < revMethod.length(); i++)
                method += revMethod.charAt((revMethod.length() - i) - 1);
            method = method.substring(0, method.length() - 1);

            String strArgs = "";
            for (String arg : args) {
                strArgs = arg + ",";
            }
            strArgs = strArgs.substring(0, strArgs.length() - 1);

            String workingDirectory = System.getProperty("user.dir");
            String file = workingDirectory + "/src/test/java/" + fileName + "Test.java";
            Path path = Paths.get(file);
            Files.writeString(path, "import org.junit.jupiter.api.Assertions;\nimport org.junit.jupiter.api.Test;\n" +
                            "import java.util.ArrayList;\n" + "import java.lang.reflect.Method;\n" +
                            "\npublic class " + fileName + "Test {\n@Test\nvoid shouldCalculateCircle() {\n" +
                            fileName + " classObject = new " + fileName + "();" +
                            "\nvar methods = " + fileName + ".class.getDeclaredMethods();\n" +
                            "ArrayList<String> methodsNames = new ArrayList<String>();\n" +
                            "for (Method method : methods) {\n" + "String methodName = method.getName();\n" +
                            "methodsNames.add(methodName);\n " + "}\n" +
                            "for (String method : methodsNames) {\n" +
                            "long before = System.currentTimeMillis();\n" +
                            "// function execution\n" +
                            "classObject." +  method + "(" + strArgs + ");\n" +
                            "// time 2\n" +
                            "long now = System.currentTimeMillis();\n" +
                            "//measure time\n" +
                            "long between = now - before;\n" +
                            "Assertions.assertTrue(between <=" + tolerance + ");\n" + "}\n" + "}\n" + "}\n",
                    StandardOpenOption.CREATE_NEW);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

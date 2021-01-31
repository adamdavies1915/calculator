package adam.md.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String filePath = "exampleCalc.txt";

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            List<String> list = stream.collect(Collectors.toList());
            Calculator calculator = new Calculator();
            try {
                String result = calculator.processApplyBlock(list);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Sorry something went wrong processing your file - please check and try again ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

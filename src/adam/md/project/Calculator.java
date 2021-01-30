package adam.md.project;

import java.util.Collections;
import java.util.List;

public class Calculator {


    String processApplyBlock(List<String> linesToBeCalced){
        Collections.reverse(linesToBeCalced);
        String result = linesToBeCalced.stream()
                .reduce("0", ((totalSoFar, line) -> {
                        String[] splitLine = line.split(" ");
                        if (splitLine.length > 2){
                            throw new Error("Too many operations on one line");
                        }
                        return applyOperations(totalSoFar, line.split(" ")[0], line.split(" ")[1]);
                        }
                    ));

        return result.toString();
    }

    String applyOperations(String totalSoFarString, String operation, String operandString){
        Integer operand = Integer.parseInt(operandString);
        Integer totalSoFar = Integer.parseInt(totalSoFarString);
        if (operation.equals("apply")){
            return operand.toString();
        }
        if (operation.equals("add")) {
            Integer result = (totalSoFar + operand);
            return result.toString();
        }
        if (operation.equals("multiply")){
            Integer result = (totalSoFar * operand);
            return result.toString();
        }
        else {
            throw new Error("Unsupported operation");
        }
    }

}

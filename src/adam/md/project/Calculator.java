package adam.md.project;

import java.util.List;

public class Calculator {

    String processApplyBlock(final List<String> linesToBeCalcedWithApply ) throws Exception {
        final String startingNumber = (linesToBeCalcedWithApply.get(linesToBeCalcedWithApply.size() - 1)).split(" ")[1];
        final List<String> linesToBeCalced = linesToBeCalcedWithApply.subList(0, linesToBeCalcedWithApply.size() - 1);
        String totalSoFar = startingNumber;
        for (String line: linesToBeCalced){
            String[] splitLine = line.split(" ");
            if (splitLine.length > 2){
                throw new Exception("Too many operations on one line");
            }
            totalSoFar = applyOperations(totalSoFar, splitLine[0],splitLine[1]);
        }

        return totalSoFar;
    }

    String applyOperations(final String totalSoFarString, final String operation, final String operandString) throws Exception {
        final Integer operand = Integer.parseInt(operandString);
        final Integer totalSoFar = Integer.parseInt(totalSoFarString);
        if (operation.equals("add")) {
            final Integer result = (totalSoFar + operand);
            return result.toString();
        }
        if (operation.equals("multiply")){
            final Integer result = (totalSoFar * operand);
            return result.toString();
        }
        else {
            throw new Exception("Unsupported operation in line");
        }
    }

}

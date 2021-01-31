package adam.md.project;

import java.util.List;

public class Calculator {

    String processApplyBlock(final List<String> linesToBeCalcedWithApply ){
        final String startingNumber = (linesToBeCalcedWithApply.get(linesToBeCalcedWithApply.size() - 1)).split(" ")[1];
        final List<String> linesToBeCalced = linesToBeCalcedWithApply.subList(0, linesToBeCalcedWithApply.size() - 1);

        final String result = linesToBeCalced.stream()
                .reduce(startingNumber, ((totalSoFar, line) -> {
                    String[] splitLine = line.split(" ");
                    try {
                        return applyOperations(totalSoFar, splitLine[0],splitLine[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                ));

        return result;
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

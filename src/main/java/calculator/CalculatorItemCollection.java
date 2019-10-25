package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorItemCollection {

    private final List<String> item;

    public CalculatorItemCollection(String input) {

        if (input == null) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        this.item = parsingItem(input);
        validateItem();
    }

    public List<String> getItem() {
        return item;
    }

    private void validateItem() {
        if (item.size() < 2 || item.size() % 2 == 0) {
            throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");
        }

        for (int i = 0; i < item.size(); i++) {
            if (i%2 == 0) {
                checkNumeric(item.get(i));
                continue;
            }

            checkOperator(item.get(i));
        }
    }

    private void checkNumeric(String s) {
        if (!isNumeric(s)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    private void checkOperator(String s) {
        if (!isOperator(s)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    private boolean isOperator(String s) {
        return OperatorType.getOperatorCodes().contains(s);
    }

    private boolean isNumeric(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<String> parsingItem(String input) {

        String[] split = input.split(" ");

        return Arrays.stream(split)
                .filter(a -> !"".equals(a))
                .collect(Collectors.toList());
    }
}

package pau.garcia.kata.StringCalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String NEGATIVE_VALUES_NOT_ALLOWED = "Negative values not allowed";

    public static int sum(String numbers) {
        if ("".equals(numbers)) return new Integer(0);
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }
        return sum(numbers, delimiter);
    }

    public static int sum(String numbers, String delimiter) {
        String[] params = numbers.split(delimiter + "|\n");
        String negativeNumbers = Arrays.stream(params)
            .filter(s -> s.startsWith("-"))
            .collect(Collectors.joining(delimiter));
        if (negativeNumbers.length() != 0) throw new RuntimeException(NEGATIVE_VALUES_NOT_ALLOWED + ":" + negativeNumbers);
        return Arrays.stream(params)
            .mapToInt(value -> Integer.parseInt(value))
            .filter(n -> n < 100)
            .sum();
    }
}

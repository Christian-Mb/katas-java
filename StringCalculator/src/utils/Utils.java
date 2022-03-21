package utils;

import exception.IncorrectValueException;
import log.ValueErrorType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Utils {

    public static final String SEPARATOR2 = "\n";
    public static final String SEPARATOR = ",";
    public static final String SEPARATOR3 = "//";
    public static final String EMPTY = "";

    private Utils() {
    }

    /**
     * Check if line if empty or null
     *
     * @param line : String of numbers to process
     * @return Boolean
     */
    public static boolean hasNoValues(String line) {
        return line == null || line.isEmpty();
    }

    /**
     * Split String basing on separator
     *
     * @param position   : Index
     * @param separator: Delimiter
     * @param line:      String to split
     * @return an String
     */
    public static String splitString(int position, String separator, String line) {
        return line.split(separator)[position];
    }

    /**
     * Get separator number
     *
     * @param line      : String of numbers to process
     * @param separator : Delimeter
     * @return separator's number
     */
    public static int getNumberOfDelimiter(String line, String separator) {
        return line.split(separator).length;
    }

    /**
     * Contain new line separator
     *
     * @param line : String of numbers to process
     * @return Boolean
     */
    public static boolean containNewLineDelimiter(String line) {
        return line.contains(SEPARATOR2);
    }

    /**
     * Handle the new line separator
     *
     * @param line      : String of numbers to process
     * @param separator : Delimeter
     * @return List of value from String
     */
    public static List<String> contructListFromString(String line, String separator) {
        int numberOfDelimiter = getNumberOfDelimiter(line, separator);
        List<String> values = new ArrayList<>();

        for (int n = 0; n < numberOfDelimiter; n++) {
            String value = splitString(n, separator, line);
            values.add(value.equals(SEPARATOR2) ? "0" : value);
        }
        return values;
    }

    /**
     * Get the given separator
     *
     * @param line : String of numbers to process
     * @return the given separator
     */
    public static String getSeparator(String line) {
        String delimiter = splitString(0, SEPARATOR2, line);
        return splitString(1, SEPARATOR3, delimiter);
    }

    /**
     * Build new String without new line delimeter
     *
     * @param sb        : String builder
     * @param value     : String of numbers to process
     * @param separator : Delimeter
     * @return An StringBuilder of value without new line separator
     */
    public static StringBuilder contructStringBuilder(StringBuilder sb, String value, String separator) {
        if (containNewLineDelimiter(value)) {
            sb.append(sum(value, SEPARATOR2)).append(separator);
        } else {
            sb.append(value).append(separator);
        }
        return sb;
    }

    /**
     * Sum values
     *
     * @param line       : String of numbers to process
     * @param separator: Delimeter
     * @return The sum
     */
    public static int sum(String line, String separator) {
        return Integer.parseInt(Arrays.stream(line.split(separator))
                .map(x -> BigDecimal.valueOf(handleException(x)))
                .reduce(BigDecimal.ZERO, BigDecimal::add).toPlainString());
    }

    /**
     * Handle negative value
     *
     * @param value : String of numbers to process
     * @return An Integer
     */
    public static int handleException(String value) {
        int val = Integer.parseInt(value);
        if (val < 0) throw new IncorrectValueException("Value can't be negative", ValueErrorType.NEGATIVE_VALUE);
        return val;
    }

    /**
     * Handle new line separator
     *
     * @param values    : String of numbers to process
     * @param separator : Delimeter
     * @return the Sum of the given value
     */
    public static int handleNewLine(List<String> values, String separator) {
        StringBuilder sb = new StringBuilder();

        for (String value : values) {
            contructStringBuilder(sb, value, separator);
        }
        return sum(sb.toString(), separator);
    }
}

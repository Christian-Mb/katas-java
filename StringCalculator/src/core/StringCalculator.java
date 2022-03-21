package core;

import utils.Utils;

public final class StringCalculator {

    private StringCalculator() {
    }

    /**
     * String calculator
     *
     * @param numbers : String of numbers to process
     * @return Interger : addition's result
     */
    public static int add(String numbers) {

        if (Utils.hasNoValues(numbers)) {
            return 0;
        }

        if (!numbers.contains(Utils.SEPARATOR3)) {
            return processString(numbers, Utils.SEPARATOR);
        } else {
            String separator = Utils.getSeparator(numbers);
            numbers = Utils.splitString(1, Utils.SEPARATOR3 + separator + Utils.SEPARATOR2, numbers);
            return processString(numbers, separator);
        }
    }

    /**
     * @param numbers    : String of numbers to process
     * @param separator: Given separator
     * @return the processing result
     */
    private static int processString(String numbers, String separator) {

        if (!Utils.containNewLineDelimiter(numbers)) {
            return Utils.sum(numbers, separator);
        } else {
            return Utils.handleNewLine(Utils.contructListFromString(numbers, separator), separator);
        }
    }

}

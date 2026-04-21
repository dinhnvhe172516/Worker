package utils;

import constants.Message;

public class Validation {

    private Validation() {
    }

    /**
     * Validates and trims a string input.
     * 
     * @param input The raw input string.
     * @return The trimmed string.
     * @throws Exception if input is null or empty.
     */
    public static String getString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    /**
     * Parses and validates a menu choice within a range.
     * 
     * @param input The raw input string.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The parsed integer choice.
     * @throws Exception if input is not a number or out of range.
     */
    public static int getChoices(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(input);
            if (choice < min || choice > max) {
                throw new Exception(String.format(Message.INVALID_RANGE, min, max));
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    /**
     * Parses and validates worker age (18-50).
     * 
     * @param input The raw input string.
     * @return The parsed age.
     * @throws Exception if input is not a number or out of range.
     */
    public static int getAge(String input) throws Exception {
        try {
            int age = Integer.parseInt(input);
            if (age < 18 || age > 50) {
                throw new Exception(Message.INVALID_AGE);
            }
            return age;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    /**
     * Parses and validates worker salary (must be > 0).
     * 
     * @param input The raw input string.
     * @return The parsed salary.
     * @throws Exception if input is not a number or <= 0.
     */
    public static double getSalary(String input) throws Exception {
        try {
            double salary = Double.parseDouble(input);
            if (salary <= 0) {
                throw new Exception(Message.INVALID_SALARY);
            }
            return salary;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    /**
     * Validates if input is 'Y' or 'N'.
     * 
     * @param input The raw input string.
     * @return The uppercase string "Y" or "N".
     * @throws Exception if input is not Y or N.
     */
    public static String checkYesOrNo(String input) throws Exception {
        String string = getString(input);
        if (string.equalsIgnoreCase("Y") || string.equalsIgnoreCase("N")) {
            return string.toUpperCase();
        }
        throw new Exception(Message.ONLY_YN);
    }
}

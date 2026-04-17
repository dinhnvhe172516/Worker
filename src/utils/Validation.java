package utils;

import constants.Message;

public class Validation {

    private Validation() {
    }

    public static String getString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

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

    public static String checkYesOrNo(String input) throws Exception {
        String string = getString(input);
        if (string.equalsIgnoreCase("Y") || string.equalsIgnoreCase("N")) {
            return string.toUpperCase();
        }
        throw new Exception(Message.ONLY_YN);
    }
}

package constants;

public final class Message {
    private Message(){}

    public static final String MENU = 
            "======== Worker Management =========\n" +
            "1. Add Worker\n" +
            "2. Up salary\n" +
            "3. Down salary\n" +
            "4. Display Information salary\n" +
            "5. Exit";
            
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_ID = "Enter Code: ";
    public static final String INPUT_NAME = "Enter Name: ";
    public static final String INPUT_AGE = "Enter Age: ";
    public static final String INPUT_SALARY = "Enter Salary: ";
    public static final String INPUT_LOCATION = "Enter work location: ";
    
    public static final String EMPTY_INPUT = "Not empty";
    public static final String INVALID_NUMBER = "The number input is invalid";
    public static final String INVALID_RANGE = "Please input number in range [%d, %d]";
    public static final String INVALID_AGE = "Age must be in range 18 to 50";
    public static final String INVALID_SALARY = "Salary must be greater than 0";
    
    public static final String ADD_SUCCESS = "Add worker successful.";
    public static final String UPDATE_SUCCESS = "Update successful.";
    public static final String INC_SUCCESS = "Increase successful.";
    public static final String DEC_SUCCESS = "Decrease successful.";
    
    public static final String DUPLICATE_ID = "Code(id) is duplicated.";
    public static final String NOT_FOUND = "Worker not found or invalid amount.";
    public static final String ONLY_YN = "Only Y or N!";
    public static final String NO_HISTORY = "No salary history found.";
    public static final String HISTORY_TITLE = "--------------------Display Information Salary-----------------------";
    public static final String HISTORY_HEADER = String.format("%-10s%-20s%-10s%-15s%-15s%-20s", "Code", "Name", "Age", "Salary", "Status", "Date");
}

package main;

import constants.Message;
import controller.WorkerController;
import dto.WorkerRequestDTO;
import java.util.Scanner;
import model.SalaryStatus;
import utils.Validation;

public class Main {

    /**
     * Entry point of the Worker Management System.
     * Handles the main menu loop and user interactions.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WorkerController controller = new WorkerController();

        while (true) {
            try {
                // Display menu and get user choice
                System.out.println(Message.MENU);
                System.out.print(Message.INPUT_CHOICE);

                String choiceRaw = sc.nextLine().trim();
                int choice = Validation.getChoices(choiceRaw, 1, 5);

                switch (choice) {
                    case 1:
                        System.out.println("--------- Add Worker ----------");
                        WorkerRequestDTO requestDTO = new WorkerRequestDTO();
                        
                        // Input Worker ID
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_ID);
                                requestDTO.setId(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        // Input Worker Name
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_NAME);
                                requestDTO.setName(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        // Input Worker Age
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_AGE);
                                requestDTO.setAge(Validation.getAge(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        // Input Worker Salary
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_SALARY);
                                requestDTO.setSalary(Validation.getSalary(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        // Input Worker Location
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_LOCATION);
                                requestDTO.setWorkLocation(Validation.getString(sc.nextLine()));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        // Save worker via controller
                        try {
                            controller.addWorker(requestDTO);
                            System.out.println(Message.ADD_SUCCESS);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                        
                    case 2:
                        System.out.println("------- Up Salary --------");
                        String idUp;
                        double amountUp;
                        
                        // Input ID for salary increase
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_ID);
                                idUp = Validation.getString(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        // Input amount for salary increase
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_SALARY);
                                amountUp = Validation.getSalary(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        try {
                            controller.changeSalary(SalaryStatus.UP, idUp, amountUp);
                            System.out.println(Message.INC_SUCCESS);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                        
                    case 3:
                        System.out.println("------- Down Salary --------");
                        String idDown;
                        double amountDown;
                        
                        // Input ID for salary decrease
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_ID);
                                idDown = Validation.getString(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        // Input amount for salary decrease
                        while (true) {
                            try {
                                System.out.print(Message.INPUT_SALARY);
                                amountDown = Validation.getSalary(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                        try {
                            controller.changeSalary(SalaryStatus.DOWN, idDown, amountDown);
                            System.out.println(Message.DEC_SUCCESS);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                        
                    case 4:
                        // Display salary history
                        controller.getInformationSalary();
                        break;
                        
                    case 5:
                        // Exit application
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

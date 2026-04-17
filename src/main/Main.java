package main;

import constants.Message;
import controller.WorkerController;
import dto.WorkerRequestDTO;
import java.util.Scanner;
import model.SalaryStatus;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WorkerController controller = new WorkerController();

        while (true) {
            try {
                System.out.println(Message.MENU);
                System.out.print(Message.INPUT_CHOICE);

                String choiceRaw = sc.nextLine().trim();
                int choice = Validation.getChoices(choiceRaw, 1, 5);

                switch (choice) {
                    case 1:
                        try {
                            WorkerRequestDTO requestDTO = new WorkerRequestDTO();
                            System.out.println("--------- Add Worker ----------");
                            System.out.print(Message.INPUT_ID);
                            requestDTO.setId(Validation.getString(sc.nextLine()));
                            System.out.print(Message.INPUT_NAME);
                            requestDTO.setName(Validation.getString(sc.nextLine()));
                            System.out.print(Message.INPUT_AGE);
                            requestDTO.setAge(Validation.getAge(sc.nextLine()));
                            System.out.print(Message.INPUT_SALARY);
                            requestDTO.setSalary(Validation.getSalary(sc.nextLine()));
                            System.out.print(Message.INPUT_LOCATION);
                            requestDTO.setWorkLocation(Validation.getString(sc.nextLine()));

                            controller.addWorker(requestDTO);
                            System.out.println(Message.ADD_SUCCESS);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("------- Up Salary --------");
                            System.out.print(Message.INPUT_ID);
                            String idUp = Validation.getString(sc.nextLine());
                            System.out.print(Message.INPUT_SALARY);
                            double amountUp = Validation.getSalary(sc.nextLine());
                            controller.changeSalary(SalaryStatus.UP, idUp, amountUp);
                            System.out.println(Message.INC_SUCCESS);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("------- Down Salary --------");
                            System.out.print(Message.INPUT_ID);
                            String idDown = Validation.getString(sc.nextLine());
                            System.out.print(Message.INPUT_SALARY);
                            double amountDown = Validation.getSalary(sc.nextLine());
                            controller.changeSalary(SalaryStatus.DOWN, idDown, amountDown);
                            System.out.println(Message.DEC_SUCCESS);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        controller.getInformationSalary();
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

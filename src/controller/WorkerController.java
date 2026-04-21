package controller;

import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.util.List;
import model.SalaryStatus;
import service.WorkerService;
import view.WorkerView;

public class WorkerController {

    private final WorkerService service;
    private final WorkerView view;

    /**
     * Constructs a new WorkerController and initializes service and view.
     */
    public WorkerController() {
        this.service = new WorkerService();
        this.view = new WorkerView();
    }

    /**
     * Delegates the addition of a worker to the service.
     * 
     * @param request The worker details.
     * @throws Exception if validation fails or worker exists.
     */
    public void addWorker(WorkerRequestDTO request) throws Exception {
        service.addWorker(request);
    }

    /**
     * Delegates the salary change to the service.
     * 
     * @param status UP or DOWN.
     * @param code The worker ID.
     * @param amount The change amount.
     * @throws Exception if worker is not found.
     */
    public void changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        service.changeSalary(status, code, amount);
    }

    /**
     * Retrieves salary history and tells the view to display it.
     * 
     * @throws Exception if no history exists.
     */
    public void getInformationSalary() throws Exception {
        List<SalaryHistoryResponseDTO> result = service.getInformationSalary();
        view.setHistoryList(result);
        view.displayHistoryList();
    }
}

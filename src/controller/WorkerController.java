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

    public WorkerController() {
        this.service = new WorkerService();
        this.view = new WorkerView();
    }

    public void addWorker(WorkerRequestDTO request) throws Exception {
        service.addWorker(request);
    }

    public void changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        service.changeSalary(status, code, amount);
    }

    public void getInformationSalary() throws Exception {
        List<SalaryHistoryResponseDTO> result = service.getInformationSalary();
        view.setHistoryList(result);
        view.displayHistoryList();
    }
}

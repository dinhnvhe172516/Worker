package service;

import constants.Message;
import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.util.List;
import model.SalaryStatus;
import repository.WorkerRepository;

public class WorkerService {

    private final WorkerRepository repository;

    public WorkerService() {
        this.repository = new WorkerRepository();
    }

    public void addWorker(WorkerRequestDTO request) throws Exception {
        if (repository.isExistedWorker(request.getId())) {
            throw new Exception(Message.DUPLICATE_ID);
        }
        repository.addWorker(request);
    }

    public void changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (!repository.isExistedWorker(code)) {
            throw new Exception(Message.NOT_FOUND);
        }
        repository.changeSalary(status, code, amount);
    }

    public List<SalaryHistoryResponseDTO> getInformationSalary() throws Exception {
        if (repository.isHistoryEmpty()) {
            throw new Exception(Message.NO_HISTORY);
        }
        return repository.getInformationSalary();
    }
}

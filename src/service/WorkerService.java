package service;

import constants.Message;
import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.util.ArrayList;
import java.util.List;
import model.SalaryHistory;
import model.SalaryStatus;
import repository.WorkerRepository;

public class WorkerService {

    private final WorkerRepository repository;

    /**
     * Constructs a new WorkerService and initializes the repository.
     */
    public WorkerService() {
        this.repository = new WorkerRepository();
    }

    /**
     * Adds a new worker after validating that the ID is unique.
     * 
     * @param request The worker request DTO.
     * @throws Exception if the worker ID already exists.
     */
    public void addWorker(WorkerRequestDTO request) throws Exception {
        if (repository.isExistedWorker(request.getId())) {
            throw new Exception(Message.DUPLICATE_ID);
        }
        repository.addWorker(request);
    }

    /**
     * Changes the salary of an existing worker.
     * 
     * @param status The status (UP or DOWN).
     * @param code The worker's ID.
     * @param amount The amount to change.
     * @throws Exception if the worker is not found.
     */
    public void changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (!repository.isExistedWorker(code)) {
            throw new Exception(Message.NOT_FOUND);
        }
        repository.changeSalary(status, code, amount);
    }

    /**
     * Retrieves all salary history records and maps them to Response DTOs.
     * 
     * @return A list of SalaryHistoryResponseDTO objects.
     * @throws Exception if no history exists.
     */
    public List<SalaryHistoryResponseDTO> getInformationSalary() throws Exception {
        if (repository.isHistoryEmpty()) {
            throw new Exception(Message.NO_HISTORY);
        }
        List<SalaryHistory> histories = repository.getInformationSalary();
        List<SalaryHistoryResponseDTO> result = new ArrayList<>();
        
        // Mapping model to DTO
        for (SalaryHistory sh : histories) {
            result.add(new SalaryHistoryResponseDTO(
                    sh.getId(),
                    sh.getName(),
                    sh.getAge(),
                    sh.getSalary(),
                    sh.getStatus(),
                    sh.getDate()
            ));
        }
        return result;
    }
}

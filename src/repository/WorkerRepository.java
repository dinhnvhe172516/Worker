package repository;

import dto.WorkerRequestDTO;
import model.SalaryHistory;
import model.SalaryStatus;
import model.Worker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorkerRepository {
    private final List<Worker> list = new ArrayList<>();

    /**
     * Adds a new worker to the list.
     * 
     * @param request The worker request DTO containing worker details.
     */
    public void addWorker(WorkerRequestDTO request) {
        Worker worker = new Worker(
                request.getId(),
                request.getName(),
                request.getAge(),
                request.getSalary(),
                request.getWorkLocation()
        );
        list.add(worker);
    }

    /**
     * Finds a worker by their unique ID.
     * 
     * @param id The ID of the worker to find.
     * @return The Worker object if found, null otherwise.
     */
    public Worker findWorkerById(String id) {
        for (Worker worker : list) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    /**
     * Changes the salary of a worker and records the history.
     * 
     * @param status The salary status (UP or DOWN).
     * @param code The worker's ID.
     * @param amount The amount to change.
     */
    public void changeSalary(SalaryStatus status, String code, double amount) {
        Worker worker = findWorkerById(code);
        if (worker == null) return;

        double newSalary = worker.getSalary();
        if (status == SalaryStatus.UP) {
            newSalary += amount;
        } else if (status == SalaryStatus.DOWN) {
            newSalary = Math.max(0, newSalary - amount);
        }

        worker.setSalary(newSalary);

        SalaryHistory history = new SalaryHistory(
                worker.getId(),
                worker.getName(),
                worker.getAge(),
                newSalary,
                status,
                LocalDate.now(),
                worker.getWorkLocation()
        );
        worker.addSalaryHistory(history);
    }

    /**
     * Retrieves all salary change history, sorted by worker ID.
     * 
     * @return A list of SalaryHistory objects.
     */
    public List<SalaryHistory> getInformationSalary() {
        List<SalaryHistory> result = new ArrayList<>();
        for (Worker worker : list) {
            result.addAll(worker.getSalaryHistories());
        }
        Collections.sort(result, Comparator.comparing(SalaryHistory::getId));
        return result;
    }

    /**
     * Checks if a worker with the given ID already exists.
     * 
     * @param id The ID to check.
     * @return true if the worker exists, false otherwise.
     */
    public boolean isExistedWorker(String id) {
        return findWorkerById(id) != null;
    }

    /**
     * Checks if the salary history is empty.
     * 
     * @return true if no history exists, false otherwise.
     */
    public boolean isHistoryEmpty() {
        for (Worker worker : list) {
            if (!worker.getSalaryHistories().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

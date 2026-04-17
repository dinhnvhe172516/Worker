package repository;

import dto.SalaryHistoryResponseDTO;
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
    private final List<SalaryHistory> salaryHistories = new ArrayList<>();

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

    public Worker findWorkerById(String id) {
        for (Worker worker : list) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

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
        salaryHistories.add(history);
    }

    public List<SalaryHistoryResponseDTO> getInformationSalary() {
        List<SalaryHistoryResponseDTO> result = new ArrayList<>();
        for (SalaryHistory sh : salaryHistories) {
            result.add(new SalaryHistoryResponseDTO(
                    sh.getId(),
                    sh.getName(),
                    sh.getAge(),
                    sh.getSalary(),
                    sh.getStatus(),
                    sh.getDate()
            ));
        }
        Collections.sort(result, Comparator.comparing(SalaryHistoryResponseDTO::getId));
        return result;
    }

    public boolean isExistedWorker(String id) {
        return findWorkerById(id) != null;
    }

    public boolean isHistoryEmpty() {
        return salaryHistories.isEmpty();
    }
}

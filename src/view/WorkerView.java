package view;

import constants.Message;
import dto.SalaryHistoryResponseDTO;
import java.util.List;

public class WorkerView {

    private List<SalaryHistoryResponseDTO> historyList;

    public void setHistoryList(List<SalaryHistoryResponseDTO> historyList) {
        this.historyList = historyList;
    }

    public void displayHistoryList() {
        if (historyList == null || historyList.isEmpty()) {
            return;
        }
        System.out.println(Message.HISTORY_TITLE);
        System.out.println(Message.HISTORY_HEADER);
        for (SalaryHistoryResponseDTO sh : historyList) {
            System.out.println(sh);
        }
    }
}

package view;

import constants.Message;
import dto.SalaryHistoryResponseDTO;
import java.util.List;

public class WorkerView {

    private List<SalaryHistoryResponseDTO> historyList;

    /**
     * Sets the salary history list to be displayed.
     * 
     * @param historyList The list of salary history records.
     */
    public void setHistoryList(List<SalaryHistoryResponseDTO> historyList) {
        this.historyList = historyList;
    }

    /**
     * Displays the salary history list in a formatted table.
     */
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

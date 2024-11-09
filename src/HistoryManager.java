import java.util.ArrayList;
import java.util.List;

public class HistoryManager {

    private static HistoryManager instance;
    private List<String> history;

    private HistoryManager() {
        history = new ArrayList<>();
    }

    public static HistoryManager getInstance() {
        if (instance == null) {
            instance = new HistoryManager();
        }
        return instance;
    }

    public void addToHistory(String calculation) {
        history.add(calculation);
    }

    public String getHistory() {
        StringBuilder historyString = new StringBuilder();
        for (String entry : history) {
            historyString.append(entry).append("\n");
        }
        return historyString.toString();
    }

    public void clearHistory() {
        history.clear();
    }
}

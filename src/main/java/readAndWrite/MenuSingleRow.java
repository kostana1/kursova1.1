package readAndWrite;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuSingleRow {

    private int menuRowNumber;
    private String menuRowDescription;
    private Map<String, Integer> availableOptionToAnswerOrType;

    public MenuSingleRow(int menuRowNumber, String menuRowDescription, Map<String, Integer> availableOptionToAnswerOrType) {
        this.menuRowNumber = menuRowNumber;
        this.menuRowDescription = menuRowDescription;
        if(availableOptionToAnswerOrType != null) {
            this.availableOptionToAnswerOrType = new LinkedHashMap<>(availableOptionToAnswerOrType);
        }else {
            this.availableOptionToAnswerOrType = new LinkedHashMap<>();
        }
        this.availableOptionToAnswerOrType.put("q", 0);
    }

    public int getMenuRowNumber() {
        return menuRowNumber;
    }

    public String getMenuRowDescription() {
        return menuRowDescription;
    }

    public Map<String, Integer> getAvailableOptionToAnswerOrType() {
        return new LinkedHashMap<>(availableOptionToAnswerOrType);
    }

    protected void addOptions(String optionToType, int menuRowNumber) {
        availableOptionToAnswerOrType.put(optionToType, menuRowNumber);
    }
}

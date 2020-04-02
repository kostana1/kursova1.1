package readAndWrite;

import java.io.*;
import java.util.*;

public class ReadAndWrite implements Map<Integer, MenuSingleRow> {

    private static Map<Integer, MenuSingleRow> readRow = new LinkedHashMap<>();
    static {
        try (BufferedReader bufferedReaderMenuRows = new BufferedReader(new FileReader("menuRows.txt"))) {

            String userInput;
            while ((userInput = bufferedReaderMenuRows.readLine()) != null) {
                String[] data = userInput.split(",");
                int rowNum = Integer.parseInt(data[0]);
                String rowDescription = data[1];
                Map<String, Integer> tempOption = new HashMap<>();
                readRow.put(rowNum, new MenuSingleRow(rowNum, rowDescription, tempOption));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReaderOptions = new BufferedReader(new FileReader("menuDirectionToFollow.txt"))) {
            String input;
            while((input = bufferedReaderOptions.readLine()) != null) {
                String[] data = input.split(",");
                int rowNum = Integer.parseInt(data[0]);
                String availableOptions = data[1];
                int nextRow = Integer.parseInt(data[2]);

                MenuSingleRow menuSingleRow = readRow.get(rowNum);
                menuSingleRow.addOptions(availableOptions, nextRow);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(List<String> menuAnswers) throws IOException {

        while (true) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
                bufferedWriter.write(new Scanner(System.in).nextLine());
            }
        }
    }

    @Override
    public int size() {
        return readRow.size();
    }

    @Override
    public boolean isEmpty() {
        return readRow.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return readRow.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readRow.containsValue(value);
    }

    @Override
    public MenuSingleRow get(Object key) {
        return readRow.get(key);
    }

    @Override
    public MenuSingleRow put(Integer key, MenuSingleRow menuSingleRow) {
        return readRow.put(key, menuSingleRow);
    }

    @Override
    public MenuSingleRow remove(Object key) {
        return readRow.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends MenuSingleRow> map) {

    }

    @Override
    public void clear() {
        readRow.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return readRow.keySet();
    }

    @Override
    public Collection<MenuSingleRow> values() {
        return readRow.values();
    }

    @Override
    public Set<Entry<Integer, MenuSingleRow>> entrySet() {
        return readRow.entrySet();
    }
}

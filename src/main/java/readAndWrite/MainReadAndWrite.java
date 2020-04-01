package readAndWrite;

import com.questions.Questions;
import com.service.CreatePersonService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainReadAndWrite {

    private static ReadAndWrite readAndWrite = new ReadAndWrite();
    private static CreatePersonService createPersonService = new CreatePersonService();
    private static Questions questions = new Questions();

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);

        Map<String, String> optionVocabulary = new HashMap<>();
        optionVocabulary.put("quit", "q");
        optionVocabulary.put("name", "n");
        optionVocabulary.put("gender", "g");
        optionVocabulary.put("dateOfBirth", "dob");
        optionVocabulary.put("interest", "i");
        optionVocabulary.put("status", "s");
        optionVocabulary.put("questions", "q");

        int firstRowOfMenu = 1;
        while (true) {
            System.out.println(readAndWrite.get(firstRowOfMenu).getMenuRowDescription());

            if (firstRowOfMenu == 0) {
                System.out.println();
                break;
            }

            Map<String, Integer> options = readAndWrite.get(firstRowOfMenu).getAvailableOptionToAnswerOrType();
            System.out.print("Re-type the following options to continue creating your profile (q for quit): ");
            for (String option : options.keySet()) {
                System.out.print(option + ", ");
            }

            String nextRow = scanner.nextLine();
            if (nextRow.matches("name")) {
                if (optionVocabulary.containsKey(nextRow)) {
                    createPersonService.createPersonName();
                }
            }else if(nextRow.matches("gender")) {
                if(optionVocabulary.containsKey(nextRow)) {
                    createPersonService.createPersonGender();
                }
            }else if(nextRow.matches("dateOfBirth")) {
                if(optionVocabulary.containsKey(nextRow)) {
                    createPersonService.createPersonDateOfBirth();
                }
            }else if(nextRow.matches("interest")) {
                if(optionVocabulary.containsKey(nextRow)) {
                    createPersonService.createPersonInterests();
                }
            }else if(nextRow.matches("status")) {
                if(optionVocabulary.containsKey(nextRow)) {
                    createPersonService.createPersonStatus();
                }
            }else if(nextRow.matches("questions")) {
                if(optionVocabulary.containsKey(nextRow)) {
                    questions.questions();
                }
            }

            if (options.containsKey(nextRow)) {
                firstRowOfMenu = options.get(nextRow);
            } else {
                System.out.println("don't be cheeky please , do what you've been asked for ");
            }
        }
    }
}

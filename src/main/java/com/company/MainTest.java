package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainTest {
    public static void main(String[] args) {
        askQuestion();
    }

    public static void askQuestion() {

        List<String> personUuidAndName = new ArrayList<>();
        String fileLoc = "C:\\Петко\\udemy\\java master class\\Martin_Project\\personsList.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLoc))) {
            String readData;
            while ((readData = bufferedReader.readLine()) != null && !readData.isEmpty()) {
                String[] data = readData.split(",");
                UUID uuid = UUID.fromString(data[0]);
                String name = data[1];
                String nameAndUuid = uuid + "," + name;
                personUuidAndName.add(nameAndUuid);
            }

            for (int i = 0; i < personUuidAndName.size(); i++) {
                System.out.println(personUuidAndName.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

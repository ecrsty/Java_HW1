package Task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Метод для заполнения алфавита
    public static Map<String, Character> fillAlph(Map<String, Character> alphabet, String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] elems = line.split("\\s+");
                if (elems.length == 2) {
                    alphabet.putIfAbsent(elems[1], elems[0].charAt(0));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return alphabet;
    }

    // Метод вывода алфавита
    public static void printAlph(Map<String, Character> alphabet) {
        System.out.println("Алфавит:");
        for (Map.Entry<String, Character> entry : alphabet.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // Метод декодирования слова
    public  static String decode(String message, Map<String, Character> alphabetMap) {
        String[] lettersCodes = message.split(" ");
        StringBuilder decodedMessage = new StringBuilder();

        for (String code : lettersCodes) {
            if (alphabetMap.containsKey(code)) {
                decodedMessage.append(alphabetMap.get(code));
            }
        }

        return decodedMessage.toString();
    }

    public static void main(String[] args) {

        String morseFilePath = "C:\\Users\\Lenovo\\IdeaProjects\\SolovevaVE_HomeWork_1\\src\\main\\java\\Task1\\morseAlphabet.txt";

        Map<String, Character> alphabetMap = fillAlph(new HashMap<>(), morseFilePath);

        System.out.println("Азбука морзе:");
        printAlph(alphabetMap);

        System.out.println("Введите закодированное сообщение, отделяя каждую букву пробелом, новое слово - enter.\nДля остановки введите \"!\"");
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        StringBuilder decodedMessage = new StringBuilder();

        while (!message.equals("!")) {
            decodedMessage.append(decode(message, alphabetMap)+" ");
            message = input.nextLine();
        }

        System.out.println("Расшифрованное сообщение: "+decodedMessage.toString());
    }
}

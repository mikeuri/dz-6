//Написати функцію, яка:
//- приймає як вхідний параметр масив рядків; (наприклад "мама", "папа", "їж їжак желе");
//- із заданого списку рядків знаходить перші два, в яких кожен символ трапляється парну кількість разів;
//- знаходить набір унікальних символів у словах знайдених слів (для наведеного прикладу "мама", "папа" це буде [м а п]);
//- повертає набір літер у вигляді масиву або будь-якого типу колекції, порядок літер при цьому значення не має.
//Рядок перетворюється на набір символів методом String.toCharArray().
//Застосувати якнайбільше різних видів циклів (мінімум 2).
//Використовувати ключові слова керування циклами.

package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Input strings array
        String[] inputStrings = new String[]{
                "кускус",
                "об'єктно-орієнтована мова програмування",
                "кускус",
                "Java",
                "бора бора ",
                "дюран-дюран",
        };

        Set<Character> uniqueChars = getUniqueChars(inputStrings);
        System.out.println("Unique characters for defined strings: " + uniqueChars);
    }

    public static Set<Character> getUniqueChars(String[] stringsToProcess) {
        ArrayList<String> evenStrings = new ArrayList<>();

        //Iteration between the input strings
        for (int i = 0; i < stringsToProcess.length; i++){
            String phrase = stringsToProcess[i];
            System.out.println("Processing string: " + phrase);

            //Counting the occurrence for each character in the string
            Map<Character, Integer> lettersOccurrenceData = new HashMap<>();
            for (char ch : phrase.toCharArray()) {
                int count = lettersOccurrenceData.getOrDefault(ch, 0);
                lettersOccurrenceData.put(ch, count + 1);
            }

            //Calculation of the characters with even occurrence
            int evenLettersCounter = 0;
            for (Map.Entry<Character, Integer> pair : lettersOccurrenceData.entrySet()) {
                if (pair.getValue() % 2 == 0)
                    evenLettersCounter++;
            }

            //Defining phrases where all the letters have even occurrence and adding them to the list
            if (evenLettersCounter == lettersOccurrenceData.size()) {
                if (!evenStrings.contains(phrase))
                    evenStrings.add(phrase);
            }

            //Breaking the loop if the list with the even phrases already has 2 items
            int counter = i + 1;
            if (evenStrings.size() == 2 && counter == stringsToProcess.length) {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.printf("Processed: %s of %s strings%n", counter, stringsToProcess.length);
            } else if (evenStrings.size() == 2 && counter != stringsToProcess.length) {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.printf("Processed: %s of %s strings%n", counter, stringsToProcess.length);
                System.out.println("The rest of the strings won't be processed, since we've already " +
                        "found 2 target strings");
                break;
            }
        }

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Defined strings where all the letters occur even times: " + evenStrings);

        //Getting array of characters for 2 defined strings
        char[] charList = (evenStrings.get(0) + evenStrings.get(1)).toCharArray();

        //Getting unique chars by adding them to Set
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : charList)
            uniqueChars.add(c);

        return uniqueChars;
    }
}

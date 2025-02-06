import java.util.*;

public class TextAnalysisTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User Input
        System.out.println("Enter a paragraph or a lengthy text:");
        String inputText = scanner.nextLine().toLowerCase();
        
        // Character Count
        int charCount = inputText.length();
        System.out.println("Total number of characters: " + charCount);
        
        // Word Count
        String[] words = inputText.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);
        
        // Most Common Character
        char mostCommonChar = getMostCommonChar(inputText);
        System.out.println("Most common character: " + mostCommonChar);
        
        // Character Frequency
        System.out.println("Enter a character to check its frequency:");
        char charToCheck = scanner.next().toLowerCase().charAt(0);
        int charFrequency = getCharFrequency(inputText, charToCheck);
        System.out.println("Frequency of '" + charToCheck + "': " + charFrequency);
        
        // Word Frequency
        System.out.println("Enter a word to check its frequency:");
        scanner.nextLine();  // Consume the newline
        String wordToCheck = scanner.nextLine().toLowerCase();
        int wordFrequency = getWordFrequency(words, wordToCheck);
        System.out.println("Frequency of \"" + wordToCheck + "\": " + wordFrequency);
        
        // Unique Words
        int uniqueWordCount = getUniqueWordCount(words);
        System.out.println("Number of unique words: " + uniqueWordCount);
        
        scanner.close();
    }

    private static char getMostCommonChar(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }
        return Collections.max(charCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static int getCharFrequency(String text, char charToCheck) {
        int frequency = 0;
        for (char c : text.toCharArray()) {
            if (c == charToCheck) {
                frequency++;
            }
        }
        return frequency;
    }

    private static int getWordFrequency(String[] words, String wordToCheck) {
        int frequency = 0;
        for (String word : words) {
            if (word.equals(wordToCheck)) {
                frequency++;
            }
        }
        return frequency;
    }

    private static int getUniqueWordCount(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        return uniqueWords.size();
    }
}

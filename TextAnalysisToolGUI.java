import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TextAnalysisToolGUI {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton analyzeButton;

    public TextAnalysisToolGUI() {
        JFrame frame = new JFrame("Text Analysis Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        
        inputTextArea = new JTextArea(20, 50);
        outputTextArea = new JTextArea(10, 50);
        outputTextArea.setEditable(false);
        
        analyzeButton = new JButton("Analyze Text");
        analyzeButton.addActionListener(new AnalyzeButtonListener());
        
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(inputTextArea));
        panel.add(analyzeButton);
        panel.add(new JScrollPane(outputTextArea));
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private class AnalyzeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputText = inputTextArea.getText().toLowerCase();
            StringBuilder output = new StringBuilder();
            
            // Character Count
            int charCount = inputText.length();
            output.append("Total number of characters: ").append(charCount).append("\n");
            
            // Word Count
            String[] words = inputText.split("\\s+");
            int wordCount = words.length;
            output.append("Total number of words: ").append(wordCount).append("\n");
            
            // Most Common Character
            char mostCommonChar = getMostCommonChar(inputText);
            output.append("Most common character: ").append(mostCommonChar).append("\n");
            
            // Unique Words
            int uniqueWordCount = getUniqueWordCount(words);
            output.append("Number of unique words: ").append(uniqueWordCount).append("\n");
            
            outputTextArea.setText(output.toString());
        }
    }

    private char getMostCommonChar(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }
        return Collections.max(charCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private int getUniqueWordCount(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        return uniqueWords.size();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAnalysisToolGUI::new);
    }
} 
import java.awt.event.*;
import javax.swing.*;

public class App {

    // keeps track of which item is being shown
    static int currentIndex = 0;

    public static void main(String[] args) {

        // array of strings
        String[] top5 = {
            "1. Sleep",
            "2. Music",
            "3. Food",
            "4. Sports",
            "5. Travel"
        };

        JFrame frame = new JFrame("My Top 5 List");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel outputLabel = new JLabel(top5[currentIndex]);
        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back");

        outputLabel.setBounds(100, 50, 200, 30);
        nextButton.setBounds(200, 120, 80, 30);
        backButton.setBounds(80, 120, 80, 30);

        frame.add(outputLabel);
        frame.add(nextButton);
        frame.add(backButton);

        // Next button
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = getNextIndex(currentIndex, top5.length);
                outputLabel.setText(top5[currentIndex]);
            }
        });

        // Back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = getPreviousIndex(currentIndex, top5.length);
                outputLabel.setText(top5[currentIndex]);
            }
        });

        frame.setVisible(true);
    }

    // returns the next index
    public static int getNextIndex(int index, int length) {
        if (index == length - 1) {
            return 0;
        }
        return index + 1;
    }

    // returns the previous index
    public static int getPreviousIndex(int index, int length) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }
}

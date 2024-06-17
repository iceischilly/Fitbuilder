package fitbuilder2.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Code {
    private static final Map<String, String> selectedClothing = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // MENU
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Fit Builder 9000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(2, 1)); // Changed GridLayout to 2 rows
        frame.add(mainPanel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start New Project");
        startButton.setIcon(new ImageIcon("src/assets/New Project.png"));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startBuild(frame);
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setIcon(new ImageIcon("src/assets/exit button.png"));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainPanel.add(startButton);
        mainPanel.add(exitButton);

        frame.setVisible(true);
    }

    // BUILD MENU
    private static void startBuild(JFrame frame) {
        JFrame buildFrame = new JFrame("Build Menu");
        buildFrame.setSize(400, 400);
        buildFrame.setLayout(new GridLayout(5, 1));

        String[] buttonNames = {"Hat", "Chain", "Shirt", "Pants", "Shoes"};

        for (String buttonName : buttonNames) {
            JButton button = new JButton(buttonName);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    showClothingMenu(frame, clickedButton.getText());
                }
            });
            buildFrame.add(button);
        }

        buildFrame.setVisible(true);
    }

    // CLOTHING MENU
    private static void showClothingMenu(JFrame frame, String clothingType) {
        JFrame clothingFrame = new JFrame(clothingType + " Menu");
        clothingFrame.setSize(500, 500);
        clothingFrame.setLayout(new GridLayout(4, 1));

        String[] imagePaths = new String[2];
        String[] buttonNames = new String[2];
        final String nextClothingType;
        if (clothingType.equals("Hat")) {
            imagePaths[0] = "fitbuilder2/src/images/hat1.png";
            imagePaths[1] = "fitbuilder2/src/images/hat2.png";
            buttonNames[0] = "Hat 1";
            buttonNames[1] = "Hat 2";
            nextClothingType = "Chain";
        } else if (clothingType.equals("Chain")) {
            imagePaths[0] = "fitbuilder2/src/images/chain1.png";
            imagePaths[1] = "fitbuilder2/src/images/chain2.png";
            buttonNames[0] = "Chain 1";
            buttonNames[1] = "Chain 2";
            nextClothingType = "Shirt";
        } else if (clothingType.equals("Shirt")) {
            imagePaths[0] = "fitbuilder2/src/images/shirt1.png";
            imagePaths[1] = "fitbuilder2/src/images/shirt2.png";
            buttonNames[0] = "Shirt 1";
            buttonNames[1] = "Shirt 2";
            nextClothingType = "Pants";
        } else if (clothingType.equals("Pants")) {
            imagePaths[0] = "fitbuilder2/src/images/pants1.png";
            imagePaths[1] = "fitbuilder2/src/images/pants2.png";
            buttonNames[0] = "Pants 1";
            buttonNames[1] = "Pants 2";
            nextClothingType = "Shoes";
        } else if (clothingType.equals("Shoes")) {
            imagePaths[0] = "fitbuilder2/src/images/shoes1.png";
            imagePaths[1] = "fitbuilder2/src/images/shoes2.png";
            buttonNames[0] = "Shoes 1";
            buttonNames[1] = "Shoes 2";
            nextClothingType = null; // No next type after shoes
        } else {
            nextClothingType = null;
        }

        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            JButton button = new JButton(buttonNames[i], icon);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            final String selectedItem = imagePaths[i];
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Selected " + clothingType + ": " + selectedItem);
                    selectedClothing.put(clothingType, selectedItem);
                }
            });
            clothingFrame.add(button);
        }

        if (nextClothingType != null) {
            JButton nextButton = new JButton("Next");
            nextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clothingFrame.dispose();
                    showClothingMenu(frame, nextClothingType);
                }
            });
            clothingFrame.add(nextButton);
        } else {
            JButton finishButton = new JButton("Finish");
            finishButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clothingFrame.dispose();
                    showSummaryMenu();
                }
            });
            clothingFrame.add(finishButton);
        }

        clothingFrame.setVisible(true);
    }

    // SUMMARY MENU
    private static void showSummaryMenu() {
        JFrame summaryFrame = new JFrame("Summary");
        summaryFrame.setSize(400, 400);
        summaryFrame.setLayout(new GridLayout(5, 1));

        String[] order = {"Hat", "Chain", "Shirt", "Pants", "Shoes"};
        for (String item : order) {
            if (selectedClothing.containsKey(item)) {
                System.out.println("Adding " + item + ": " + selectedClothing.get(item));
                JLabel label = new JLabel(new ImageIcon(selectedClothing.get(item)));
                summaryFrame.add(label);
            } else {
                System.out.println(item + " not selected");
            }
        }

        summaryFrame.setVisible(true);
    }
}

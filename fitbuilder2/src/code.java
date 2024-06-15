import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class code {
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

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        frame.add(mainPanel, BorderLayout.CENTER);

        JButton startButton = new JButton("");
        startButton.setIcon(new ImageIcon("src/assets/New Project.png"));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startBuild(frame);
            }
        });

        JButton AddClothingButton = new JButton("");
        AddClothingButton.setIcon(new ImageIcon("src/assets/add button.png"));
        AddClothingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editClothing(frame);
            }
        });

        JButton exitButton = new JButton("");
        exitButton.setIcon(new ImageIcon("src/assets/exit button.png"));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainPanel.add(startButton);
        mainPanel.add(AddClothingButton);
        mainPanel.add(exitButton);

        frame.setVisible(true);
    }

//BUILD MENU

    private static void startBuild(JFrame frame) {
        JFrame buildFrame = new JFrame("Build Menu");
        buildFrame.setSize(100, 500);
        buildFrame.setLayout(new BorderLayout());
        buildFrame.setLayout(new GridLayout(6, 6));
       
        // Where images go
        String[] imagePaths = {"assest/New Project.png", "path_to_image2.jpg", "path_to_image3.jpg","assest/New Project.png","assest/New Project.png"};
       
        JButton[] imageButtons = new JButton[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            imageButtons[i] = new JButton(icon);
            imageButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Your logic to handle image clicks and check for match
                    JButton clickedbuildButton = (JButton) e.getSource();
                    hatBuild(clickedbuildButton, frame);
                }
            });
            buildFrame.add(imageButtons[i]);
        }

        buildFrame.setVisible(true);
    }

    //ADD CLOTHING MENU

    private static void editClothing(JFrame frame) {
        JFrame editFrame = new JFrame("Edit Clothing");
        editFrame.setSize(500, 500);
        editFrame.setLayout(new GridLayout(2, 3));
       
        // Where images go
        String[] imagePaths = {"assest/New Project.png", "path_to_image2.jpg", "path_to_image3.jpg"};
       
        JButton[] imageButtons = new JButton[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            imageButtons[i] = new JButton(icon);
            imageButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Your logic to handle image clicks and check for match
                    JButton clickededitButton = (JButton) e.getSource();
                    editBuild(clickededitButton, frame);
                }
            });
            editFrame.add(imageButtons[i]);
        }

        editFrame.setVisible(true);
    }

    private static void hatBuild(JButton clickedbuildButton, JFrame frame) {
        JFrame hatFrame = new JFrame("Hat Menu");
        hatFrame.setSize(500, 500);
        hatFrame.setLayout(new GridLayout(2, 3));
       
        // Example image paths, replace with actual paths
        String[] imagePaths = {"assest/New Project.png", "path_to_image2.jpg", "path_to_image3.jpg"};
             
        JButton[] imageButtons = new JButton[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            imageButtons[i] = new JButton(icon);
            imageButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //handle image clicks and check for match
                    JButton clickededitButton = (JButton) e.getSource();
                    hatBuild(clickededitButton, frame);
                }
            });
            hatFrame.add(imageButtons[i]);
        }

        hatFrame.setVisible(true);
    }
}
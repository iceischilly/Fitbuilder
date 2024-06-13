import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Code {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

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
       
        // Example image paths, replace with actual paths
        String[] imagePaths = {"assest/New Project.png", "path_to_image2.jpg", "path_to_image3.jpg","assest/New Project.png","assest/New Project.png"};
       
        JButton[] imageButtons = new JButton[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            imageButtons[i] = new JButton(icon);
            imageButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Your logic to handle image clicks and check for match
                    JButton clickedButton = (JButton) e.getSource();
                    handleImageClick(clickedButton, frame);
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
       
        // Example image paths, replace with actual paths
        String[] imagePaths = {"assest/New Project.png", "path_to_image2.jpg", "path_to_image3.jpg"};
       
        JButton[] imageButtons = new JButton[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            imageButtons[i] = new JButton(icon);
            imageButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Your logic to handle image clicks and check for match
                    JButton clickedButton = (JButton) e.getSource();
                    handleImageClick(clickedButton, frame);
                }
            });
            editFrame.add(imageButtons[i]);
        }

        editFrame.setVisible(true);
    }

    private static void handleImageClick(JButton clickedButton, JFrame frame) {
        // Implement logic to check if selected images are a good match
        // This is a placeholder for demonstration purposes
        JOptionPane.showMessageDialog(frame, "Image clicked: " + clickedButton.getIcon().toString());

        // Example logic: compare clickedButton's icon to some predefined rules
        // if (clickedButton.getIcon().toString().equals("path_to_image1.jpg")) { ... }
    }
}
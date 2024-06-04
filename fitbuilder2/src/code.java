package fitbuilder2.src;
import javax.swing.JOptionPane;

public class code { 
    public void game(){
        int end = 0;
        int build = 0;
        int edit = 0;

        while (end != 1) {
            // Start menu
            // If else statement for starting the clothing build
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to start the build?", "Start build", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                end = 1;
                break;
            }

            // If statement to start
            build = 1;
            while (build != 0) {
                // Insert code for building
                String buildInput = JOptionPane.showInputDialog("building section:");
                if (buildInput.equalsIgnoreCase("exit")) {
                    build = 0;
                    break;
                }
                
                // If statement for editing the clothing styles and or colours 
                edit = 1;
                while (edit != 0) {
                    // Code for edit
                    String editInput = JOptionPane.showInputDialog("Enter style(colour type):");
                    if (editInput.equalsIgnoreCase("exit")) {
                        edit = 0;
                        break;
                    }
                    
                    // Add if statement to exit the build
                    int endChoice = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                    if (endChoice == JOptionPane.YES_OPTION) {
                        end = 1;
                        build = 0;
                        edit = 0;
                    }
                }
            }
        }
    }
}
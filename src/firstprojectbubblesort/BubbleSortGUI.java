package firstprojectbubblesort;

import java.awt.*;
import java.awt.event.*;

/*
 * @author Razvan
*/

public class BubbleSortGUI extends Frame {

    /*
     The GUI's components:
     -inputArray is a TextArea for the input of the array
     -outputArray is a TextArea for print the ordered array
     -messageInput is a Label that inform the user where he have to write the array
     -messageOutput is a Label that inform the user where is the ordered array
     -errorValues is a Label that inform the user with the invalid values that he wrote
     -btnBubbleSort is a Button that ordered the array received on inputArray
    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    */
    TextArea inputArray;
    TextArea outputArray;
    Label messageInput;
    Label messageOutput;
    Label errorValues;
    Button btnBubbleSort;

    BubbleSortGUI() {

        //Initializations of the components and add them into the GUI
        
        inputArray = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        inputArray.setBounds(100, 80, 400, 60);
        this.add(inputArray);

        outputArray = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputArray.setBounds(100, 300, 400, 100);
        outputArray.setEditable(false);
        outputArray.setFocusable(false);
        outputArray.setVisible(false);
        this.add(outputArray);

        messageInput = new Label("Inserisci qui sotto i numeri per l'ordinamento. Dividere con lo spazio.");
        messageInput.setBounds(110, 50, 400, 25);
        this.add(messageInput);

        messageOutput = new Label("Array ordinato:");
        messageOutput.setBounds(100, 250, 300, 25);
        messageOutput.setVisible(false);
        this.add(messageOutput);

        errorValues = new Label();
        errorValues.setBounds(100, 380, 300, 100);
        errorValues.setVisible(false);
        this.add(errorValues);

        btnBubbleSort = new Button("Bubble Sort");
        btnBubbleSort.setBounds(200, 150, 100, 50);
        btnBubbleSort.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String[] arr = BubbleSort.getSort(inputArray.getText());
                outputArray.setText(arr[0]);
                if (!arr[1].equals("0")) {
                    errorValues.setText("Hai inserito " + arr[1] + " valori non validi.");
                    errorValues.setVisible(true);
                }
                messageOutput.setVisible(true);
                outputArray.setVisible(true);
            }

        });
        this.add(btnBubbleSort);

        //method to close the GUI when the user click on the X
        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        //set the size and the visibility of the GUI
        this.setSize(600, 600);
        this.setVisible(true);

    }
}

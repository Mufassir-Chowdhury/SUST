package Components.Buttons;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;

public class FileButton extends AccentButton {
    public FileButton(String title){
        super(title);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileChooser = new FileDialog((Frame) null, "Choose a file", FileDialog.LOAD);
                fileChooser.setVisible(true);
                System.out.println("You chose to open this file: " + fileChooser.getFile());
            }
        });
    }
}

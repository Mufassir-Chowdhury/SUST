package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Component;
import Components.InputFields.ComboBox;
import Constants.Sizes;

public class Options extends Box {
    public Options(String[] firstOptions, String[] secondOptions){
        super(BoxLayout.X_AXIS);
        setMaximumSize(Sizes.OPTIONS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        ComboBox<String> filter = new ComboBox<>(firstOptions);
        ComboBox<String> filter2 = new ComboBox<>(secondOptions);

        add(filter);
        add(Box.createHorizontalGlue());
        add(filter2);
    }
}

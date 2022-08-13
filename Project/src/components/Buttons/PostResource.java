package Components.Buttons;

import Components.Background;
import Components.Label;
import Components.InputFields.ComboBox;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Component;

public class PostResource extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(Dimension size, JFrame frame){
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Post New Resource", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            String[] options = {"Class Videos", "CT Questions", "Term Final Questions", "Lecture Notes", "Books"};
            TilesPanel tilesPanel = new TilesPanel(3, 2, 10);
            tilesPanel.add(new Label("Resource Type"));
            tilesPanel.add(new ComboBox<>(options));
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(new TextField("Write Title", TYPE.PLAIN));
            tilesPanel.add(new Label("Link"));
            tilesPanel.add(new TextField("Provide Link", TYPE.PLAIN));
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(Box.createVerticalGlue());
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
            add(proceed);
        }
    }
    public PostResource(){
        super("Post New Material");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();

        Dimension size = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/2.2));

        frame = new Background(size, frame);
        frame.add(new Dialog(size, frame));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}


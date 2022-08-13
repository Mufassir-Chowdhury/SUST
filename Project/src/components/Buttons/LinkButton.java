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
import Server.Datapoints;
import Server.Datapoints.Link;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.Dimension;

public class LinkButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel {

        ComboBox<String> linkTypeField = new ComboBox<>(Datapoints.getInstance().LINK_TITLES);
        
        TextField titleField = new TextField("Write Link Title",TYPE.PLAIN);
        TextField linkField = new TextField("Write Link URL",TYPE.PLAIN);;

        public Dialog(Dimension size, JFrame frame) {
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);
            
            add(new Label("Add New Link", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            TilesPanel tilesPanel = new TilesPanel(3, 2, 10);
            
            tilesPanel.add(new Label("Link Type"));
            tilesPanel.add(linkTypeField);
            tilesPanel.add(new Label("Link Title"));
            tilesPanel.add(titleField);
            tilesPanel.add(new Label("Link URL"));
            tilesPanel.add(linkField);

            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);

            add(Box.createVerticalGlue());
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        fetchDataAndPassToClient();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    frame.dispose();
                }
            });
            add(proceed);
        }

        protected void fetchDataAndPassToClient() throws IOException {
            Link link = new Link(titleField.getText(), linkField.getText());
            Datapoints.getInstance().client.add(linkTypeField.getSelectedItem().toString(), link, Datapoints.ADD_LINK);
        }
    }

    public LinkButton() {
        super("Post New Link");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension size = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/2.2));
        Background frame = new Background(size, new JFrame());
        frame.add(new Dialog(size, frame));
    }
}

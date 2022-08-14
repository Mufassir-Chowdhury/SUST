package Components.Buttons;

import Components.Background;
import Components.Label;
import Components.InputFields.ComboBox;
import Components.InputFields.TextArea;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;
import Server.Datapoints;
import Server.Datapoints.Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.awt.Component;
import java.awt.Dimension;

public class NoticeButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel {

        String[] noticeFor = { "Student", "Teacher", "Both" };
        ComboBox<String> noticeForField = new ComboBox<>(noticeFor);
        TextField titleField = new TextField("Write Title", TYPE.PLAIN);

        TextArea messageField = new TextArea("Write Message", true);

        public Dialog(Dimension size, JFrame frame) {

            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Upload New Notice", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            TilesPanel tilesPanel = new TilesPanel(2, 2, 0, 10);
            tilesPanel.add(new Label("Event For"));
            tilesPanel.add(noticeForField);
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(titleField);
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(Box.createVerticalGlue());

            add(messageField);

            add(Box.createVerticalStrut(10));

            add(new FileButton("Choose a photo"));
            add(Box.createVerticalStrut(10));

            AccentButton proceed = new AccentButton("Upload");
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
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MMMM dd, u");
            LocalDate localDate = LocalDate.now();
            Notice notice = new Notice(noticeForField.getSelectedItem().toString(), titleField.getText(),
                    messageField.getText(), "Admin", date.format(localDate));
            Datapoints.getInstance().client.add(notice, Datapoints.ADD_NOTICE);
        }
    }

    public NoticeButton() {
        super("Upload New Notice");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension size = Sizes.DIALOG.EVENT;
        Background frame = new Background(size, new JFrame());
        frame.add(new Dialog(size, frame));
        frame.setVisible(true);
    }
}

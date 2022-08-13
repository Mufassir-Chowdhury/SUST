package Components.Buttons;

import Components.Background;
import Components.Label;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.Table;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Component;

public class PaymentHistoryButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(Dimension size, JFrame frame){
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("See Payment History", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            add(Box.createVerticalStrut(50));

            Object[] columnNames = {"ID", "Registration", "Type", "Amount", "Date"};
            Object[][] data = {
                {
                    "1",
                    "2019331073",
                    "Credit Fee",
                    "400 BDT",
                    "2019-11-11"
                },
                {
                    "2",
                    "2019331073",
                    "Registration Fee",
                    "1000 BDT",
                    "2019-11-11"
                },
                {
                    "3",
                    "2019331073",
                    "Library Fee",
                    "50 BDT",
                    "2019-11-11"
                },
                {
                    "4",
                    "2019331073",
                    "Registration Fee",
                    "1000 BDT",
                    "2019-11-11"
                },
                {
                    "5",
                    "2019331073",
                    "Credit Fee",
                    "400 BDT",
                    "2019-11-11"
                }
            };
            ListPanel panel = new ListPanel(
                    new ScrollPane(
                            new Table(data, columnNames)),
                    null,
                    0
            );
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(panel);
            
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
    public PaymentHistoryButton(){
        super("See Payment History");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension size = Sizes.DIALOG.PAYMENT_HISTORY;
        Background frame = new Background(size, new JFrame());
        frame.add(new Dialog(size, frame));
    }
}

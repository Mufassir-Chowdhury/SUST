package Components.Buttons;

import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.Table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Component;

public class PaymentHistoryButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(JDialog dialog){
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
                    dialog.dispose();
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
        final JDialog dialog = new JDialog();
        final JOptionPane optionPane = new JOptionPane(new Dialog(dialog), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        dialog.setTitle("See Payment History");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        dialog.setVisible(true);
    }
}

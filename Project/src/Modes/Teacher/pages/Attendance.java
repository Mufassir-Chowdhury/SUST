package Modes.Teacher.pages;

import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.Table;
import Components.pageView.Panels.ViewPort;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;

public class Attendance extends ViewPort {
    AccentButton button = new AccentButton("Print Attendance");
    public Attendance(){
        super("Attendance", null);
        String[] courses = {"course 1", "course 2"};
        add(new ComboBox<>(courses));
        ListPanel listPanel = new ListPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.X_AXIS));
        listPanel.add(button);
        listPanel.add(Box.createHorizontalGlue());
        listPanel.add(new AccentButton("Update"));
        add(listPanel);
        Object[] columnNames = {"Registration", "Day - 1", "Day - 2", "Day - 3", "Day - 4", "Day - 5", "Day - 6", "Day - 7", "Day - 8", "Day - 9", "Day - 10"};
        Object[][] data = {
            {   "2019331073", false, false, false, false, false, false, false, false, false, false},
            {   "2019331074", false, false, false, false, false, false, false, false, false, false},
            {   "2019331075", false, false, false, false, false, false, false, false, false, false},
            {   "2019331076", false, false, false, false, false, false, false, false, false, false},
            {   "2019331077", false, false, false, false, false, false, false, false, false, false},
            {   "2019331078", false, false, false, false, false, false, false, false, false, false},
            {   "2019331079", false, false, false, false, false, false, false, false, false, false},
            {   "2019331080", false, false, false, false, false, false, false, false, false, false},
            {   "2019331081", false, false, false, false, false, false, false, false, false, false},
            {   "2019331082", false, false, false, false, false, false, false, false, false, false},
            {   "2019331083", false, false, false, false, false, false, false, false, false, false},
            {   "2019331084", false, false, false, false, false, false, false, false, false, false},
            {   "2019331085", false, false, false, false, false, false, false, false, false, false},
            {   "2019331086", false, false, false, false, false, false, false, false, false, false},
            {   "2019331087", false, false, false, false, false, false, false, false, false, false},
            {   "2019331088", false, false, false, false, false, false, false, false, false, false},
            {   "2019331089", false, false, false, false, false, false, false, false, false, false},
            {   "2019331090", false, false, false, false, false, false, false, false, false, false},
            {   "2019331091", false, false, false, false, false, false, false, false, false, false},
            {   "2019331092", false, false, false, false, false, false, false, false, false, false},
            {   "2019331093", false, false, false, false, false, false, false, false, false, false},
            {   "2019331094", false, false, false, false, false, false, false, false, false, false},
            {   "2019331095", false, false, false, false, false, false, false, false, false, false},
            {   "2019331096", false, false, false, false, false, false, false, false, false, false},
            {   "2019331097", false, false, false, false, false, false, false, false, false, false},
            {   "2019331098", false, false, false, false, false, false, false, false, false, false},
            {   "2019331099", false, false, false, false, false, false, false, false, false, false},
            {   "2019331100", false, false, false, false, false, false, false, false, false, false},
            {   "2019331101", false, false, false, false, false, false, false, false, false, false},
            {   "2019331102", false, false, false, false, false, false, false, false, false, false},
            {   "2019331103", false, false, false, false, false, false, false, false, false, false},
            {   "2019331104", false, false, false, false, false, false, false, false, false, false},
            {   "2019331105", false, false, false, false, false, false, false, false, false, false},
            
        };
        Table table = new Table(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {

            boolean[] canEdit = new boolean[]{
                    false, true, true, true, true, true, true, true, true, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
            @Override
            public Class<? extends Object> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        table = new Table(model);
        table.setEnabled(true);
        add(
            new ListPanel(
                new ScrollPane(
                    table
                ),
                null,
                0
            )
        );
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Table(data, columnNames).print();
                } catch (PrinterException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }
}

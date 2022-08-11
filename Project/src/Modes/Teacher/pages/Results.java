package Modes.Teacher.pages;

import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.Table;
import Components.pageView.Panels.ViewPort;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.event.ActionEvent;

public class Results extends ViewPort {
    AccentButton button = new AccentButton("Print Results");
    public Results(){
        super("Results", null);
        String[] courses = {"course 1", "course 2"};
        add(new ComboBox<>(courses));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(button);
        Object[] columnNames = {"Registration", "Assignment", "TT", "TT-2", "Evaluation", "Attendance", "Term Final", "Total", "Grade"};
        Object[][] data = {
            {   "2019331073", "10", "10", "10", "10", "10", "40", "100", "A+"},
            {   "2019331074", "9", "9", "9", "9", "9", "39", "93", "A+"},
            {   "2019331075", "8", "8", "8", "8", "8", "38", "90", "A+"},
            {   "2019331076", "7", "7", "7", "7", "7", "37", "87", "A+"},
            {   "2019331077", "6", "6", "6", "6", "6", "36", "84", "A+"},
            {   "2019331078", "5", "5", "5", "5", "5", "35", "81", "A+"},
            {   "2019331079", "4", "4", "4", "4", "4", "34", "78", "A+"},
            {   "2019331080", "3", "3", "3", "3", "3", "33", "75", "A+"},
            {   "2019331081", "2", "2", "2", "2", "2", "32", "72", "A+"},
            {   "2019331082", "1", "1", "1", "1", "1", "31", "69", "A+"},
            {   "2019331083", "0", "0", "0", "0", "0", "30", "66", "A+"},
            {   "2019331084", "0", "0", "0", "0", "0", "29", "63", "A+"},
            {   "2019331085", "0", "0", "0", "0", "0", "28", "60", "A+"},
            {   "2019331086", "0", "0", "0", "0", "0", "27", "57", "A+"},
            {   "2019331087", "0", "0", "0", "0", "0", "26", "54", "A+"},
            {   "2019331088", "0", "0", "0", "0", "0", "25", "51", "A+"},
            {   "2019331089", "0", "0", "0", "0", "0", "24", "48", "A+"},
            {   "2019331090", "0", "0", "0", "0", "0", "23", "45", "A+"},
            {   "2019331091", "0", "0", "0", "0", "0", "22", "42", "A+"},
            {   "2019331092", "0", "0", "0", "0", "0", "21", "39", "A+"},
            {   "2019331093", "0", "0", "0", "0", "0", "20", "36", "A+"},
            {   "2019331094", "0", "0", "0", "0", "0", "19", "33", "A+"},
            {   "2019331095", "0", "0", "0", "0", "0", "18", "30", "A+"},
            {   "2019331096", "0", "0", "0", "0", "0", "17", "27", "A+"},
            {   "2019331097", "0", "0", "0", "0", "0", "16", "24", "A+"},
            {   "2019331098", "0", "0", "0", "0", "0", "15", "21", "A+"},
            {   "2019331099", "0", "0", "0", "0", "0", "14", "18", "A+"},
            {   "2019331100", "0", "0", "0", "0", "0", "13", "15", "A+"},
            {   "2019331101", "0", "0", "0", "0", "0", "12", "12", "A+"},
            {   "2019331102", "0", "0", "0", "0", "0", "11", "9", "A+"},
            {   "2019331103", "0", "0", "0", "0", "0", "10", "6", "A+"},
            {   "2019331104", "0", "0", "0", "0", "0", "9", "3", "A+"},
            {   "2019331105", "0", "0", "0", "0", "0", "8", "0", "A+"},
            {   "2019331106", "0", "0", "0", "0", "0", "7", "-3", "A+"},
            {   "2019331107", "0", "0", "0", "0", "0", "6", "-6", "A+"},
            {   "2019331108", "0", "0", "0", "0", "0", "5", "-9", "A+"},
        };
        Table table = new Table(data, columnNames);
        DefaultTableModel model = new DefaultTableModel() {
            boolean[] canEdit = new boolean[]{
                    false, true, true, true, true, true, true, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        model.setDataVector(data, columnNames);
        model.setColumnIdentifiers(columnNames);
        model.setRowCount(data.length);
        table.setModel(model);
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
                    System.err.println("Error printing table");
                    e1.printStackTrace();
                }
            }
        });
    }
}

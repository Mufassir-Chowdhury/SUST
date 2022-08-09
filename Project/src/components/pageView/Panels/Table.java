package Components.pageView.Panels;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Constants.Colors;
import Constants.Fonts;

public class Table extends JTable {
    public Table(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setFillsViewportHeight(true);
        setOpaque(false);
        setShowGrid(false);
        setRowHeight(30);
        setFont(Fonts.BODY);
        setEnabled(false);
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
        setForeground(Colors.PLAIN_TEXT);
        getTableHeader().setVisible(true);
        if(getColumnCount() == 3){
            getColumnModel().getColumn(2).setPreferredWidth(0);
        }
    }
}

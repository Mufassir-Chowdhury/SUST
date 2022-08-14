package Components.pageView.Panels;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Constants.Colors;
import Constants.Fonts;

import javax.swing.JComponent;

public class Table extends JTable {
    public Table(DefaultTableModel model) {
        super(model);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setFillsViewportHeight(true);
        setOpaque(false);
        setShowGrid(false);
        setRowHeight(30);
        setFont(Fonts.BODY);
        setEnabled(false);
        setRowSelectionAllowed(false);
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
        setForeground(Colors.PLAIN_TEXT);
        getTableHeader().setVisible(true);
        if(getColumnCount() == 3){
            getColumnModel().getColumn(2).setPreferredWidth(0);
        }
        getTableHeader().setBackground(Colors.TextField.BACKGROUND_FOCUSED);
        getTableHeader().setForeground(Colors.PLAIN_TEXT);
        ((JComponent) getDefaultRenderer(Boolean.class)).setOpaque(false);
    }
    public Table(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setFillsViewportHeight(true);
        setOpaque(false);
        setShowGrid(false);
        setRowHeight(30);
        setFont(Fonts.BODY);
        setEnabled(false);
        setRowSelectionAllowed(false);
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        centerRenderer.setOpaque(false);
        for(int i=0; i<getColumnCount(); i++){
            getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        setForeground(Colors.PLAIN_TEXT);
        getTableHeader().setVisible(true);
        if(getColumnCount() == 3){
            getColumnModel().getColumn(2).setPreferredWidth(0);
        }
        getTableHeader().setBackground(Colors.TextField.BACKGROUND_FOCUSED);
        getTableHeader().setForeground(Colors.PLAIN_TEXT);
        getTableHeader().setBorder(null);
        ((JComponent) getDefaultRenderer(Boolean.class)).setOpaque(false);
    }
}

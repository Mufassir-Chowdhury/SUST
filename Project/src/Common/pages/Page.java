package Common.pages;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JPanel;

public class Page {
    public String name;
    public Icon icon;
    public JPanel panel;
    public Page (String name, Icon icon, JPanel panel)  throws ClassNotFoundException, IOException{
        this.name = name;
        this.icon = icon;
        this.panel = panel;
    }
    @Override
    public String toString(){
        return name;
    }
}

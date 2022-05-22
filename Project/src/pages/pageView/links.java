package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Desktop;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URI;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import Components.Label;

import java.awt.Color;
import java.net.URISyntaxException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;

import Constants.Fonts;
import Constants.conn;
import Server.Datapoints;
import Server.Server;
import Server.Datapoints.Link;

public class links extends JPanel {

    private Vector<String> linkTitle = new Vector<>();
    private Vector<Vector<Link>> links = new Vector<>();
    conn c = new conn();

    public links() throws ClassNotFoundException, IOException {
        // System.out.println("hi");
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Links", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));
        
        // fetchData();

        //for database
        // for (int i = 0; i < linkTitle.size(); i++) {
        //     add(new Label(linkTitle.get(i), Fonts.TITLE));
        //     for (Link link : links.get(i)) {

        //for static
        for (int i = 0; i < Datapoints.getInstance().LINKS.length; i++) {
            add(new Label(Server.LINK_TITLES[i], Fonts.TITLE));
            for(Datapoints.Link link: Datapoints.getInstance().LINKS[i]){
                JPanel info = new JPanel();
                info.setAlignmentX(Component.LEFT_ALIGNMENT);
                ;
                info.setBackground(new Color(52, 50, 52));
                info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
                info.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                info.add(new Label(link.title, Fonts.Body));
                info.add(Box.createHorizontalGlue());
                info.add(new Label(link.title, Fonts.PLAIN_TEXT));
                add(info);

                add(Box.createVerticalStrut(10));
                info.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(link.url));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }

        }
    }

    private void fetchData()
    {
        String query = "select * from link_titles;";
        try {
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                String element = rs.getString("titles");
                linkTitle.add(element);
            }
            links = new Vector<>(linkTitle.size());

            for (String key : linkTitle) {
                query = "select * from links where linker = '" + key + "';";
                ResultSet rss = c.s.executeQuery(query);
                Vector<Link> element = new Vector<>();
                while (rss.next()) {
                    element.add(new Link(rss.getString("title"), rss.getString("url")));
                }
                links.add(element);
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    //don't call this function
    private void makeDatabaseFromStatic()
    {
        for (int i = 0; i < Datapoints.getInstance().LINKS.length; i++) {
            add(new Label(Server.LINK_TITLES[i], Fonts.TITLE));
            for (Datapoints.Link link : Datapoints.getInstance().LINKS[i]) {
                String command="insert into links values('"+Datapoints.getInstance().LINK_TITLES[i]+"','"+link.title+"','"+
                link.url + "');";
                String query = "select * from links where linker = '" + Datapoints.getInstance().LINK_TITLES[i] + "' and title = '"
                        + link.title + "' and url = '" + link.url + "';";
                try {
                ResultSet exist = c.s.executeQuery(query);
                if (!exist.next())
                    c.s.executeUpdate(command);
                }
                catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
        
    }
}

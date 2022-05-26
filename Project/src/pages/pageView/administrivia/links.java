package pages.pageView.administrivia;

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
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;

import java.awt.Color;
import java.net.URISyntaxException;
import java.sql.ResultSet;

import Constants.Fonts;
import Constants.Connect;
import Server.Datapoints;
import Server.Server;

public class links extends ViewPort {

    Connect c = new Connect();

    public links() throws ClassNotFoundException, IOException {
        super("Links", null);

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

        for (int i = 0; i < Datapoints.getInstance().LINK_TITLES.length; i++) {
            list.add(Box.createVerticalStrut(25));
            list.add(new Label(Datapoints.getInstance().LINK_TITLES[i], Fonts.TITLE));
            // add(Box.createVerticalStrut(20));
            for(Datapoints.Link link: Datapoints.getInstance().LINKS[i]){
                JPanel info = new JPanel();
                info.setAlignmentX(Component.LEFT_ALIGNMENT);
                info.setBackground(new Color(52, 50, 52));
                info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
                info.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                info.add(new Label(link.title, Fonts.Body));
                info.add(Box.createHorizontalGlue());
                info.add(new Label(link.title, Fonts.PLAIN_TEXT));
                list.add(Box.createVerticalStrut(10));

                list.add(info);

                // add(Box.createVerticalStrut(10));
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
        add(new ScrollPane(list));
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

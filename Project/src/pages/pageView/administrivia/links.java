package pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.JPanel;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URI;

import Components.Label;
import Components.ListItem;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;

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

        ListPanel list = new ListPanel();

        for (int i = 0; i < Datapoints.getInstance().LINK_TITLES.length; i++) {
            list.add(new Label(Datapoints.getInstance().LINK_TITLES[i], Fonts.TITLE));
            for(Datapoints.Link link: Datapoints.getInstance().LINKS[i]){
                JPanel info = new ListItem(link.title, "", "", link.title);
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

                list.add(info);
                list.add(Box.createVerticalStrut(10));
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

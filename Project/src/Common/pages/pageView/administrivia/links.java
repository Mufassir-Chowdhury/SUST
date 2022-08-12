package Common.pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.JComponent;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URI;

import Components.Label;
import Components.pageView.Box.Line;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.ViewPort;

import java.net.URISyntaxException;

import Constants.Fonts;
import Server.Datapoints;

public class links extends ViewPort {

    public links(JComponent component) throws ClassNotFoundException, IOException {
        super("Links", component);

        ListPanel list = new ListPanel();

        for (int i = 0; i < Datapoints.getInstance().LINK_TITLES.length; i++) {
            list.add(new Label(Datapoints.getInstance().LINK_TITLES[i], Fonts.TITLE));
            list.add(Box.createVerticalStrut(4));
            for (Datapoints.Link link : Datapoints.getInstance().LINKS[i]) {
                Line info = new Line(link.title, "", "", link.title);

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
}

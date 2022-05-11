package pages.pageView;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import Components.Buttons.HyperLinkButton;
import Constants.Datapoints;

public class links extends JPanel {
    public links(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Datapoints.Link link: Datapoints.LINKS){
            HyperLinkButton button = new HyperLinkButton(link.title);
            button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI(link.url));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            add(button);
        }
    }
}

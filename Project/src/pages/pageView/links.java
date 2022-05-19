package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Desktop;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URI;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import Components.Buttons.AccentButton;

import java.awt.Color;
import java.net.URISyntaxException;

import Constants.Colors;
import Constants.Fonts;
import Server.Client;
import Server.Datapoints;

public class links extends JPanel {

    public links() throws ClassNotFoundException, IOException{
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel titleLabel = new JLabel("Links");
        titleLabel.setFont(Fonts.DISPLAY);
        titleLabel.setForeground(Colors.PLAIN_TEXT);
        title.add(titleLabel);
        add(title);
        add(Box.createVerticalStrut(20));
        for(int i=0; i<Datapoints.LINKS.length; i++){
            // JLabel linkLabel = new JLabel(Datapoints.Link.LINK_TITLES[i]);
            // linkLabel.setFont(Fonts.TITLE);
            // linkLabel.setForeground(Colors.PLAIN_TEXT);
            // add(linkLabel);
            for(Datapoints.Link link: Datapoints.LINKS[i]){
                JPanel info = new JPanel();
                info.setAlignmentX(Component.LEFT_ALIGNMENT);;
                info.setBackground(new Color(52, 50, 52));
                info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
                info.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                JLabel name = new JLabel(link.title);
                name.setForeground(Colors.PLAIN_TEXT);
                name.setFont(Fonts.Body);
                info.add(name);
                info.add(Box.createHorizontalGlue());
                JLabel number = new JLabel(link.title);
                number.setFont(Fonts.PLAIN_TEXT);
                number.setForeground(Colors.PLAIN_TEXT);
                info.add(number);
                add(info);
                add(Box.createVerticalStrut(10));
                info.addMouseListener(new MouseAdapter(){
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
        AccentButton github = new AccentButton("Github");
        github.setAlignmentX(Component.LEFT_ALIGNMENT);
        github.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client client;
                try {
                    client = new Client();
                    Datapoints.Link[][] links = client.getLinks();
                    System.out.println(links[0][0].url);
                    for(int i=0; i<links.length; i++){
                        // JLabel linkLabel = new JLabel(Datapoints.Link.LINK_TITLES[i]);
                        // linkLabel.setFont(Fonts.TITLE);
                        // linkLabel.setForeground(Colors.PLAIN_TEXT);
                        // add(linkLabel);
                        for(Datapoints.Link link: links[i]){
                            JPanel info = new JPanel();
                            info.setAlignmentX(Component.LEFT_ALIGNMENT);;
                            info.setBackground(new Color(52, 50, 52));
                            info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
                            info.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                            JLabel name = new JLabel(link.title);
                            name.setForeground(Colors.PLAIN_TEXT);
                            name.setFont(Fonts.Body);
                            info.add(name);
                            info.add(Box.createHorizontalGlue());
                            JLabel number = new JLabel(link.title);
                            number.setFont(Fonts.PLAIN_TEXT);
                            number.setForeground(Colors.PLAIN_TEXT);
                            info.add(number);
                            add(info);
                            add(Box.createVerticalStrut(10));
                            info.addMouseListener(new MouseAdapter(){
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
                } catch (ClassNotFoundException f) {
                    // TODO Auto-generated catch block
                    f.printStackTrace();
                } catch (IOException f) {
                    // TODO Auto-generated catch block
                    f.printStackTrace();
                }
                repaint();
                revalidate();
            }
        });
        add(github);
    }
}

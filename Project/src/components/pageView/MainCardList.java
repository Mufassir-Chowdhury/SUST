package Components.pageView;

import javax.swing.Box;
import javax.swing.JPanel;

import Components.pageView.MainCardListItem.Type;
import Server.Datapoints;

public class MainCardList extends ListPanel {
    public MainCardList(Title title, JPanel panel, Type type) {
        if(type == Type.EVENT){
            for(Datapoints.Event eventItem: Datapoints.getInstance().EVENTS){
                add(new MainCardListItem(eventItem, title, panel));
                add(Box.createVerticalStrut(10));
            }
        } else if(type == Type.NOTICE){
            for(Datapoints.Notice noticeItem: Datapoints.getInstance().NOTICES){
                add(new MainCardListItem(noticeItem, title, panel));
                add(Box.createVerticalStrut(10));
            }
        }
    }
}

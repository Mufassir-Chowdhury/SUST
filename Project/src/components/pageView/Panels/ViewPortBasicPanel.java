package Components.pageView.Panels;

import javax.swing.JComponent;

import Components.pageView.Box.MainCardListItem.Type;

public class ViewPortBasicPanel extends ViewPortPanel {
        public ViewPortBasicPanel(String title, JComponent component, Server.Datapoints.Tilable[] tiles) {
                super(title, component);

                getPanel().add(
                                new ScrollPane(
                                                new MainCardList(title, getTitle(), getPanel(), tiles)),
                                title);
        }

        public ViewPortBasicPanel(String title, JComponent component,
                        Components.pageView.Box.MainCardListItem.Type type) {
                super(title, component);
                if (type == Type.EXAM || type == Type.ASSIGNMENT) {
                        getPanel().add(
                                        new ScrollPane(
                                                        new MainCardList(title, getTitle(), getPanel(), type)),
                                        title);
                } else {
                        getPanel().add(
                                        new ScrollPane(
                                                        new MainCardList(title, getTitle(), type)),
                                        title);
                }
        }
}
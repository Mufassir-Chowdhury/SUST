package Modes.Administration.pages;

import Common.pages.Page;
import Common.pages.pageView.administrivia.*;
import Common.pages.pageView.course_information.*;
import Common.pages.pageView.misc.bus.bus;
import Common.pages.pageView.misc.map.map;
import Components.Buttons.AccentButton;
import Components.Buttons.EventButton;
import Components.Buttons.LinkButton;
import Components.Buttons.NoticeButton;
import Components.Buttons.RegisterProfile;
import Components.pageView.Panels.ViewPortBasicPanel;
import Constants.Icons;
import Server.Datapoints;

import java.io.IOException;

public class PageList {
        public static Page[][] getPages() throws ClassNotFoundException, IOException {
                return new Page[][] {
                                {
                                                new Page(
                                                                "Notice Board",
                                                                Icons.Pages.NOTICE,
                                                                new ViewPortBasicPanel(
                                                                                "Notices",
                                                                                new NoticeButton(),
                                                                                Datapoints.NOTICES))
                                },
                                {
                                                new Page(
                                                                "Resources",
                                                                Icons.Pages.RESOURCES,
                                                                new resources()),
                                },
                                {
                                                new Page(
                                                                "Payment",
                                                                Icons.Pages.PAYMENT,
                                                                new payment()),
                                                new Page(
                                                                "Course Registration",
                                                                Icons.Pages.COURSE_REGISTRATION,
                                                                new course()),
                                                new Page(
                                                                "Important Links",
                                                                Icons.Pages.IMPORTANT_LINKS,
                                                                new links(
                                                                                new LinkButton()))
                                },
                                {
                                                new Page(
                                                                "Bus Schedule",
                                                                Icons.Pages.BUS_SCHEDULE,
                                                                new bus(
                                                                                new AccentButton(
                                                                                                "Change bus schedule"))),
                                                new Page(
                                                                "People",
                                                                Icons.Pages.STUDENT_INFO,
                                                                new ViewPortBasicPanel(
                                                                                "People",
                                                                                new RegisterProfile(),
                                                                                Datapoints.STUDENTS)),
                                                new Page(
                                                                "Events",
                                                                Icons.Pages.EVENTS,
                                                                new ViewPortBasicPanel(
                                                                                "Events",
                                                                                new EventButton(),
                                                                                Datapoints.EVENTS)),
                                                new Page(
                                                                "Map",
                                                                Icons.Pages.MAP,
                                                                new map())
                                },
                };
        }
}

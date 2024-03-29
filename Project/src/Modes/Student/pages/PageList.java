package Modes.Student.pages;

import Common.pages.Page;
import Common.pages.pageView.administrivia.*;
import Common.pages.pageView.course_information.*;
import Common.pages.pageView.misc.bus.bus;
import Common.pages.pageView.misc.map.map;
import Common.pages.pageView.misc.people.People;
import Common.pages.pageView.updates.routine.routine;
import Components.Buttons.AccentButton;
import Components.pageView.Box.ResultSummary;
import Components.pageView.Panels.ViewPortBasicPanel;
import Constants.Icons;
import Server.Datapoints;

import java.io.IOException;

public class PageList {
        private PageList(){
                throw new IllegalStateException("Utility class");
        }

        public static Page[][] getPages() throws ClassNotFoundException, IOException {
                return new Page[][] {
                                {
                                                new Page(
                                                                "Class Routines",
                                                                Icons.Pages.SCHEDULE,
                                                                new routine(
                                                                                null,
                                                                                new AccentButton("Manage Courses"))),
                                                new Page(
                                                                "Due Assignments",
                                                                Icons.Pages.ASSIGNMENT,
                                                                new ViewPortBasicPanel(
                                                                                "Assignment",
                                                                                null,
                                                                                Components.pageView.Box.MainCardListItem.Type.ASSIGNMENT)),
                                                new Page(
                                                                "Upcoming Exams",
                                                                Icons.Pages.EXAM,
                                                                new ViewPortBasicPanel(
                                                                                "Exam",
                                                                                null,
                                                                                Components.pageView.Box.MainCardListItem.Type.EXAM)),
                                                new Page(
                                                                "Notice Board",
                                                                Icons.Pages.NOTICE,
                                                                new ViewPortBasicPanel(
                                                                                "Notices",
                                                                                null,
                                                                                Datapoints.NOTICES))
                                },
                                {
                                                new Page(
                                                                "Resources",
                                                                Icons.Pages.RESOURCES,
                                                                new resources()),
                                                new Page(
                                                                "Results",
                                                                Icons.Pages.RESULT,
                                                                new ViewPortBasicPanel(
                                                                                "Results",
                                                                                new ResultSummary(),
                                                                                Components.pageView.Box.MainCardListItem.Type.RESULT)),
                                                new Page(
                                                                "Attendance",
                                                                Icons.Pages.ATTENDANCE,
                                                                new ViewPortBasicPanel(
                                                                                "Attendance",
                                                                                null,
                                                                                Components.pageView.Box.MainCardListItem.Type.ATTENDANCE))
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
                                                                new links(null))
                                },
                                {
                                                new Page(
                                                                "Bus Schedule",
                                                                Icons.Pages.BUS_SCHEDULE,
                                                                new bus(null)),
                                                new Page(
                                                                "People",
                                                                Icons.Pages.STUDENT_INFO,
                                                                new People(null)),
                                                new Page(
                                                                "Events",
                                                                Icons.Pages.EVENTS,
                                                                new ViewPortBasicPanel(
                                                                                "Events",
                                                                                null,
                                                                                Datapoints.EVENTS))                                },
                };
        }
}

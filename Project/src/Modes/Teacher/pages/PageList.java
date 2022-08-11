package Modes.Teacher.pages;

import Common.pages.Page;
import Common.pages.pageView.administrivia.*;
import Common.pages.pageView.course_information.*;
import Common.pages.pageView.misc.bus.bus;
import Common.pages.pageView.misc.map.map;
import Common.pages.pageView.updates.routine.routine;
import Components.Buttons.AssignmentButton;
import Components.Buttons.ClassButton;
import Components.Buttons.ExamButton;
import Components.pageView.Panels.ViewPortBasicPanel;
import Constants.Icons;
import Server.Datapoints;

import java.io.IOException;

public class PageList {
    public static Page[][] getPages() throws ClassNotFoundException, IOException{
        return new Page[][]{
            {
                new Page(
                    "Class Routines", 
                    Icons.Pages.SCHEDULE, 
                    new routine(
                            new ClassButton(), 
                            null
                    )
                ), 
                new Page(
                    "Assignments", 
                    Icons.Pages.ASSIGNMENT, 
                    new ViewPortBasicPanel(
                            "Assignment",
                            new AssignmentButton(), 
                            Components.pageView.Box.MainCardListItem.Type.ASSIGNMENT
                    )
                ),
                new Page(
                    "Exams", 
                    Icons.Pages.EXAM, 
                    new ViewPortBasicPanel(
                            "Exam", 
                            new ExamButton(),
                            Components.pageView.Box.MainCardListItem.Type.EXAM
                    )
                ),
                new Page(
                    "Notice Board", 
                    Icons.Pages.NOTICE, 
                    new ViewPortBasicPanel(
                            "Notices", 
                            null,
                            Datapoints.NOTICES
                    )
                )
            },
            { 
                new Page(
                    "Resources", 
                    Icons.Pages.RESOURCES,
                    new resources()
                ),
                new Page(
                    "Results",
                    Icons.Pages.RESULT,
                    new Results()
                ),
                new Page(
                    "Attendance", 
                    Icons.Pages.ATTENDANCE, 
                    new Attendance()
                )
            },
            { 
                new Page(
                    "Important Links", 
                    Icons.Pages.IMPORTANT_LINKS, 
                    new links(
                        null
                    )
                )
            },
            { 
                new Page(
                    "Bus Schedule", 
                    Icons.Pages.BUS_SCHEDULE, 
                    new bus(null)
                ),
                new Page(
                    "People", 
                    Icons.Pages.STUDENT_INFO, 
                    new ViewPortBasicPanel(
                            "People", 
                            null,
                            Datapoints.STUDENTS
                    )
                ),
                new Page(
                    "Events", 
                    Icons.Pages.EVENTS, 
                    new ViewPortBasicPanel(
                            "Events", 
                            null,
                            Datapoints.EVENTS
                    )
                ),
                new Page(
                    "Map", 
                    Icons.Pages.MAP, 
                    new map()
                )
            },
        };
    }
}

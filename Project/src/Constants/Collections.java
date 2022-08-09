package Constants;

import Server.Datapoints;
import Server.Datapoints.Resource;

public class Collections {
        
    public static Object[] TITLE_FOR_SYLLABUS_TABLE = {
            "Title", "Description"
    };
    public static Object[] TITLE_FOR_RESOURCE_TABLE = {
            "Title", "Uploader", "Download Link"
    };
    public static  Resource[] RESOURCES = {
            new Resource("Syllabus", Datapoints.getInstance().SYLLABUS, TITLE_FOR_SYLLABUS_TABLE),
            new Resource("Class Videos", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
            new Resource("CT Questions", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
            new Resource("Term Final Questions", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
            new Resource("Lecture Notes", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
            new Resource("Books", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
    };
    public static String[] PAYMENT = {
            "Registration Fee",
            "Library Fine",
            "Migration Fee",
            "Credit Fee",
            "Documents Fee",
            "Apply for Transcript",
    };
    public static String[] TITLES = { 
            "UPDATES", 
            "COURSE INFORMATION", 
            "ADMINISTRIVIA", 
            "MISCELLANEOUS" 
    };
}

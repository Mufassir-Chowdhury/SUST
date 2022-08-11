package Constants;

import Server.Datapoints;
import Server.Datapoints.Resource;
import Common.pages.pageView.administrivia.CreditFee;
import Common.pages.pageView.administrivia.DocumentFee;
import Common.pages.pageView.administrivia.FixedFee;
import Common.pages.pageView.administrivia.RegistrationFee;
import Components.Payment;

public class Collections {

        public static Object[] TITLE_FOR_SYLLABUS_TABLE = {
                        "Title", "Description"
        };
        public static Object[] TITLE_FOR_RESOURCE_TABLE = {
                        "Title", "Uploader", "Download Link"
        };
        public static Resource[] RESOURCES = {
                        new Resource("Syllabus", Datapoints.getInstance().SYLLABUS, TITLE_FOR_SYLLABUS_TABLE),
                        new Resource("Class Videos", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
                        new Resource("CT Questions", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
                        new Resource("Term Final Questions", Datapoints.getInstance().RESOURCES,
                                        TITLE_FOR_RESOURCE_TABLE),
                        new Resource("Lecture Notes", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
                        new Resource("Books", Datapoints.getInstance().RESOURCES, TITLE_FOR_RESOURCE_TABLE),
        };
        public static Payment[] PAYMENT = {
                        new Payment("Registration Fee", new RegistrationFee()),
                        new Payment("Library Fine", new FixedFee(0)),
                        new Payment("Migration Fee", new FixedFee(500)),
                        new Payment("Credit Fee", new CreditFee()),
                        new Payment("Documents Fee", new DocumentFee()),
                        new Payment("Medium of Instruction Fee", new FixedFee(100))
        };
        public static String[] TITLES = {
                        "UPDATES",
                        "COURSE INFORMATION",
                        "ADMINISTRIVIA",
                        "MISCELLANEOUS"
        };
}

package Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.Event;
import Server.Datapoints.Link;

public class Fetcher {

    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    static BufferedReader bufferedReader;

    private static void fetchLinks() throws FileNotFoundException {
        
        bufferedReader = new BufferedReader(new FileReader("links.json"));

        Map<String, Map<String, Link>> links = new HashMap<>();
        links = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Link>>>() {
        }.getType());

        Vector<String> titleTypeList = new Vector<>();
        Vector<Link[]> linkList = new Vector<>();

        links.forEach((titleType, link) -> {
            titleTypeList.add(titleType);
            linkList.add(link.values().toArray(new Link[0]));
        });

        Server.LINK_TITLES = titleTypeList.toArray(new String[titleTypeList.size()]);
        Server.LINKS = linkList.toArray(new Link[linkList.size()][]);
    }
    
    private static void fetchEvents() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("events.json"));

        Map<String, Event> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Event>>() {
        }.getType());

        Server.EVENTS = events.values().toArray(new Event[0]);
    }

    

    public static void fetch() throws FileNotFoundException
    {
        fetchLinks();
        fetchEvents();
    }
}

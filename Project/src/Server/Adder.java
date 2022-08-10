package Server;

import java.io.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.Event;
import Server.Datapoints.Link;

public class Adder {
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    static BufferedReader bufferedReader;
    static FileWriter writer;

    public static void addNewLink(String title, Link link) throws IOException
    {
        
        bufferedReader = new BufferedReader(
                new FileReader("links.json"));

        Map<String, Map<String, Link>> links = new HashMap<>();
        links = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Link>>>() {
        }.getType());

        if (links == null)
            links = new HashMap<>();

        if (links.containsKey(title) == false) {
            links.put(title, new HashMap<>());
            links.get(title).put(link.title, link);
        }
        links.get(title).put(link.title, link);

        FileWriter writer = new FileWriter("links.json");
        writer.write(gson.toJson(links));
        writer.close();
    }
    
    public static void addNewEvent(Event event) throws IOException
    {
        bufferedReader = new BufferedReader(
                new FileReader("events.json"));

        Map<String, Event> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Event>>() {
        }.getType());

        if (events == null)
            events = new HashMap<>();

        events.put(event.title, event);

        writer = new FileWriter("events.json");
        writer.write(gson.toJson(events));
        writer.close();
    }

    // public static void addCources()
    // {
}

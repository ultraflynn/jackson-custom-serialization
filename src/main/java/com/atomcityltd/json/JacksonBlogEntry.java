package com.atomcityltd.json;

import com.atomcityltd.json.model.Task;
import com.atomcityltd.json.model.TaskCalendar;
import com.atomcityltd.json.model.Week;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public final class JacksonBlogEntry {
    private static final TaskCalendar CALENDAR;

    static {
        CALENDAR = new TaskCalendar();
        
        Week weekOne = new Week();
        weekOne.addTask(new Task("description", 1, "notes", "confidential"));
        Week weekTwo = new Week();
        weekOne.setLinked(weekTwo);
        weekTwo.setLinked(weekOne);
        weekTwo.addTask(new Task("description", 1, "notes", "confidential"));

        CALENDAR.addWeek(weekOne).addWeek(weekTwo);
    }

    public static void main(String[] args) {

        System.out.println("Vanilla ObjectMapper - will fail");
        ObjectMapper vanillaMapper = getVanillaObjectMapper();
        serializeAndPrint(vanillaMapper);

        System.out.println("Filtering ObjectMapper - will succeed");
        ObjectMapper filteringMapper = getFilteringObjectMapper();
        serializeAndPrint(filteringMapper);
    }

    private static void serializeAndPrint(ObjectMapper mapper) {
        try {
            String json = mapper.writeValueAsString(CALENDAR);
            System.out.println(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static ObjectMapper getVanillaObjectMapper() {
        return new ObjectMapper();
    }

    private static ObjectMapper getFilteringObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(
                PropertyFilteringModule.builder("Module Name")
                        .exclude(Task.class, "notes")
                        .exclude(Task.class, "confidential")
                        .exclude(Week.class, "linked")
                        .build());
        return mapper;
    }
}

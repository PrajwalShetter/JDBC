package controller;

import Dto.EventDto;
import service.EventService;
import service.impl.EventServiceImpl;

import java.util.List;

public class EventController {

    EventService eventService = new EventServiceImpl();

    public boolean addEvent(EventDto event){
        return eventService.addEvent(event);
    }

    public  List<EventDto> retrieveAllData(){
        return eventService.retrieveAllData();
    }

    public String getEventNameByPlace(String place){
        return eventService.getEventNameByPlace(place);
    }

    public List<EventDto> getEventDetailsByPlaceAndName(String place, String name){
        return eventService.getEventDetailsByPlaceAndName(place,name);
    }

    public int updateEventPlaceByEventName(String eventName, String newVenue){
        return eventService.updateEventPlaceByEventName(eventName, newVenue);
    }

    public int deleteEventByName(String eventName){
        return eventService.deleteEventByName(eventName);
    }

    public int deleteEventByPlace(String venue){
        return eventService.deleteEventByPlace(venue);
    }

    public int truncateEventTable(){
        return eventService.truncateEventTable();
    }

    public int dropEventTable(){
        return eventService.dropEventTable();
    }
}

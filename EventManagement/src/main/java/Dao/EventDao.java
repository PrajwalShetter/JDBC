package Dao;

import Dto.EventDto;

import java.util.List;

public interface EventDao {

    boolean addEvent(EventDto event);

    List<EventDto> retrieveAllData();

    String getEventNameByPlace(String place);

    List<EventDto> getEventDetailsByPlaceAndName(String place, String name);

    int updateEventPlaceByEventName(String eventName, String newVenue);

    int deleteEventByName(String eventName);

    int deleteEventByPlace(String venue);

    int truncateEventTable();

    int dropEventTable();

}

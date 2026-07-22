package service.impl;

import Dao.CategoryDao;
import Dao.ClientDao;
import Dao.EventDao;
import Dao.impl.CategoryDaoImpl;
import Dao.impl.ClientDaoImpl;
import Dao.impl.EventDaoImpl;
import Dto.EventDto;
import service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private ClientDao clientDao = new ClientDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private EventDao eventDao = new EventDaoImpl();

    @Override
    public boolean addEvent(EventDto event) {

        if (event == null) {
            System.out.println("Event object cannot be null.");
            return false;
        }


        if (event.getClientId() <= 0) {
            System.out.println("Invalid Client ID.");
            return false;
        }

        if (!clientDao.existsById(event.getClientId())) {
            System.out.println("Client ID does not exist.");
            return false;
        }

        if (event.getCategoryId() <= 0) {
            System.out.println("Invalid Category ID.");
            return false;
        }

        if (!categoryDao.existsById(event.getCategoryId())) {
            System.out.println("Category ID does not exist.");
            return false;
        }

        if (event.getEventName() == null ||
                !event.getEventName().matches("^[A-Za-z ]{4,50}$")) {

            System.out.println("Invalid Event Name.");
            return false;
        }

        if (event.getEventVenue() == null ||
                !event.getEventVenue().matches("^[A-Za-z0-9 .,&()_-]{3,100}$")) {

            System.out.println("Invalid Event Venue.");
            return false;
        }

        if (event.getDescription() == null ||
                event.getDescription().trim().length() < 10 ||
                event.getDescription().trim().length() > 200) {

            System.out.println("Description must contain 10 to 200 characters.");
            return false;
        }

        if (event.getEventDate() == null) {
            System.out.println("Event Date is required.");
            return false;
        }

        if (event.getStartTime() == null) {
            System.out.println("Start Time is required.");
            return false;
        }

        if (event.getEndTime() == null) {
            System.out.println("End Time is required.");
            return false;
        }

        if (event.getEndTime().compareTo(event.getStartTime()) <= 0) {
            System.out.println("End Time must be greater than Start Time");
            return false;
        }

        if (event.getTotalSeats() <= 0) {
            System.out.println("Total Seats must be greater than zero.");
            return false;
        }

        if (event.getTicketPrice() < 0) {
            System.out.println("Ticket Price cannot be negative.");
            return false;
        }

        if (event.getStatus() == null ||
                !(event.getStatus().equalsIgnoreCase("Upcoming")
                        || event.getStatus().equalsIgnoreCase("Completed")
                        || event.getStatus().equalsIgnoreCase("Cancelled")
                        || event.getStatus().equalsIgnoreCase("Postponed"))) {

            System.out.println("Invalid Event Status.");
            return false;
        }

        return eventDao.addEvent(event);
    }

    public List<EventDto> retrieveAllData(){
        return eventDao.retrieveAllData();
    }

    @Override
    public String getEventNameByPlace(String place) {
        return eventDao.getEventNameByPlace(place);
    }

    public List<EventDto> getEventDetailsByPlaceAndName(String place, String name){
        return eventDao.getEventDetailsByPlaceAndName(place, name);
    }

    public int updateEventPlaceByEventName(String eventName, String newVenue){
        return eventDao.updateEventPlaceByEventName(eventName, newVenue);
    }

    public int deleteEventByName(String eventName){
        return eventDao.deleteEventByName(eventName);
    }

    @Override
    public int deleteEventByPlace(String venue) {
        return eventDao.deleteEventByPlace(venue);
    }

    @Override
    public int truncateEventTable() {
        return eventDao.truncateEventTable();
    }

    public int dropEventTable(){
        return eventDao.dropEventTable();
    }
}

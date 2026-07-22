package Runner;

import Dto.EventDto;
import controller.EventController;
import service.EventService;
import service.impl.EventServiceImpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class EventRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventController controller = new EventController();

//        EventDto event = new EventDto();
//
//        System.out.println("---------- ADD EVENT ---------------");
//
//        System.out.print("Enter Client ID : ");
//        event.setClientId(scanner.nextInt());
//
//        System.out.print("Enter Category ID : ");
//        event.setCategoryId(scanner.nextInt());
//        scanner.nextLine();
//
//        System.out.print("Enter Event Name : ");
//        event.setEventName(scanner.nextLine());
//
//        System.out.print("Enter Description : ");
//        event.setDescription(scanner.nextLine());
//
//        System.out.print("Enter Venue : ");
//        event.setEventVenue(scanner.nextLine());
//
//        System.out.print("Enter Event Date (yyyy-mm-dd) : ");
//        event.setEventDate(Date.valueOf(scanner.nextLine()));
//
//        System.out.print("Enter Start Time (HH:mm:ss) : ");
//        event.setStartTime(Time.valueOf(scanner.nextLine()));
//
//        System.out.print("Enter End Time (HH:mm:ss) : ");
//        event.setEndTime(Time.valueOf(scanner.nextLine()));
//
//        System.out.print("Enter Total Seats : ");
//        event.setTotalSeats(scanner.nextInt());
//
//        System.out.print("Enter Ticket Price : ");
//        event.setTicketPrice(scanner.nextInt());
//        scanner.nextLine();
//
//        System.out.print("Enter Status (Upcoming/Completed/Cancelled/Postponed) : ");
//        event.setStatus(scanner.nextLine());
//
//
//
//        boolean result = controller.addEvent(event);
//
//        if (result) {
//            System.out.println("Event Added Successfully.");
//        } else {
//            System.out.println("Failed to Add Event.");
//        }


//        System.out.println("Get all events :");
        List<EventDto> list = controller.retrieveAllData();

//        for(EventDto dto:list){
//
//            System.out.println("EventId :"+dto.getEventId());
//            System.out.println("ClientId :"+dto.getClientId());
//            System.out.println("CategoryId :"+dto.getCategoryId());
//            System.out.println("EventName :"+dto.getEventName());
//            System.out.println("EventVenue :"+dto.getEventVenue());
//            System.out.println("Description :"+dto.getDescription());
//            System.out.println("EventDate :"+dto.getEventDate());
//            System.out.println("StartTime :"+dto.getStartTime());
//            System.out.println("EndTime :"+dto.getEndTime());
//            System.out.println("TotalSeats :"+dto.getTotalSeats());
//            System.out.println("TicketPrice :"+dto.getTicketPrice());
//            System.out.println("Status :"+dto.getStatus());
//
//            System.out.println("----------------------------");
//
//        }



//        System.out.println("Get EventName by venue :");
//        System.out.print("Enter place :");
//        String venue = scanner.nextLine();
//
//        String eventName= controller.getEventNameByPlace(venue);
//        if(eventName != null){
//            System.out.println("Event Name :" +eventName);
//        }else{
//            System.out.println("No event found in this place");
//        }


//        System.out.println("Get Event details by name and place");
//        System.out.print("Enter place :");
//        String venue1 = scanner.nextLine();
//        System.out.print("Enter Name :");
//        String name = scanner.nextLine();
//
//        List<EventDto> list1 = controller.getEventDetailsByPlaceAndName(venue1,name);
//
//        for (EventDto dto:list1){
//
//            System.out.println("EventId :"+dto.getEventId());
//            System.out.println("ClientId :"+dto.getClientId());
//            System.out.println("CategoryId :"+dto.getCategoryId());
//            System.out.println("EventName :"+dto.getEventName());
//            System.out.println("EventVenue :"+dto.getEventVenue());
//            System.out.println("Description :"+dto.getDescription());
//            System.out.println("EventDate :"+dto.getEventDate());
//            System.out.println("StartTime :"+dto.getStartTime());
//            System.out.println("EndTime :"+dto.getEndTime());
//            System.out.println("TotalSeats :"+dto.getTotalSeats());
//            System.out.println("TicketPrice :"+dto.getTicketPrice());
//            System.out.println("Status :"+dto.getStatus());
//
//            System.out.println("----------------------------");
//        }

//        System.out.println("Update venue by event Name :");
//        System.out.print("Enter EventName :");
//        String EventName = scanner.nextLine();
//        System.out.print("Enter newVenue :");
//        String newVenue = scanner.nextLine();
//
//        int updated= controller.updateEventPlaceByEventName(EventName, newVenue);
//        if(updated > 0){
//            System.out.println("Place Updated");
//        }else{
//            System.out.println("Sorry something went wrong");
//        }

//        System.out.println("Delete Event By Name");
//        System.out.print("Enter Event Name : ");
//        String eventName = scanner.nextLine();
//
//        int deleted = controller.deleteEventByName(eventName);
//
//        if (deleted > 0) {
//            System.out.println("Event Deleted Successfully.");
//        } else {
//            System.out.println("Event Not Found.");
//        }

//        System.out.println("Delete Event By Venue");
//        System.out.print("Enter Venue : ");
//        String venue = scanner.nextLine();
//
//        int deleted = controller.deleteEventByPlace(venue);
//
//        if (deleted > 0) {
//            System.out.println("Event Deleted Successfully.");
//        } else {
//            System.out.println("Event Not Found.");
//        }

//        System.out.println("Truncate Events Table");
//
//        int result = controller.truncateEventTable();
//
//        if (result > 0) {
//            System.out.println("Events table truncated successfully.");
//        } else {
//            System.out.println("Failed to truncate events table.");
//        }

//        System.out.println("Drop Events Table");
//
//        int result = controller.dropEventTable();
//
//        if (result > 0) {
//            System.out.println("Events table dropped successfully.");
//        } else {
//            System.out.println("Failed to drop events table.");
//        }

        scanner.close();
    }
}

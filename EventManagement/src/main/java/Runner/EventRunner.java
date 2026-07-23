package Runner;

import Dto.CategoryDto;
import Dto.ClientDto;
import Dto.EventDto;
import controller.CategoryController;
import controller.ClientController;
import controller.EventController;
import service.EventService;
import service.impl.EventServiceImpl;

import java.sql.Date;
import java.sql.SQLOutput;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class EventRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventController controller = new EventController();

        System.out.println("Hi... Welcome to Event Management");
        boolean isRunning = true;


        while (isRunning) {
            System.out.println("=====Plz Authenticate yourself=====\n");
            System.out.println("1.User");
            System.out.println("2.Client");
            System.out.println("3.Admin");
            System.out.println("Enter Your choice 1 ,2 or 3:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("user verified");
                    boolean isUser = true;

                    isUser = false;
                    break;

                case 2:
                    System.out.println("Manager access granted");
                    boolean isClient = true;

                    isClient = false;
                    break;

                case 3:
                    System.out.println("Manager access granted");
                    boolean isAdmin = true;

                    while (isAdmin) {
                        System.out.println("What would you like to do here,");
                        System.out.println("1.Add Event ");
                        System.out.println("2. Add Category");
                        System.out.println("3. Add Client");
                        System.out.println("4. Get all Event List");
                        System.out.println("5. Get Event name by venue");
                        System.out.println("6. Get Event details by venue and Name");
                        System.out.println("7. Update Venue by Event Name");
                        System.out.println("8. Delete Event by Venue");
                        System.out.println("9. Truncate Table");
                        System.out.println("10. Delete Table");
                        System.out.println("Enter your choice :");

                        int eventChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (eventChoice) {
                            case 1:
                                EventDto event = new EventDto();
                                System.out.println("---------- ADD EVENT ---------------");

                                System.out.print("Enter Client ID : ");
                                event.setClientId(scanner.nextInt());

                                System.out.print("Enter Category ID : ");
                                event.setCategoryId(scanner.nextInt());
                                scanner.nextLine();

                                System.out.print("Enter Event Name : ");
                                event.setEventName(scanner.nextLine());

                                System.out.print("Enter Description : ");
                                event.setDescription(scanner.nextLine());

                                System.out.print("Enter Venue : ");
                                event.setEventVenue(scanner.nextLine());

                                System.out.print("Enter Event Date (yyyy-mm-dd) : ");
                                event.setEventDate(Date.valueOf(scanner.nextLine()));

                                System.out.print("Enter Start Time (HH:mm:ss) : ");
                                event.setStartTime(Time.valueOf(scanner.nextLine()));

                                System.out.print("Enter End Time (HH:mm:ss) : ");
                                event.setEndTime(Time.valueOf(scanner.nextLine()));

                                System.out.print("Enter Total Seats : ");
                                event.setTotalSeats(scanner.nextInt());

                                System.out.print("Enter Ticket Price : ");
                                event.setTicketPrice(scanner.nextInt());
                                scanner.nextLine();

                                System.out.print("Enter Status (Upcoming/Completed/Cancelled/Postponed) : ");
                                event.setStatus(scanner.nextLine());


                                boolean result = controller.addEvent(event);

                                if (result) {
                                    System.out.println("Event Added Successfully.");
                                } else {
                                    System.out.println("Failed to Add Event.");
                                }
                                isAdmin = false;
                                break;


                            case 2:
                                System.out.println("--------- Add Category ----------");
                                CategoryDto category = new CategoryDto();

                                System.out.print("Enter Category Name:");
                                category.setCategoryName(scanner.nextLine());

                                System.out.print("Enter Description:");
                                category.setDescription(scanner.nextLine());

                                CategoryController categorycontroller = new CategoryController();

                                boolean result1 = categorycontroller.addCategory(category);

                                if (result1) {
                                    System.out.println("Category Added Successfully.");
                                } else {
                                    System.out.println("Failed to Add Category.");
                                }
                                isAdmin = false;
                                break;

                            case 3:
                                System.out.println("------------Add Client ------------");
                                ClientDto client = new ClientDto();


                                System.out.println("Enter ClientName :");
                                client.setClientName(scanner.nextLine());

                                System.out.println("Enter company name :");
                                client.setCompanyName(scanner.nextLine());

                                System.out.println("Enter Email");
                                client.setEmail(scanner.nextLine());

                                System.out.println("Enter PhoneNumber :");
                                client.setPhoneNumber(scanner.nextLong());
                                scanner.nextLine();

                                System.out.println("Enter Address :");
                                client.setAddress(scanner.nextLine());

                                System.out.println("Enter City :");
                                client.setCity(scanner.nextLine());

                                System.out.println("Enter State :");
                                client.setState(scanner.nextLine());

                                System.out.println("Enter Pincode :");
                                client.setPincode(scanner.nextLine());

                                ClientController clientController = new ClientController();
                                boolean result2 = clientController.addClient(client);

                                if (result2) {
                                    System.out.println("Client added Successfully");
                                } else {
                                    System.out.println("something went wrong");
                                }
                                isAdmin = false;
                                break;


                            case 4:
                                System.out.println("Get all events ");
                                List<EventDto> list = controller.retrieveAllData();

                                for (EventDto dto : list) {

                                    System.out.println("EventId :" + dto.getEventId());
                                    System.out.println("ClientId :" + dto.getClientId());
                                    System.out.println("CategoryId :" + dto.getCategoryId());
                                    System.out.println("EventName :" + dto.getEventName());
                                    System.out.println("EventVenue :" + dto.getEventVenue());
                                    System.out.println("Description :" + dto.getDescription());
                                    System.out.println("EventDate :" + dto.getEventDate());
                                    System.out.println("StartTime :" + dto.getStartTime());
                                    System.out.println("EndTime :" + dto.getEndTime());
                                    System.out.println("TotalSeats :" + dto.getTotalSeats());
                                    System.out.println("TicketPrice :" + dto.getTicketPrice());
                                    System.out.println("Status :" + dto.getStatus());

                                    System.out.println("----------------------------");

                                }
                                isAdmin = false;
                                break;

                            case 5:
                                System.out.println("Get EventName by venue ");
                                System.out.print("Enter place :");
                                String venue = scanner.nextLine();

                                String eventName = controller.getEventNameByPlace(venue);
                                if (eventName != null) {
                                    System.out.println("Event Name :" + eventName);
                                } else {
                                    System.out.println("No event found in this place");
                                }
                                isAdmin = false;
                                break;

                            case 6:
                                System.out.println("Get Event details by name and place");
                                System.out.print("Enter place :");
                                String venue1 = scanner.nextLine();
                                System.out.print("Enter Name :");
                                String name = scanner.nextLine();

                                List<EventDto> list1 = controller.getEventDetailsByPlaceAndName(venue1, name);

                                for (EventDto dto : list1) {

                                    System.out.println("EventId :" + dto.getEventId());
                                    System.out.println("ClientId :" + dto.getClientId());
                                    System.out.println("CategoryId :" + dto.getCategoryId());
                                    System.out.println("EventName :" + dto.getEventName());
                                    System.out.println("EventVenue :" + dto.getEventVenue());
                                    System.out.println("Description :" + dto.getDescription());
                                    System.out.println("EventDate :" + dto.getEventDate());
                                    System.out.println("StartTime :" + dto.getStartTime());
                                    System.out.println("EndTime :" + dto.getEndTime());
                                    System.out.println("TotalSeats :" + dto.getTotalSeats());
                                    System.out.println("TicketPrice :" + dto.getTicketPrice());
                                    System.out.println("Status :" + dto.getStatus());

                                    System.out.println("----------------------------");
                                }
                                isAdmin = false;
                                break;

                            case 7:
                                System.out.println("Update venue by event Name :");
                                System.out.print("Enter EventName :");
                                String EventName = scanner.nextLine();
                                System.out.print("Enter newVenue :");
                                String newVenue = scanner.nextLine();

                                int updated = controller.updateEventPlaceByEventName(EventName, newVenue);
                                if (updated > 0) {
                                    System.out.println("Place Updated");
                                } else {
                                    System.out.println("Sorry something went wrong");
                                }

                                System.out.println("Delete Event By Name");
                                System.out.print("Enter Event Name : ");
                                String eventName1 = scanner.nextLine();

                                int deleted = controller.deleteEventByName(eventName1);

                                if (deleted > 0) {
                                    System.out.println("Event Deleted Successfully.");
                                } else {
                                    System.out.println("Event Not Found.");
                                }
                                isAdmin = false;
                                break;


                            case 8:
                                System.out.println("Delete Event By Venue");
                                System.out.print("Enter Venue : ");
                                String venue2 = scanner.nextLine();

                                int deleted1 = controller.deleteEventByPlace(venue2);

                                if (deleted1 > 0) {
                                    System.out.println("Event Deleted Successfully.");
                                } else {
                                    System.out.println("Event Not Found.");
                                }
                                isAdmin = false;
                                break;

                            case 9:
                                System.out.println("Truncate Events Table");

                                int result3 = controller.truncateEventTable();

                                if (result3 > 0) {
                                    System.out.println("Events table truncated successfully.");
                                } else {
                                    System.out.println("Failed to truncate events table.");
                                }
                                isAdmin = false;
                                break;

                            case 10:
                                System.out.println("Drop Events Table");

                                int result4 = controller.dropEventTable();

                                if (result4 > 0) {
                                    System.out.println("Events table dropped successfully.");
                                } else {
                                    System.out.println("Failed to drop events table.");
                                }
                                isAdmin = false;
                                break;

                            default:
                                System.out.println("Invalid choice please choose a number between 1 & 10");
                                break;

                        }
                    }
                default:
                    System.out.println("Invalid choice please choose a number between 1 & 3");
                    break;
            }
            scanner.close();
            isRunning = false;
        }
    }
}

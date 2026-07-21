package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventDto {


    private int eventId;
    private int categoryId;
    private int clientId;
    private String eventName;
    private Date eventDate;
    private String eventVenue;
    private String description;
    private Time startTime;
    private Time endTime;
    private int totalSeats;
    private int ticketPrice;
    private String status;

}

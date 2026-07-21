package Dao.impl;

import Dao.EventDao;
import Dto.EventDto;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventDaoImpl implements EventDao {

    String url ="jdbc:mysql://localhost:3306/EventManagement_DB";
    String user = "root";
    String password = "Pajju#123";

    @Override
    public boolean addEvent(EventDto event) {

        if(event == null){
            return false;
        }
        String sql ="insert into events(client_id,category_id,event_name,description,venue,event_date,start_time,end_time,total_seats,ticket_price,status) values(?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            connection .setAutoCommit(false);

            statement.setInt(1,event.getClientId());
            statement.setInt(2,event.getCategoryId());
            statement.setString(3, event.getEventName());
            statement.setString(4, event.getDescription());
            statement.setString(5, event.getEventVenue());
            statement.setDate(6, event.getEventDate());
            statement.setTime(7, event.getStartTime());
            statement.setTime(8, event.getEndTime());
            statement.setInt(9, event.getTotalSeats());
            statement.setInt(10, event.getTicketPrice());
            statement.setString(11, event.getStatus());

            int row = statement.executeUpdate();
            if(row>0){
                connection.commit();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<EventDto> retrieveAllData() {

        List<EventDto> list = new ArrayList<>();

        String sql = "select * from events";
        try(Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()){

                EventDto event = new EventDto();

                event.setEventId(resultset.getInt(1));
                event.setClientId(resultset.getInt(2));
                event.setCategoryId(resultset.getInt(3));
                event.setEventName(resultset.getString(4));
                event.setDescription(resultset.getString(5));
                event.setEventVenue(resultset.getString(6));
                event.setEventDate(resultset.getDate(7));
                event.setStartTime(resultset.getTime(8));
                event.setEndTime(resultset.getTime(9));
                event.setTotalSeats(resultset.getInt(10));
                event.setTicketPrice(resultset.getInt(11));
                event.setStatus(resultset.getString(12));

                list.add(event);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getEventNameByPlace(String place) {


        if(place == null){
            return null;
        }

        String sql = "select event_name from events where venue =?";
        try(Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, place);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("event_name");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<EventDto> getEventDetailsByPlaceAndName(String place, String name) {

        List<EventDto> list = new ArrayList<>();
        if(place == null && name == null){
            return null;
        }

        String sql = "select * from events where venue =? and event_name =?";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, place);
            statement.setString(2,name);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()){
                EventDto event = new EventDto();

                event.setEventId(resultset.getInt(1));
                event.setClientId(resultset.getInt(2));
                event.setCategoryId(resultset.getInt(3));
                event.setEventName(resultset.getString(4));
                event.setDescription(resultset.getString(5));
                event.setEventVenue(resultset.getString(6));
                event.setEventDate(resultset.getDate(7));
                event.setStartTime(resultset.getTime(8));
                event.setEndTime(resultset.getTime(9));
                event.setTotalSeats(resultset.getInt(10));
                event.setTicketPrice(resultset.getInt(11));
                event.setStatus(resultset.getString(12));

                list.add(event);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateEventPlaceByEventName(String eventName, String newVenue) {
        if (eventName == null || eventName.trim().isEmpty() ||
                newVenue == null || newVenue.trim().isEmpty()) {
            return 0;
        }

        String sql = "UPDATE events SET venue = ? WHERE event_name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newVenue);
            statement.setString(2, eventName);

            int rows = statement.executeUpdate();

            if(rows >0){
                return 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteEventByName(String eventName) {

        if (eventName == null || eventName.trim().isEmpty()) {
            return 0;
        }

        String sql = "DELETE FROM events WHERE event_name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, eventName);

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteEventByPlace(String venue) {

        if (venue == null || venue.trim().isEmpty()) {
            return 0;
        }

        String sql = "DELETE FROM events WHERE venue = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, venue);

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int truncateEventTable() {

        String sql = "TRUNCATE TABLE events";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate();

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int dropEventTable() {

        String sql = "DROP TABLE events";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate();

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}

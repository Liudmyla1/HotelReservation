package models;

import entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.DBConnection.createConnection;

/**
 * The class provides access to room, room request and invoice entities.
 */
public class HotelDAO {
    UserDAO userDAO = new UserDAO();

    /**
     * Get room by its id.
     */
    public Room getRoom(int number) {
        Room room = new Room();
        String sql = "select * from room where number = " + number;

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            room.setNumber(resultSet.getInt(1));
            room.setCapacity(resultSet.getInt(2));
            room.setCategory(resultSet.getString(3));
            room.setCost(resultSet.getInt(4));
            room.setFree(resultSet.getBoolean(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    /**
     * (admin account)
     * Adds new room into database.
     */
    public boolean addRoom(Room room) {
        String sql = "insert into room (number, capacity, category, cost, isFree) values (" + room.getNumber() + ", "
                + room.getCapacity() + ", \"" + room.getCategory() + "\", " + room.getCost() + ", 0)";

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * (admin account)
     * Get free rooms to assign one.
     */
    public List<Room> getFreeRooms() {
        List<Room> roomList = null;
        String sql = "select * from room where isFree=1";

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            roomList = parseRoomSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    /**
     * Returns list of rooms, parsed from sql resultSet.
     */
    private List<Room> parseRoomSet(ResultSet resultSet) throws SQLException {
        List<Room> roomList = new ArrayList<Room>();
        while (resultSet.next()) {
            Room room = new Room();
            room.setNumber(resultSet.getInt(1));
            room.setCapacity(resultSet.getInt(2));
            room.setCategory(resultSet.getString(3));
            room.setCost(resultSet.getInt(4));
            room.setFree(resultSet.getBoolean(5));
            roomList.add(room);
        }

        return roomList;
    }

    /**
     * Get room request by its id.
     */
    public RoomRequest getRoomRequest(int number) {
        RoomRequest roomRequest = new RoomRequest();
        String sql = "select * from request where number = " + number;

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            roomRequest = parseRequestSet(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomRequest;
    }

    /**
     * (client account)
     * Creates a new request in database.
     */
    public boolean createRequest(RoomRequest roomRequest) {
        String sql = "insert into request (isOpened, client, checkIn, checkOut, peopleNum, category) values "
                + "(1, " + roomRequest.getClient().getId()
                + ", \"" + roomRequest.getCheckInDate() + "\", \"" + roomRequest.getCheckOutDate()
                + "\", " + roomRequest.getPeopleNum() + ", \"" + roomRequest.getCategory() + "\")";

        Connection con = createConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * (admin account)
     * Updates request by assigning room and admin.
     * Sets the room booked.
     */
    public boolean updateRequest(RoomRequest roomRequest) {
        String sql = "update request set room = " + roomRequest.getRoom().getNumber() + ", admin = " + roomRequest.getAdmin().getId()
                + ", invoice = " + roomRequest.getInvoice().getId() + " where id = " + roomRequest.getId();

        String sql2 = "update room set isFree = 0 where id = " + roomRequest.getRoom().getNumber();

        Connection con = createConnection();
        try {
            con.prepareStatement(sql).executeQuery();
            con.prepareStatement(sql2).executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * (admin account)
     * Closes request and sets booked room free.
     */
    public void closeRequest(int requestId, int roomId) {
        String sql = "update request set isOpened = 0 where id = " + requestId;
        String sql2 = "update room set isFree = 1 where id = " + roomId;

        Connection con = createConnection();
        try {
            con.prepareStatement(sql).executeQuery();
            con.prepareStatement(sql2).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * (admin account)
     * Get open requests to show in admin page.
     * Returns a list.
     */
    public List<RoomRequest> getOpenRequests() {
        List<RoomRequest> requestList = new ArrayList<RoomRequest>();
        String sql = "select * from request where isOpened=1";

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            requestList = parseRequestSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requestList;
    }

    /**
     * (client account)
     * Get requests made by client.
     * Returns a list.
     */
    public List<RoomRequest> getUserRequests(int userId) {
        List<RoomRequest> requestList = new ArrayList<RoomRequest>();
        String sql = "select * from request where client=" + userId;

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            requestList = parseRequestSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requestList;
    }

    /**
     * Returns list of requests, parsed from sql resultSet.
     */
    private List<RoomRequest> parseRequestSet(ResultSet resultSet) throws SQLException {
        List<RoomRequest> requestList = new ArrayList<RoomRequest>();
        while (resultSet.next()) {
            RoomRequest request = new RoomRequest();
            request.setId(resultSet.getInt(1));
            request.setOpened(resultSet.getBoolean(2));
            request.setRoom(getRoom(resultSet.getInt(3)));
            request.setClient((Client) userDAO.getUser(resultSet.getInt(4), false));
            request.setAdmin((Admin) userDAO.getUser(resultSet.getInt(5), true));
            request.setCheckInDate(resultSet.getDate(6));
            request.setCheckOutDate(resultSet.getDate(7));
            if (resultSet.getInt(8) != 0) {
                request.setInvoice(getInvoice(resultSet.getInt(8)));
            }
            request.setPeopleNum(resultSet.getInt(9));
            request.setCategory(resultSet.getString(10));
            requestList.add(request);
        }

        return requestList;
    }

    /**
     * Get invoice by its id.
     */
    public Invoice getInvoice(int id) {
        String sql = "select * from invoice where id = " + id;
        return parseInvoice(sql);
    }

    /**
     * Get invoice by its request id.
     */
    public Invoice getInvoice(RoomRequest request) {
        String sql = "select * from invoice where request = " + request.getId();
        return parseInvoice(sql);
    }

    private Invoice parseInvoice(String sql) {
        Invoice invoice = new Invoice();

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            invoice.setId(resultSet.getInt(1));
            invoice.setRequestId(resultSet.getInt(2));
            invoice.setTotalCost(resultSet.getInt(3));
            invoice.setPayed(resultSet.getBoolean(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoice;
    }

    /**
     * (admin account)
     * Creates invoice according to the request.
     */
    public void createInvoice(RoomRequest request) {
        int totalCost = request.getRoom().getCost() * request.getPeopleNum();
        String sql = "insert into invoice (request, totalCost, isPayed) values (" + request.getId() + ", " + totalCost + ", 0)";

        Connection con = createConnection();
        try {
            con.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

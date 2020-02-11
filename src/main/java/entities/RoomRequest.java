package entities;

import java.sql.Date;

public class RoomRequest {
    private int id;
    private boolean isOpened;
    private Room room;
    private Client client;
    private Admin admin;
    private Date checkInDate;
    private Date checkOutDate;
    private Invoice invoice;
    private int peopleNum;
    private String category;

    public RoomRequest() {
    }

    public RoomRequest(Client client, int peopleNum, String category, Date checkInDate, Date checkOutDate) {
        this.isOpened = true;
        this.client = client;
        this.peopleNum = peopleNum;
        this.category = category;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RoomRequest{" +
                "id=" + id +
                ", isOpened=" + isOpened +
                ", room=" + room +
                ", client=" + client +
                ", admin=" + admin +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", invoice=" + invoice +
                ", peopleNum=" + peopleNum +
                ", category='" + category + '\'' +
                '}';
    }
}

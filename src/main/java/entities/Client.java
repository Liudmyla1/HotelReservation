package entities;

import java.util.List;

public class Client {
    private int id;
    private String name;
    private String login;
    private String password;
    private List<RoomRequest> requestsList;

    public Client() {
    }

    public Client(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoomRequest> getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(List<RoomRequest> requestsList) {
        this.requestsList = requestsList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", requestsList=" + requestsList +
                '}';
    }
}

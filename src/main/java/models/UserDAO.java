package models;

import entities.Admin;
import entities.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static util.DBConnection.createConnection;

/**
 * The class provides access to admin and client entities.
 */
public class UserDAO {

    /**
     * Validates user.
     * @param login    user login
     * @param password user password
     * @param isAdmin  determines which type of user method has to validate
     * @return user id
     */
    public int validateUser(String login, String password, boolean isAdmin) {
        String sql;
        if(isAdmin) {
            sql = "select * from admin where login =? and password =?";
        } else {
            sql = "select * from client where login =? and password =?";
        }

        Connection con = createConnection();
        try {
            con.prepareStatement(sql).setString(1, login);
            con.prepareStatement(sql).setString(2, password);
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();

            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Adds new user into database.
     * @return if user was added (is to be replaced with custom exception)
     */
    public boolean addUser(Admin admin) {
        String sql = "insert into admin (name, login, password) values (\"" + admin.getName() + "\", \""
                + admin.getLogin() + "\", \"" + admin.getPassword() + "\")";

        Connection con = createConnection();
        try {
            ResultSet resultSet = con.prepareStatement(sql).executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addUser(Client client) {
        String sql = "insert into client (name, login, password) values (\"" + client.getName() + "\", \""
                + client.getLogin() + "\", \"" + client.getPassword() + "\")";

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
     * Gets user for its id.
     * @param id      user id
     * @param isAdmin determines which type of user is to be returned
     * @return instance of Admin/Client
     */
    public Object getUser(int id, boolean isAdmin) {
        Connection con = createConnection();
        try {
            if (isAdmin) {
                String sql = "select * from admin where id=" + id;
                ResultSet resultSet = con.prepareStatement(sql).executeQuery();
                Admin admin = new Admin();
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setLogin(resultSet.getString(3));
                admin.setPassword(resultSet.getString(4));
                return admin;
            } else {
                String sql = "select * from client where id=" + id;
                ResultSet resultSet = con.prepareStatement(sql).executeQuery();
                Client client = new Client();
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                client.setLogin(resultSet.getString(3));
                client.setPassword(resultSet.getString(4));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

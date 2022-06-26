package org.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.booking.data.NetworkDeviceBooking;
import org.booking.daointer.BookingDAO;

public class BookingDAOImp implements BookingDAO
{
    private Connection con;

    public BookingDAOImp(Connection con) {
        this.con = con;
    }

    /*
    * TABLES
    * network_device
    * id, name, ...
    *
    * user
    * id, name, email, ...
    *
    * booking
    * id, start, end,
    *
    * booking_table_map
    * device_id, user_id, booking_id
    *
    * */
    private final String SQL_GET_NETWORK_DEVICE =
            "SELECT b.id AS id, d.name AS deviceName, u.name AS userName, b.start_date AS startDate, b.end_date AS endDate " +
            "FROM network_device d" +
            "LEFT JOIN booking_table_map btm ON btm.device_id = d.id " +
            "LEFT JOIN booking b ON d.id = btm.booking_id " +
            "LEFT JOIN user u ON u.id = btm.user_id " +
            "WHERE d.id = ? AND b.start_date >= ? AND b.start_date <= ?";

    private final String SQL_END_BOOKING =
                    "UPDATE booking SET end_date = NOW()" +
                    "WHERE id = ? AND start_date = ?";
    @Override
    public List<NetworkDeviceBooking> getNetworkDevices(int deviceId, Date startDate, Date endDate) {
        try
        {
            PreparedStatement preparedStatement = null;
            preparedStatement = con.prepareStatement(SQL_GET_NETWORK_DEVICE);
            preparedStatement.setInt(1, deviceId);
            preparedStatement.setDate(2, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(3, new java.sql.Date(endDate.getTime()));
            ResultSet res = preparedStatement.executeQuery();
            return processNetworkDeviceProvider(res);
        } catch (SQLException e) {
            e.printStackTrace();
            // to throw some exeprion
            return null;
        }
    }

    @Override
    public void bookDevice(NetworkDeviceBooking networkDevice) {

    }

    @Override
    public void endBooking(NetworkDeviceBooking networkDevice) {
        try
        {
            PreparedStatement preparedStatement = null;
            preparedStatement = con.prepareStatement(SQL_END_BOOKING);
            preparedStatement.setInt(1, networkDevice.getId());
            preparedStatement.setDate(2, new java.sql.Date(networkDevice.getBookStart().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // to throw some exeprion
        }
    }

    @Override
    public List<NetworkDeviceBooking> getNetworkDeviceBooking(int bookingId) {
        return null;
    }

    private List<NetworkDeviceBooking> processNetworkDeviceProvider(ResultSet res) throws SQLException {
        List<NetworkDeviceBooking> networkDeviceResult = new ArrayList<>();
        while(res.next()){
            networkDeviceResult.add(getNetworkDevices(res));
        }
        return networkDeviceResult;
    }

    private NetworkDeviceBooking getNetworkDevices(ResultSet res) throws SQLException {
        return new NetworkDeviceBooking(res.getInt("id"), res.getString("deviceName"),
                res.getString("userName"), res.getDate("startDate"), res.getDate("startEnd"));
    }
}

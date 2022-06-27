package org.booking.services;

import java.util.Date;
import java.util.List;

import org.booking.daointer.BookingDAO;
import org.booking.data.NetworkDeviceBooking;
import org.boooking.provider.BookingInter;

public class BookingImpl implements BookingInter
{
    private final BookingDAO bookingDAO;

    private static final int MAX_MIN_TO_BOOK_DEVICE = 240;

    public BookingImpl(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public List<NetworkDeviceBooking> getNetworkDeviceBooking(int deviceId, Date startDate, Date endDate)
    {
        return bookingDAO.getNetworkDevices(deviceId, startDate, endDate);
    }

    @Override
    public void bookDevice(NetworkDeviceBooking networkDevice) {
        if (!differenceFourHrs(networkDevice.getBookStart(), networkDevice.getBookEnd()) ) {
            // if diff is greater that 4 hre thow erroe
        }
        bookingDAO.bookDevice(networkDevice);
    }

    @Override
    public void endBooking(NetworkDeviceBooking networkDevice) {
        bookingDAO.endBooking(networkDevice);
    }

    @Override
    public List<NetworkDeviceBooking> getNetworkDeviceBooking(int bookingId) {
       return bookingDAO.getNetworkDeviceBooking(bookingId);
    }

    private boolean differenceFourHrs (Date start, Date end) {
        // to find out diff between two days;
        return true;
    }
}

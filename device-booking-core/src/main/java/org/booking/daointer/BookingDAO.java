package org.booking.daointer;

import java.util.Date;
import java.util.List;

import org.booking.data.NetworkDeviceBooking;

public interface BookingDAO
{
    List<NetworkDeviceBooking> getNetworkDevices(int deviceId, Date startDate, Date endDate);

    void bookDevice(NetworkDeviceBooking networkDevice);

    void endBooking(NetworkDeviceBooking networkDevice);

    List<NetworkDeviceBooking> getNetworkDeviceBooking(int bookingId);
}

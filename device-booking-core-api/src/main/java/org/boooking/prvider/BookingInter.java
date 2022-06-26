package org.boooking.prvider;

import java.util.Date;
import java.util.List;

import org.booking.data.NetworkDeviceBooking;

public interface BookingInter
{
    List<NetworkDeviceBooking> getNetworkDeviceBooking(int deviceId, Date startDate, Date endDate);

    void bookDevice(NetworkDeviceBooking networkDevice);

    void endBooking(NetworkDeviceBooking networkDevice);

    List<NetworkDeviceBooking> getNetworkDeviceBooking(int bookingId);
}

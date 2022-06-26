package org.booking.data;

import java.util.Date;
import java.util.Objects;

public class NetworkDeviceBooking
{
    private final int id;
    private final String networkDeviceName;

    private final String bookBy;

    private final Date bookStart;

    private final Date bookEnd;

    public NetworkDeviceBooking(int id, String networkDeviceName, String bookBy, Date bookstart, Date bookend)
    {
        this.id = id;
        this.networkDeviceName = networkDeviceName;
        this.bookBy = bookBy;
        this.bookStart = bookstart;
        this.bookEnd = bookend;
    }

    public int getId()
    {
        return id;
    }

    public String getNetworkDeviceName()
    {
        return networkDeviceName;
    }

    public String getBookBy()
    {
        return bookBy;
    }

    public Date getBookStart()
    {
        return bookStart;
    }

    public Date getBookEnd()
    {
        return bookEnd;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof NetworkDeviceBooking)) return false;
        NetworkDeviceBooking that = (NetworkDeviceBooking) o;
        return id == that.id && Objects.equals(networkDeviceName, that.networkDeviceName) && Objects.equals(bookBy, that.bookBy) && Objects.equals(bookStart, that.bookStart) && Objects.equals(bookEnd, that.bookEnd);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, networkDeviceName, bookBy, bookStart, bookEnd);
    }

    @Override
    public String toString()
    {
        return "NetworkDevice{" +
                "id=" + id +
                ", networkDeviceName='" + networkDeviceName + '\'' +
                ", bookBy='" + bookBy + '\'' +
                ", bookStart=" + bookStart +
                ", bookEnd=" + bookEnd +
                '}';
    }
}

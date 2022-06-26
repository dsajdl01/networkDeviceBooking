package org.booking.data;

import java.util.Objects;

public class NetworkDevice
{
    final int id;

    final String name;

    final boolean currentlyBooked;

    public NetworkDevice(int id, String name, boolean currentlyBooked)
    {
        this.id = id;
        this.name = name;
        this.currentlyBooked = currentlyBooked;
    }


    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isCurrentlyBooked()
    {
        return currentlyBooked;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof NetworkDevice)) return false;
        NetworkDevice that = (NetworkDevice) o;
        return id == that.id && currentlyBooked == that.currentlyBooked && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, currentlyBooked);
    }

    @Override
    public String toString()
    {
        return "NetworkDevice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentlyBooked=" + currentlyBooked +
                '}';
    }
}

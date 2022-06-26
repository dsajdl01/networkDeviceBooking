package org.response.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkDeviceBookingJson
{

    @JsonProperty("deviceId")
    private final Integer deviceId;

    @JsonProperty("networkDeviceName")
    private final String networkDeviceName;

    @JsonProperty("bookBy")
    private final String bookBy;

    @JsonProperty("bookStart")
    private final Date bookStart;

    @JsonProperty("bookEnd")
    private final Date bookEnd;

    @JsonCreator
    public NetworkDeviceBookingJson(@JsonProperty("deviceId") final Integer deviceId,
                                 @JsonProperty("networkDeviceName") final String networkDeviceName,
                                 @JsonProperty("bookBy") final String bookBy,
                                 @JsonProperty("bookStart") final Date bookStart,
                                 @JsonProperty("bookEnd") final  Date bookEnd)
    {
        this.deviceId = deviceId;
        this.networkDeviceName = networkDeviceName;
        this.bookBy = bookBy;
        this.bookStart = bookStart;
        this.bookEnd = bookEnd;
    }

    public Integer getDeviceId()
    {
        return deviceId;
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
    public String toString()
    {
        return "NetworkDeviceBookingJson{" +
                "deviceId=" + deviceId +
                ", networkDeviceName='" + networkDeviceName + '\'' +
                ", bookBy='" + bookBy + '\'' +
                ", bookStart=" + bookStart +
                ", bookEnd=" + bookEnd +
                '}';
    }
}

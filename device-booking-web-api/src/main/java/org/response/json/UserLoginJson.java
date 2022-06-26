package org.response.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginJson
{
    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonCreator
    public UserLoginJson(@JsonProperty("email") final String email,
                         @JsonProperty("password") final String password)
    {
        this.email = email;
        this.password = password;
    }
}

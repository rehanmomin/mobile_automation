package com.hubilo.pojo.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @created: 2022-07-20-8:36 PM
 * @project: Mobile_UI_Automation under @package: @package: com.hubilo.pojo.ui
 * @author: Rehan
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TC_NAME",
        "MESSAGE"
})

public class BChatMessage {

    @JsonProperty("TC_NAME")
    private String tc;

    @JsonProperty("MESSAGE")
    private String message;

    @JsonProperty("TC_NAME")
    public String getTC() {
        return tc;
    }

    @JsonProperty("TC_NAME")
    public void setTC(String tc) { this.tc = tc; }

    @JsonProperty("MESSAGE")
    public String getMessage() {
        return message;
    }

    @JsonProperty("MESSAGE")
    public void setMessage(String message) { this.message = message; }

}

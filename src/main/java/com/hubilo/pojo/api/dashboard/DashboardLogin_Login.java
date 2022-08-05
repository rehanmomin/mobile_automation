package com.hubilo.pojo.api.dashboard;


import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data"
})
@Generated("jsonschema2pojo")
public class DashboardLogin_Login {

@JsonProperty("data")
private DashboardLogin_Data dashboardLogin_Data;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("data")
public DashboardLogin_Data getData() {
return dashboardLogin_Data;
}

@JsonProperty("data")
public void setData(DashboardLogin_Data dashboardLogin_Data) {
this.dashboardLogin_Data = dashboardLogin_Data;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
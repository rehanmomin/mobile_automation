package com.hubilo.pojo.api.login;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data"
})
@Generated("jsonschema2pojo")
public class Login_Payload {

@JsonProperty("data")
private Login_Data Login_Data;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("data")
public Login_Data getData() {
return Login_Data;
}

@JsonProperty("data")
public void setData(Login_Data data) {
this.Login_Data = Login_Data;
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



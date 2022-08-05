package com.hubilo.pojo.api.dashboard;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"email",
"password",
"captchaToken"
})
@Generated("jsonschema2pojo")
public class DashboardLogin_Data {

@JsonProperty("email")
private String email;
@JsonProperty("password")
private String password;
@JsonProperty("captchaToken")
private String captchaToken;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
}

@JsonProperty("password")
public String getPassword() {
return password;
}

@JsonProperty("password")
public void setPassword(String password) {
this.password = password;
}

@JsonProperty("captchaToken")
public String getCaptchaToken() {
return captchaToken;
}

@JsonProperty("captchaToken")
public void setCaptchaToken(String captchaToken) {
this.captchaToken = captchaToken;
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

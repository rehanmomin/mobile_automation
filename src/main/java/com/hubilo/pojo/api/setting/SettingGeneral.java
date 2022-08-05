package com.hubilo.pojo.api.setting;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data"
})
@Generated("jsonschema2pojo")
public class SettingGeneral {

@JsonProperty("data")
private SettingGeneral_Data settingGeneral_Data;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("data")
public SettingGeneral_Data getData() {
return settingGeneral_Data;
}

@JsonProperty("data")
public void setData(SettingGeneral_Data settingGeneral_Data) {
this.settingGeneral_Data = settingGeneral_Data;
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
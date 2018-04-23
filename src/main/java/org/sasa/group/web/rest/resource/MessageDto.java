package org.sasa.group.web.rest.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {

    private String messageType;

    private Object value;

}

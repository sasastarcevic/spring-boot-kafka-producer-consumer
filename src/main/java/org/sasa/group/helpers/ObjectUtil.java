package org.sasa.group.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtil {

    public static String javaObjectToJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

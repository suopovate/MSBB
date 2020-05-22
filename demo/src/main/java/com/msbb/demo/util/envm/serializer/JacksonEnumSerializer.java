package com.msbb.demo.util.envm.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

import static com.msbb.demo.util.envm.EnumSerializeUtil.findEnumValue;

/**
 * @author vate
 */
public class JacksonEnumSerializer extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Object enumFieldValue = findEnumValue(value);
        serializers.defaultSerializeValue(enumFieldValue,gen);
    }
}

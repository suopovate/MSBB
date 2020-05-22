package com.msbb.demo.util.envm.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msbb.demo.util.envm.EnumSerializeUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ValuedEnumConverter implements ConverterFactory<String, Enum> {
    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new ObjectToEnum(targetType);
    }

    private class ObjectToEnum<T extends Enum> implements Converter<String,T> {

        private final T[] values;

        public ObjectToEnum(Class<T> targetType) {
            values = targetType.getEnumConstants();
        }

        @Override
        public T convert(String source) {
            for (T t : values) {
                ObjectMapper mapper = new ObjectMapper();
                Object enumValue = EnumSerializeUtil.findEnumValue(t);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                try {
                    mapper.writer().writeValue(os,enumValue);
                    String enumValueStr = os.toString();
                    if (enumValueStr.equals(source)){
                        return t;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
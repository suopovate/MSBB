package com.msbb.demo.util.envm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author vate
 */
public class EnumSerializeUtil {

    public static final String METHOD_PREFIX_GET = "get";

    public static Object findEnumValue(Object value) {
        Assert.isTrue(value.getClass().isEnum(),"Serialize Enum Failed,the value is not Enum type.");

        Field[] fields = value.getClass().getDeclaredFields();
        Optional<Field> enumFieldOptional = Arrays.stream(fields).filter(EnumSerializeUtil::hasEnumValueAnnotated).findFirst();

        Assert.isTrue(enumFieldOptional.isPresent(),"Serialize Enum Failed,can't found the JsonEnumValue field in Enum Object.");
        //orElseThrow(() -> new IllegalStateException(String.format("Serialize Enum Failed,can't found the getter method of field %s", enumFieldOptional.get().getName())))
        Field enumField = enumFieldOptional.get();
        Method method = getGetMethod(enumField.getName(), value.getClass()).get();
        Object enumFieldValue;
        try {
            enumFieldValue = method.invoke(value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(String.format("Serialize Enum Failed,can't invoke the getter method of %s", enumField.getName()),e);
        }
        return enumFieldValue;
    }

    public static Optional<Method> getGetMethod(String name, Class<?> clazz) {
        String methodName;
        if (name.length() == 1){
            methodName = METHOD_PREFIX_GET + name.toUpperCase();
        }else {
            String firstChar = name.substring(0,1);
            methodName = METHOD_PREFIX_GET + (StringUtils.isAllLowerCase(firstChar) ? firstChar.toUpperCase() + name.substring(1) : name);
        }
        try {
            return Optional.of(clazz.getDeclaredMethod(methodName));
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        }
    }

    public static boolean hasEnumValueAnnotated(Field field) {
        Annotation[] annotations = field.getAnnotations();
        return Arrays.stream(annotations)
                .anyMatch(annotation -> JsonEnumValue.class.isAssignableFrom(annotation.getClass()));
    }
}

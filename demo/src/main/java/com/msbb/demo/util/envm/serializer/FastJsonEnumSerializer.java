package com.msbb.demo.util.envm.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.msbb.demo.util.envm.EnumSerializeUtil;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author vate
 * FastJson 的序列化器是需要针对具体类型去配置的，否则无法生效
 * 如：
 * 枚举 Status : SerializeConfig.getGlobalInstance().put(Status.class, new FastJsonEnumSerializer());
 * 枚举 Status2 : SerializeConfig.getGlobalInstance().put(Status2.class, new FastJsonEnumSerializer());
 * 必须单个注册
 */
public class FastJsonEnumSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        serializer.write(EnumSerializeUtil.findEnumValue(object));
    }
}

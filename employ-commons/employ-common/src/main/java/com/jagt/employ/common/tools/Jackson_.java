package com.jagt.employ.common.tools;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 
 * Json工具类，基于Jackson实现
 * 
 * @version  1.2
 * @author   gotanks
 * @since     2019-03-19
 * 
 */
@SuppressWarnings("rawtypes")
public class Jackson_ {

    /**
     * 将对象转化成json
     *
     * @param t
     * @return
     * @throws JsonProcessingException
     */
    public static <T> String toJson(T t) throws JsonProcessingException {
        return OBJECT_MAPPER.get().writeValueAsString(t);
    }

    /**
     * 将json转化成bean
     *
     * @param json
     * @param valueType
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T toBean(String json, Class<T> valueType)
            throws JsonParseException, JsonMappingException, IOException {
        return OBJECT_MAPPER.get().readValue(json, valueType);
    }

    /**
     * 将json转化成List
     *
     * @param json
     * @param collectionClass
     * @param elementClass
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> List<T> toList(String json, Class<? extends List> collectionClass, Class<T> elementClass)
            throws JsonParseException, JsonMappingException, IOException {
        JavaType javaType = OBJECT_MAPPER.get().getTypeFactory().constructCollectionType(collectionClass, elementClass);
        return OBJECT_MAPPER.get().readValue(json, javaType);
    }

    /**
     * 将json转化成Map
     *
     * @param json
     * @param mapClass
     * @param keyClass
     * @param valueClass
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
	public static <K, V> Map<K, V> toMap(String json, Class<? extends Map> mapClass, Class<K> keyClass,
            Class<V> valueClass) throws JsonParseException, JsonMappingException, IOException {
        JavaType javaType = OBJECT_MAPPER.get().getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
        return OBJECT_MAPPER.get().readValue(json, javaType);
    }


    /**
     * 将源对象转为一个具有相似属性的目标对象
     *
     * @param srcObj
     * @param targetObjClazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @throws IOException
     */
    public static <T> T copyProperties(Object srcObj, Class<T> targetObjClazz) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
        return toBean(toJson(srcObj), targetObjClazz);
    }

    // ################################################################################################################

    /**
     * 禁止调用无参构造
     */
    private Jackson_() {
    	
    }

    /**
     * 使用ThreadLocal创建对象，防止出现线程安全问题
     */
    private static final ThreadLocal<ObjectMapper> OBJECT_MAPPER = new ThreadLocal<ObjectMapper>() {
        @Override
        protected ObjectMapper initialValue() {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略不存在的字段
            return objectMapper;
        }
    };
}

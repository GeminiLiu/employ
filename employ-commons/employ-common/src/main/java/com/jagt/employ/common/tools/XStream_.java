package com.jagt.employ.common.tools;

import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;

/**
 * 基于XStream的简单的XML解析工具类
 * 不完全，建议直接使用XStream
 * 
 * @version 1.1
 * @author gotanks
 *
 */
@Slf4j
public class XStream_ {

    public static <T> XStream build(Class<T> clazz) {
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        xstream.ignoreUnknownElements();
        xstream.autodetectAnnotations(true);
        xstream.setClassLoader(clazz.getClassLoader());
        return xstream;
    }

    @Deprecated
	public static <T> T fromXML(Class<T> clazz, String xml) {
        try {
            return (T) build(clazz).fromXML(xml);
        } catch (Exception e) {
            log.error("[XStream]XML转对象出错："+e);
            throw new RuntimeException("[XStream]XML转对象出错");
        }
    }
	
	/**
     * 将Object转化为XML字符串
     * @param obj
     * @return
     * @throws Exception
     */
    public static String toXML(Object obj) throws Exception {
        XStream xstream = new XStream();
        if (obj == null) {
        	return null;
        }
        return xstream.toXML(obj);
    }

}

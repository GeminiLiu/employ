package com.jagt.employ.common.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 
 * URL地址字符串工具类
 * 
 * @version  1.0
 * @author   gotanks
 * @since     2019-03-20
 * 
 */
public class Url_ {
	/** 
     * 向url链接追加参数 
     * @param url 
     * @param params Map<String, String> 
     * @return 
     */  
    public static String appendParams(String url, Map<String, String> params){  
        if(String_.isBlank(url)){  
            return "";
        }else if(params == null || params.size()==0){  
            return url.trim();
        }else{  
            StringBuffer sb = new StringBuffer("");
            Set<String> keys = params.keySet();
            for (String key : keys) {  
                sb.append(key).append("=").append(params.get(key)).append("&");
            }  
            sb.deleteCharAt(sb.length() - 1);
              
            url = url.trim();
            int length = url.length();
            int index = url.indexOf("?");
            if(index > -1){//url说明有问号  
                if((length - 1) == index){//url最后一个符号为？，如：http://wwww.baidu.com?  
                    url += sb.toString();
                }else{//情况为：http://wwww.baidu.com?aa=11  
                    url += "&" + sb.toString();
                }  
            }else{//url后面没有问号，如：http://wwww.baidu.com  
                url += "?" + sb.toString();
            }  
            return url;
        }  
    }  
      
    /** 
     * 向url链接追加参数(单个) 
     * @param url 
     * @param name String 
     * @param value String 
     * @return 
     */  
    public static String appendParam(String url, String name, String value){  
        if(String_.isBlank(url)){  
            return "";
        }else if(String_.isBlank(name)){  
            return url.trim();
        }else{  
            Map<String, String> params = new HashMap<String, String>();
            params.put(name, value);
            return appendParams(url, params);
        }  
    }  
      
    /** 
     * 移除url链接的多个参数 
     * @param url String 
     * @param paramNames String[] 
     * @return 
     */  
    public static String removeParams(String url, String... paramNames){  
        if(String_.isBlank(url)){  
            return "";
        }else if(paramNames==null || paramNames.length==0){  
            return url.trim();
        }else{  
            url = url.trim();
            int length = url.length();
            int index = url.indexOf("?");
            if(index > -1){//url说明有问号  
                if((length - 1) == index){//url最后一个符号为？，如：http://wwww.baidu.com?  
                    return url;
                }else{//情况为：http://wwww.baidu.com?aa=11或http://wwww.baidu.com?aa=或http://wwww.baidu.com?aa  
                    String baseUrl = url.substring(0, index);
                    String paramsString = url.substring(index + 1);
                    String[] params = paramsString.split("&");
                    if(params!=null && params.length>0){  
                        Map<String, String> paramsMap = new HashMap<String, String>();
                        for (String param : params) {  
                            if(!String_.isBlank(param)){  
                                String[] oneParam = param.split("=");
                                String paramName = oneParam[0];
                                int count = 0;
                                for(int i=0; i<paramNames.length; i++){  
                                    if(paramNames[i].equals(paramName)){  
                                        break;
                                    }  
                                    count ++;
                                }  
                                if(count == paramNames.length){  
                                    paramsMap.put(paramName, (oneParam.length > 1)?oneParam[1]:"");
                                }  
                            }  
                        }  
                        if(paramsMap!=null && paramsMap.size()>0){  
                            StringBuffer paramBuffer = new StringBuffer(baseUrl);
                            paramBuffer.append("?");
                            Set<String> set = paramsMap.keySet();
                            for (String paramName : set) {  
                                paramBuffer.append(paramName).append("=").append(paramsMap.get(paramName)).append("&");
                            }  
                            paramBuffer.deleteCharAt(paramBuffer.length() - 1);
                            return paramBuffer.toString();
                        }  
                        return baseUrl;
                    }  
                }  
            }  
            return url;
        }  
    }  
    
    /**
     * 和javascript中的encodeURIComponent方法效果相同
     *
     * @param component
     * @return
     */
    public static String encodeURIComponent(String component) {
        String result = null;
        try {
            result = URLEncoder.encode(component, "UTF-8")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = component;
        }
 
        return result;
    }
    
    /**
     * 将URL中的查询参数部分解析成键值对
     *
     * @param queryString URL中的查询参数部分，不含前缀'?'
     * @return
     */
    public static Map<String, String> splitQuery(String queryString) {
        final Map<String, String> query_pairs = new ConcurrentHashMap<String, String>();
        if(queryString == null) return query_pairs;
        final String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            final int idx = pair.indexOf("=");
            String key;
            try {
                key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
                final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1),
                                                                                            "UTF-8") : null;
                if (!key.isEmpty()) {
                    query_pairs.put(key, value);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return query_pairs;
    }
}

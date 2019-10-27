//package com.jagt.employ.common.tools;
//
//import org.apache.commons.io.IOUtils;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URI;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// *
// * http客户端工具类
// *
// * @version  1.0
// * @author   gotanks
// * @since     2019-04-02
// *
// */
//public class HttpClient_ {
//
//	/**
//	 * GET方式调用
//	 * @param url
//	 * @param param
//	 * @return
//	 */
//	public static String doGet(String url, Map<String, String> param) {
//		String resultString = "";
//		try {
//			// 创建uri
//			URIBuilder builder = new URIBuilder(url);
//			if (param != null) {
//				for (String key : param.keySet()) {
//					builder.addParameter(key, param.get(key));
//				}
//			}
//			URI uri = builder.build();
//
//			// 创建http GET请求
//			HttpGet httpGet = new HttpGet(uri);
//
//			// 执行请求
//		    try (
//		            CloseableHttpClient httpClient = HttpClients.createDefault();
//		            CloseableHttpResponse response = httpClient.execute(httpGet);
//		            ){
//		        // 判断返回状态是否为200
//		        if (response.getStatusLine().getStatusCode() == 200) {
//		            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		        }
//		    }
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resultString;
//	}
//
//	/**
//	 * GET方式调用
//	 * @param url
//	 * @return
//	 */
//	public static String doGet(String url) {
//		return doGet(url, null);
//	}
//
//	/**
//	 * POST方式调用
//	 * @param url
//	 * @param param
//	 * @return
//	 */
//	public static String doPost(String url, Map<String, String> param) {
//		String resultString = "";
//		try {
//			// 创建Http Post请求
//			HttpPost httpPost = new HttpPost(url);
//			// 创建参数列表
//			if (param != null) {
//				List<NameValuePair> paramList = new ArrayList<>();
//				for (String key : param.keySet()) {
//					paramList.add(new BasicNameValuePair(key, param.get(key)));
//				}
//				// 模拟表单
//				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
//				httpPost.setEntity(entity);
//			}
//			// 执行http请求
//            try (
//                    CloseableHttpClient httpClient = HttpClients.createDefault();
//                    CloseableHttpResponse response = httpClient.execute(httpPost);
//                    ){
//                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//            }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return resultString;
//	}
//
//	/**
//	 * POST方式调用
//	 * @param url
//	 * @return
//	 */
//	public static String doPost(String url) {
//		return doPost(url, null);
//	}
//
//	/**
//	 * POST方式调用,参数为json
//	 * @param url
//	 * @param json
//	 * @return
//	 */
//	public static String doPostJson(String url, String json) {
//		String resultString = "";
//		try {
//			// 创建Http Post请求
//			HttpPost httpPost = new HttpPost(url);
//			// 创建请求内容
//			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
//			httpPost.setEntity(entity);
//            // 执行http请求
//            try (
//                    CloseableHttpClient httpClient = HttpClients.createDefault();
//                    CloseableHttpResponse response = httpClient.execute(httpPost);
//                    ){
//                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//            }
//			// 执行http请求
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return resultString;
//	}
//
//	public static File download(String url, File destFile) {
//        try {
//        	//
//            URLConnection connection = new URL(url).openConnection();
//            //设置超时间为3秒
//            connection.setConnectTimeout(10*1000);
//            //防止屏蔽程序抓取而返回403错误
//            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//            try (
//                InputStream is = connection.getInputStream();
//                FileOutputStream fos = new FileOutputStream(destFile);
//            ){
//                IOUtils.copy(is, fos);
//            }
//        } catch (IOException e) {
//        	e.printStackTrace();
//        }
//        return destFile;
//    }
//
//	public static void main(String[] args) {
//		HttpClient_.download(
//				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1555308008&di=b7edaf0838f51d033603b9031421a998&imgtype=jpg&er=1&src=http%3A%2F%2Ftgi12.jia.com%2F116%2F269%2F16269456.jpg",
//				new File("C:/test/aaa/aaa.jpg")
//				);
//	}
//}

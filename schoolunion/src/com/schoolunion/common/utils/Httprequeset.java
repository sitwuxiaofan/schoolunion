package com.schoolunion.common.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Httprequeset {
	//private static Logger logger = Logger.getLogger(Httprequeset.class);
	
	//private static String url6 = "http://liuliangapp.com/api/url/validate";

	public String Get(String url) throws Exception{
		HttpClient httpClient = new HttpClient();
		String result="";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("secret", "bLT?lAgO?zx=mNTJb85ryzRM<]s^wpxQ?_x0NLRMu2:Hosxp2ne^cIXjF`G9Ez9K");
        int statusCode =  httpClient.executeMethod(getMethod);
        if(statusCode == 200) {
            System.out.println("访问成功");
            result = getMethod.getResponseBodyAsString();
            System.out.println(result);
        }
        else {
            System.out.println("错误码" + statusCode);
            return "访问失败" + statusCode;
        }
        return result;
	}
	
	public String Post(String url) throws Exception{
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setParameter("url", "https://item.taobao.com/item.htm?id=531027639098");
        postMethod.setParameter("cache", "true");
        postMethod.setRequestHeader("secret", "bLT?lAgO?zx=mNTJb85ryzRM<]s^wpxQ?_x0NLRMu2:Hosxp2ne^cIXjF`G9Ez9K");
        //postMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
        //postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }
        else {
            return "错误码" + statusCode;
        }
        return result;
	}
	
	public static String requestId(String url){
		HttpClient httpClient = new HttpClient();
		GetMethod getmethod = new GetMethod(url);
		try {
			httpClient.executeMethod(getmethod);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	Header[] head = getmethod.getResponseHeaders();
    	for (int i = 0; i < head.length; i++) {
    		if(head[i].getName().equals("at_itemId")){
    			return head[i].getValue();
    		}
    			
		}
    	return "";
	}
}

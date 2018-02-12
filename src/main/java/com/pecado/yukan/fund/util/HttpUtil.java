package com.pecado.yukan.fund.util;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author yukan
 * @date 2018/2/12
 * @email yukan.cn.mail@gmail.com
 */
public class HttpUtil {

    private static Log log = LogFactory.getLog(HttpUtil.class);

    private static final String CHARSET = "UTF-8";

    public static String get(String url, Map<String, String> params) {
        return get(url, params, CHARSET);
    }

    public static String get(String url, Map<String, String> params, String charset) {
        CloseableHttpClient httpClient = null;

        try {
            httpClient = HttpClients.createDefault();
            HttpEntity httpEntity = get(httpClient,url,params,charset);
            return EntityUtils.toString(httpEntity, charset);
        } catch (IOException | ParseException var15) {
            log.error("get.error={}", var15);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var14) {
                log.error("close.error={}", var14);
            }

        }

        return null;
    }

    public static HttpEntity get(HttpClient httpClient, String url, Map<String, String> params, String charset) {
        if (url != null && !"".equals(url)) {
            HttpGet httpGet = null;
            HttpResponse httpResponse = null;
            HttpEntity httpEntity = null;

            try {
                if (params != null && !params.isEmpty()) {
                    List<NameValuePair> pairs = new ArrayList();
                    Iterator var8 = params.entrySet().iterator();

                    while(var8.hasNext()) {
                        Entry<String, String> entry = (Entry)var8.next();
                        pairs.add(new BasicNameValuePair((String)entry.getKey(), formatStr((String)entry.getValue())));
                    }

                    url = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
                }

                httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    httpGet.abort();
                    throw new RuntimeException("HttpClient, error status code :" + statusCode);
                }

                httpEntity = httpResponse.getEntity();
            } catch (IOException | ParseException var10) {
                log.error("get.error={}", var10);
            }

            return httpEntity;
        } else {
            return null;
        }
    }

    private static String formatStr(String text) {
        return null == text ? "" : text.trim();
    }

    public static String post(String url, Map<String, String> map) {
        HttpPost httpPost = new HttpPost(url);
        if (map != null && !map.isEmpty()) {
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(map), "UTF-8");
            httpPost.setEntity(stringEntity);
        }

        return post(httpPost);
    }

    public static String postJson(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        if (json != null && !"".equals(url)) {
            StringEntity stringEntity = new StringEntity(json, "UTF-8");
            httpPost.setEntity(stringEntity);
        }

        httpPost.setHeader("Content-Type", "application/json");
        return post(httpPost);
    }

    public static String postForm(String url, Map<String, String> map) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        if (map != null && !map.isEmpty()) {
            List<NameValuePair> formparams = new ArrayList();
            Iterator var4 = map.entrySet().iterator();

            while(var4.hasNext()) {
                Entry<String, String> entry = (Entry)var4.next();
                formparams.add(new BasicNameValuePair((String)entry.getKey(), formatStr((String)entry.getValue())));
            }

            try {
                UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
                httpPost.setEntity(uefEntity);
            } catch (UnsupportedEncodingException var6) {
                log.error("postForm.error={}", var6);
            }
        }

        return post(httpPost);
    }

    public static String postEntity(String url, HttpEntity httpEntity) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(httpEntity);
        return post(httpPost);
    }

    public static String post(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String responseContent = null;

        try {
            httpClient = HttpClients.createDefault();
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }

            HttpEntity entity = httpResponse.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException | ParseException var14) {
            log.error("post.error={}", var14);
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var13) {
                log.error("close.error={}", var13);
            }

        }

        return responseContent;
    }

    public static String get(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(buildUrl(url, params));
        CloseableHttpResponse response = null;
        String responseContent = "";
        Iterator var7 = headers.entrySet().iterator();

        while(var7.hasNext()) {
            Entry<String, String> e = (Entry)var7.next();
            request.addHeader((String)e.getKey(), (String)e.getValue());
        }

        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (ClientProtocolException var19) {
            var19.printStackTrace();
        } catch (IOException var20) {
            var20.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var18) {
                ;
            }

        }

        return responseContent;
    }

    private static String buildUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(url);
        if (params != null && !params.isEmpty()) {
            StringBuilder sbQuery = new StringBuilder();
            Iterator var4 = params.entrySet().iterator();

            while(var4.hasNext()) {
                Entry<String, String> query = (Entry)var4.next();
                if (sbQuery.length() > 0) {
                    sbQuery.append("&");
                }

                if (StringUtil.isEmpty((String)query.getKey()) && StringUtil.isNotEmpty((String)query.getValue())) {
                    sbQuery.append((String)query.getValue());
                }

                if (StringUtil.isNotEmpty((String)query.getKey())) {
                    sbQuery.append((String)query.getKey());
                    if (StringUtil.isNotEmpty((String)query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode((String)query.getValue(), "UTF-8"));
                    }
                }
            }

            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }
}

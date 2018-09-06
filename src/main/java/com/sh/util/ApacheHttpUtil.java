package com.sh.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApacheHttpUtil {

    private static CloseableHttpClient httpClient;

    static {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();
            httpClient = HttpClients.custom()
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param url 请求url
     * @param params 参数
     * @return 实体字符串
     */
    public static String post(String url, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        List<NameValuePair> nameValuePairs = params.entrySet().stream().map(e -> new BasicNameValuePair(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            response = httpClient.execute(httpPost);
            return getEntity(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(response);
        }
        return null;
    }

    /**
     *
     * @param url 请求url
     * @param json 请求json参数
     * @return 实体字符串
     */
    public static String postWithJson(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            response = httpClient.execute(httpPost);
            return getEntity(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(response);
        }
        return null;
    }

    /**
     *
     * @param url 请求url
     * @param file 文件
     * @param params 参数
     * @param filename 文件名
     * @return 实体字符串
     */
    public static String postWithMultipart(String url, File file, Map<String, String> params, String filename) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        params.forEach((k, v) -> {
            builder.addTextBody(k, v);
        });
        builder.addBinaryBody("file", file, ContentType.APPLICATION_ATOM_XML, filename);
        HttpEntity multipart = builder.build();
        httpPost.setEntity(multipart);
        try {
            response = httpClient.execute(httpPost);
            return getEntity(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(response);
        }
        return null;
    }

    /**
     *
     * @param url 请求url
     * @return 实体字符串
     */
    public static String get(String url) {
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(new HttpGet(url));
            return getEntity(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(response);
        }
        return null;
    }

    private static String getEntity(CloseableHttpResponse response) {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                String s = EntityUtils.toString(entity, Charset.forName("UTF-8"));
                EntityUtils.consume(entity);
                return s;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void close(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

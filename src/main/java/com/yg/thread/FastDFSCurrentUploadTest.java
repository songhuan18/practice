package com.yg.thread;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FastDFSCurrentUploadTest {

    private static CloseableHttpClient httpClient;
    private static HttpPost httpPost;
    private static HttpEntity reqEntity = null;

    // 线程数
    private static final int threadTotal = 1000;
    // 并发量
    private static final int currentNum = 500;

    static {
        httpClient = HttpClients.createDefault();
        File file = new File("/Users/songhuan/Desktop/springboot-prometheus.ppt");
        httpPost = new HttpPost("http://192.168.10.53:9999/file/upload");
        FileBody fileBody = new FileBody(file);
        try {
            reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addPart("file", fileBody)
                    .setCharset(CharsetUtils.get("UTF-8")).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(reqEntity);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(currentNum);
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i = 0; i < threadTotal; i++) {
            int finalI = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    upload(finalI);
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (httpClient != null) {
            try {
                httpClient.close();
                System.err.println("资源关闭成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void upload(int i) {
        System.out.println("发送请求的页面地址：" + httpPost.getRequestLine());
        //发起请求，并返回请求的响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            System.out.println("打印响应状态：" + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("这是第( " + i + " )次打印响应内容：" + EntityUtils.toString(entity, Charset.forName("UTF-8")));
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

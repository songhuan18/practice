package com.sh.yunpian;

import com.sh.util.ApacheHttpUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class MesSendTest {

    //查账户信息的http地址
    private static String URI_GET_USER_INFO =
            "https://sms.yunpian.com/v2/user/get.json";

    //智能匹配模板发送接口的http地址
    private static String URI_SEND_SMS =
            "https://sms.yunpian.com/v2/sms/single_send.json";

    //模板发送接口的http地址
    private static String URI_TPL_SEND_SMS =
            "https://sms.yunpian.com/v2/sms/tpl_single_send.json";

    //发送语音验证码接口的http地址
    private static String URI_SEND_VOICE =
            "https://voice.yunpian.com/v2/voice/send.json";

    //绑定主叫、被叫关系的接口http地址
    private static String URI_SEND_BIND =
            "https://call.yunpian.com/v2/call/bind.json";

    //解绑主叫、被叫关系的接口http地址
    private static String URI_SEND_UNBIND =
            "https://call.yunpian.com/v2/call/unbind.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";

    public static void main(String[] args) {
        String apiKey = "1ac913e340f99d64758a4c34db869c9a";
//        String apiKey = "a8209649053471054ec2d8a33bc187e0";
        // 发送的手机号
        String mobile = "18281606652";
        /** 查账户信息条用示例 */
        System.out.println(MesSendTest.getUserInfo(apiKey));
        String text = null;
        try {
            text = URLEncoder.encode("#value#", "UTF-8") + "=" +
                    URLEncoder.encode("设备1", "UTF-8") + "&" +
                    URLEncoder.encode("#device#", "UTF-8") + "=" + URLEncoder.encode("1234567", "UTF-8");
//            text = URLEncoder.encode("#code#", "UTF-8") + "=" +
//                    URLEncoder.encode("123456", "UTF-8");
            String result = sendSms(apiKey, text, mobile);
            System.out.println("返回结果：" + result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取账户信息
     * @param apikey
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public static String getUserInfo(String apikey) {
        Map< String, String > params = new HashMap<>();
        params.put("apikey", apikey);
        return ApacheHttpUtil.post(URI_GET_USER_INFO, params);
    }

    public static String sendSms(String apikey, String tplValue, String mobile) {
        Map <String, String> params = new HashMap <> ();
        params.put("apikey", apikey);
        params.put("tpl_value", tplValue);
        params.put("tpl_id", "2475088");
        params.put("mobile", mobile);
        return ApacheHttpUtil.post(URI_TPL_SEND_SMS, params);
    }
}

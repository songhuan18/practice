package com.sh.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;

import java.util.ArrayList;
import java.util.List;

public class GeTuiPushTest {
    private static String appId = "VKx8inHm8K9f5pYyPHOCJ3";
    private static String appKey = "FOFfL8Orco6icfetKL56i6";
    private static String masterSecret = "Xa38GLtg0n7z2mY7PzFCx6";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) {
        IGtPush push = new IGtPush(url, appKey, masterSecret);
        // 定义消息模板
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("给排水报警");
        template.setText("排水排不出来，请马上处理");
        template.setUrl("http://192.168.10.90:9000");

        List<String> appIds = new ArrayList<>();
        appIds.add(appId);

        // 定义消息对象，设置消息模板、发送目标App列表、是否支持离线发送、以及离线消息有效期
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}

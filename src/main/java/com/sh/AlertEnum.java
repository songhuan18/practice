package com.sh;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author sh
 * @date 2019-12-16 20:08
 */
@AllArgsConstructor
public enum AlertEnum {
    ALERT_HTTP("HTTP告警", "7af44d0758092e92c"),
    ALERT_WBESOCKET("websocket告警", "c26e2c901892b57e"),
    ALERT_SLOW_SQL("慢日志查询告警", "439d22e4825385f"),
    ;
    @Getter
    private String title;
    @Getter
    private String token;

    public static AlertEnum filter(String str) {
        AlertEnum[] alertEnums = AlertEnum.values();
        for (AlertEnum alertEnum : alertEnums) {
            if (str.contains(alertEnum.getTitle())) {
                return alertEnum;
            }
        }
        return null;
    }
}

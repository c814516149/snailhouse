package com.channing.snailhouse.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 系统工具类
 *
 * @author fengle
 *
 */
public class SysUtils {

    private static final Logger log = LoggerFactory.getLogger(SysUtils.class);

    /**
     * 校验空配置
     */
    public static void checkNullConfig(String configKey,String configValue) {
        if (StringUtils.isEmpty(configValue)) {
            log.error("未在配置表配置信息项:{}", configKey);
            throw new CheckedException("未在配置表配置信息项:" + configKey);
        }

    }

    /**
     * 版本号比较
     *
     * @param version1
     * @param version2
     * @return
     * @throws Exception
     */
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new CheckedException("版本比较异常");
        }
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);
        int diff = 0;
        while (idx < minLength && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0
                && (diff = versionArray1[idx].toUpperCase().compareTo(versionArray2[idx].toUpperCase())) == 0) {
            ++idx;
        }
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }

}

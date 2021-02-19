package com.channing.snailhouse.util;


import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;


public class SqlFileComparator implements Comparator<Resource> {

    private static final Logger log = LoggerFactory.getLogger(SqlFileComparator.class);

    @Override
    public int compare(Resource o1, Resource o2) {
        int result = 0;
        try {
            result = SysUtils.compareVersion(o1.getFilename(), o2.getFilename());
        } catch (Exception e) {
            log.error("版本号比较异常", e);
            throw new CheckedException("sql文件读取异常");
        }
        return result;
    }

}


package com.channing.snailhouse.config;

import com.channing.snailhouse.bean.ErrorCode;
import com.channing.snailhouse.util.CheckedException;
import com.channing.snailhouse.util.SqlFileComparator;
import com.channing.snailhouse.util.SysUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

@Configuration
public class SQLScriptConfig {

    private static final Logger log = LoggerFactory.getLogger(SQLScriptConfig.class);

    @Autowired
    @Qualifier("snailhouseSource")
    DataSource dataSource;

    @Value("${management.version}")
    private String version;

    @Value("${datasource.continue-on-error}")
    private boolean continueOnError;

    @Value("${datasource.init-sql-path}")
    private String sqlPath;

    @Autowired
    private ResourcePatternResolver resourceResolver;

    @Bean(name="initializingBean")
    @PostConstruct
    @Transactional
    public InitializingBean init() throws IOException {
        DataSourceInitializer dsi = new DataSourceInitializer();
        dsi.setDataSource(dataSource);
        String dbVersion = "";
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement();
             ResultSet tableResult = con.getMetaData().getTables(null, null, "sh_version", null);
             ResultSet result = tableResult.next()
                     ? statement.executeQuery("select version from sh_version order by id desc limit 0,1")
                     : null;
        ) {
            if (result != null && result.next()) {
                dbVersion = result.getString("version");
            }
        } catch (SQLException e) {
            log.error("查询版本异常", e);
        }
        if (StringUtils.isNotEmpty(dbVersion)
                && (StringUtils.equals(dbVersion, version) || StringUtils.equals(dbVersion + "-SNAPSHOT", version))) {
            return dsi;
        }
        // 版本回退提示
        if (SysUtils.compareVersion(dbVersion, version) > 0) {
            log.error("!!!请检查升级包版本,不支持版本回退。当前使用版本{},升级版本{}!!!", dbVersion, version);
            throw new CheckedException(ErrorCode.NOT_SUPPORTED_VERSION_ROLLBACK);
        }
        Resource[] allResources = resourceResolver.getResources(sqlPath);
        if (allResources == null || allResources.length == 0) {
            return dsi;
        }
        Arrays.sort(allResources, new SqlFileComparator());
        int versionSqlIndex = -1;
        if (StringUtils.isNotEmpty(dbVersion)) {
            for (int i = 0; i < allResources.length; i++) {
                if (SysUtils.compareVersion(allResources[i].getFilename(), "V" + dbVersion + ".sql") == 0) {
                    versionSqlIndex = i;
                    break;
                }
                if (SysUtils.compareVersion(allResources[i].getFilename(), "V" + dbVersion + ".sql") > 0) {
                    versionSqlIndex = i - 1;
                    break;
                }

            }
        }
        Resource[] resources = Arrays.copyOfRange(allResources, versionSqlIndex + 1, allResources.length);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(continueOnError, false, "utf-8",
                resources);
        dsi.setDatabasePopulator(databasePopulator);
        dsi.setEnabled(true);
        return dsi;
    }
}

package cn.joey.neo4j.core;

import cn.joey.neo4j.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.driver.v1.*;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author dunhanson
 * @version 1.0
 * @date 2019/7/5
 * @description
 */
@Slf4j
public class Store {
    private static volatile Store instance = null;
    private Driver driver = null;

    /**
     * 获取实例
     * @return
     */
    public static Store getInstance() {
        if(instance == null) {
            synchronized (Store.class) {
                instance = new Store();
            }
        }
        return instance;
    }

    /**
     * 获取驱动
     * @return
     */
    public Driver getDriver() {
        if(driver == null || !isValid()) {
            //配置文件名称
            String configFileName = CommonUtils.getConfigFileName();

            //数据库配置
            try(InputStream in = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(configFileName)) {

                //加载配置
                Properties properties = new Properties();
                properties.load(in);

                //URI
                List<URI> routingUris = new ArrayList<>();
                Arrays.asList(properties.getProperty("uri").split(",")).forEach(uri->{
                    routingUris.add(URI.create(uri));
                });

                //URI、用户名、密码
                String user = properties.getProperty("username");
                String password = properties.getProperty("password");

                //集群判断
                AuthToken authToken = AuthTokens.basic(user, password);
                Config config = Config.build().toConfig();
                if(routingUris.size() > 1) {
                    log.info("load driver by cluster mode");
                    driver = GraphDatabase.routingDriver(routingUris, authToken, config);
                } else {
                    log.info("load driver by single mode");
                    driver = GraphDatabase.driver(routingUris.get(0), authToken, config);
                }
            } catch (Exception e) {
                log.error("init fail");
                e.printStackTrace();
            }
        }
        return driver;
    }

    /**
     * 判断是否有效
     * @return
     */
    public boolean isValid() {
        try {
            driver.session().isOpen();
        } catch (Exception e) {
            log.info("driver is close");
            return false;
        }
        return true;
    }

}

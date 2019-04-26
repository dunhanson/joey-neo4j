package cn.joey.neo4j.utils;

import com.google.gson.Gson;
import org.neo4j.driver.v1.*;
import java.io.InputStream;
import java.net.URI;
import java.util.*;

/**
 * Neo4j简易工具类
 * @author dunhanson
 * @date 2019-04-23
 */
public class Neo4jUtils {
    private static Driver driver;

    /**
     * 初始化
     */
    static {
        //数据库配置
        try(InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("neo4j.properties")) {

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
                driver = GraphDatabase.routingDriver(routingUris, authToken, config);
            } else {
                driver = GraphDatabase.driver(routingUris.get(0), authToken, config);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询返回记录
     * @param cypher
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> run(String cypher, Class<T> clazz) {
        //返回结果
        List<T> list = new ArrayList<>();
        //Gson
        Gson gson = new Gson();

        //资源释放
        try(Session session = driver.session()) {
            StatementResult result = session.run(cypher);
            while (result.hasNext()) {
                //Map对象
                Map<String, Object> map = new HashMap<>();
                //获取字段和值
                Record record = result.next();
                if(record.keys().size() > 1) {
                    record.keys().forEach(key->{
                        map.put(key, record.get(key).asObject());
                    });
                } else {
                    Value value = record.get(0);
                    value.keys().forEach(key->{
                        map.put(key, value.get(key).asObject());
                    });
                }
                //追加记录
                list.add(gson.fromJson(gson.toJson(map), clazz));
            }
        }
        return list;
    }

    /**
     * 关闭资源
     */
    public static void close() {
        driver.close();
    }

}
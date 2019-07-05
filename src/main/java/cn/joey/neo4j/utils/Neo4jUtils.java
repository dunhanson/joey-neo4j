package cn.joey.neo4j.utils;

import cn.joey.neo4j.core.Store;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.neo4j.driver.v1.*;
import java.util.*;

/**
 * Neo4j简易工具类
 * @author dunhanson
 * @date 2019-04-23
 */
@Slf4j
public class Neo4jUtils {

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
        //Cypher检测
        if(StringUtils.isBlank(cypher)) {
            log.error("cypher is null");
            return null;
        }
        //Gson
        Gson gson = new Gson();
        //资源释放
        try(Session session = Store.getInstance().getDriver().session()) {
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
        } catch (Exception e) {
            log.error("run fail");
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询统计语句
     * @param cypher
     * @return
     */
    public static int count(String cypher) {
        //Cypher检测
        if(StringUtils.isBlank(cypher)) {
            log.error("cypher is null");
            return 0;
        }

        //资源释放
        try(Session session = Store.getInstance().getDriver().session()) {
            StatementResult result = session.run(cypher);
            while (result.hasNext()) {
                //Map对象
                Map<String, Object> map = new HashMap<>();
                //获取字段和值
                return result.next().get(0).asInt();
            }
        } catch (Exception e) {
            log.error("run fail");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询返回StatementResult
     * @param cypher
     * @return
     */
    public static StatementResult run(String cypher) {
        //Cypher检测
        if(StringUtils.isBlank(cypher)) {
            log.error("cypher is null");
            return null;
        }
        //资源释放
        try(Session session = Store.getInstance().getDriver().session()) {
            return session.run(cypher);
        } catch (Exception e) {
            log.error("run fail");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭
     */
    public static void close() {
        try {
            Store.getInstance().getDriver().close();
        } catch (Exception e) {
            log.error("close fail");
        }
    }
}

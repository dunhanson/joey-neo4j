package cn.joey.neo4j.test;

import cn.joey.neo4j.entity.Project;
import cn.joey.neo4j.utils.Neo4jUtils;
import org.junit.After;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;

public class StartTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        page();
    }

    @After
    public void after() {
        Neo4jUtils.close();
    }

    public void page() {
        String cypher = "MATCH(o:Organization)-[r]->(p:Project)\n" +
                "WHERE o.name = '通化县图书馆'\n" +
                "AND p.zhao_biao_page_time >= '2016-01-01' \n" +
                "AND p.zhao_biao_page_time <= '2019-05-14'\n" +
                "RETURN COUNT(*)\n";
        System.out.println(Neo4jUtils.count(cypher));
    }

    public void start() {
        String cypher = "MATCH (n:Project) RETURN n LIMIT 25";
        Neo4jUtils.run(cypher, Project.class).forEach(project -> {
            System.out.println(project);
        });
    }
}

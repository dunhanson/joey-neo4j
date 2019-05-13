package cn.joey.neo4j.test;

import cn.joey.neo4j.entity.Project;
import cn.joey.neo4j.utils.Neo4jUtils;
import org.neo4j.driver.v1.StatementResult;

public class StartTest {
    public static void main(String[] args) {
        String cypher = "MATCH (n:Project) RETURN n LIMIT 25";
        StatementResult result = Neo4jUtils.run(cypher);
        while (result.hasNext()) {
            System.out.println(result.next().asMap());
        }
    }

    public void start() {
        String cypher = "MATCH (n:Project) RETURN n LIMIT 25";
        Neo4jUtils.runAfterClose(null, Project.class).forEach(project -> {
            System.out.println(project);
        });
    }
}

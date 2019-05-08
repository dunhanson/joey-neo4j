package cn.joey.neo4j.test;

import cn.joey.neo4j.entity.Project;
import cn.joey.neo4j.utils.Neo4jUtils;

public class StartTest {
    public static void main(String[] args) {
        String cypher = "MATCH (n:Project) RETURN n LIMIT 25";
        Neo4jUtils.runAfterClose(cypher, Project.class).forEach(project -> {
            System.out.println(project);
        });
    }
}

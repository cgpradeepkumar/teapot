import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.Collections;

public class ElasticsearchDemo {

    public static void main(String[] args) {
        RestClient client = RestClient.builder(new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")).build();

        Response response = null;
        try {
            response = client.performRequest("GET", "/",
                    Collections.singletonMap("pretty", "true"));
            System.out.println(EntityUtils.toString(response.getEntity()));


            response = client.performRequest("GET", "/classroom", Collections.singletonMap("pretty", "true"));
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //index a document
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"kimchy\",\n" +
                        "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                        "    \"message\" : \"trying out Elasticsearch\"\n" +
                        "}", ContentType.APPLICATION_JSON);

        try {
            Response indexResponse = client.performRequest(
                    "PUT",
                    "/twitter/tweet/1",
                    Collections.<String, String>emptyMap(),
                    entity);

            System.out.println(indexResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

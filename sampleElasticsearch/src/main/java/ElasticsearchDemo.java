import org.apache.http.HttpHost;
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
    }
}

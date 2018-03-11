package in.library.services.mongodb.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "items")
public class Item implements Serializable {
    private static final long serialVersionUID = 7364288828510799356L;

    @Id
    private String id;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

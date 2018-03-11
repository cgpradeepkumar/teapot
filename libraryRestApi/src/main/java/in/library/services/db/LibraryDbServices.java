package in.library.services.db;

import in.library.services.mongodb.documents.Item;

import java.util.List;

public interface LibraryDbServices {

    List<Item> listAll();
}

package in.library.services.mongodb.repositories;

import in.library.services.mongodb.documents.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Item, String> {
}

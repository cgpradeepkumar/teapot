package in.library.services.mongodb;

import in.library.services.db.LibraryDbServices;
import in.library.services.mongodb.documents.Item;
import in.library.services.mongodb.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libraryDbServices")
public class LibraryMongoDbServices implements LibraryDbServices {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Item> listAll() {
        return libraryRepository.findAll();
    }
}
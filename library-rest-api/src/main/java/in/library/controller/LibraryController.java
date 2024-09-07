package in.library.controller;

import in.library.services.db.LibraryDbServices;
import in.library.services.mongodb.SequenceGeneratorService;
import in.library.services.mongodb.documents.Item;
import in.library.services.util.LibraryXlsFileParser;
import in.library.services.util.XlsToDocumentMapper;
import in.library.services.util.model.Data;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pradeepkumar on 10/2/18.
 */

@RestController
//@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    LibraryDbServices libraryDbServices;
    
    @Autowired
    LibraryXlsFileParser fileParser;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @ApiOperation(value = "List all items in the library")
    @GetMapping(value = "/library/items")
    public ResponseEntity<List<Item>> listAll() {

        List<Item> list = libraryDbServices.listAll();

        if(list.isEmpty()) {
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/library/item")
    public ResponseEntity<Item> save(@RequestBody Item item) {
        LOGGER.info("New Item {}", item);
        item.setId(sequenceGeneratorService.generateSequence(Item.SEQUENCE_NAME));
        libraryDbServices.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    
    @PostMapping(value = "/library/bulkSave")
    public ResponseEntity<Integer> bulkSave() {
    	List<Data> dataList = fileParser.parse();
    	List<Item> items = XlsToDocumentMapper.map(dataList, sequenceGeneratorService);
    	libraryDbServices.saveAll(items);
    	return new ResponseEntity<Integer>(items.size(), HttpStatus.OK);
    }
}

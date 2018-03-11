package in.library.controller;

import in.library.services.db.LibraryDbServices;
import in.library.services.mongodb.documents.Item;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pradeepkumar on 10/2/18.
 */

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryDbServices libraryDbServices;

    @ApiOperation(value = "List all items in the library")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> listAll() {

        List<Item> list = libraryDbServices.listAll();

        if(list.isEmpty()) {
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }
}

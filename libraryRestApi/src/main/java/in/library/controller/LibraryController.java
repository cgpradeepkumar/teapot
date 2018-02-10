package in.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pradeepkumar on 10/2/18.
 */

@RestController
@RequestMapping("/library")
public class LibraryController {

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public ResponseEntity<String> listAll() {
        return new ResponseEntity<String>("Testing...", HttpStatus.OK);
    }
}

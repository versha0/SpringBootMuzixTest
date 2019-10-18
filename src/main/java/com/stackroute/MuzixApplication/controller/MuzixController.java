package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixNotFoundException;
import com.stackroute.MuzixApplication.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PropertySource("classpath:application-mongerdb.properties")
@RestController
@RequestMapping(value = "/muzix")
public class MuzixController {
    public MuzixService muzixService;
    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("/")
    public ResponseEntity saveNewMuzix(@RequestBody Muzix muzix) {
        ResponseEntity responseEntity;
        System.out.println(muzix);
        try {
            muzixService.saveNewMuzix(muzix);
            responseEntity = new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/byname/{name}")
    public ResponseEntity trackByName(@PathVariable String name) {
        ResponseEntity responseEntity;
//        System.out.println(muzix);
        try {
//            List<Muzix>  m = muzixService.trackByName(name);
            responseEntity = new ResponseEntity<>(muzixService.trackByName(name), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }


    @GetMapping("/")
    public ResponseEntity getAllMuzix() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(muzixService.getAllMuzix(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteMuzixById(@PathVariable int id) {
        try {
            muzixService.deleteMuzixById(id);
            return ResponseEntity.ok("success!!!");
        } catch (MuzixNotFoundException e) {
            return new ResponseEntity<>("can't", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/")
    public String updateMuzixByComment(@RequestBody Muzix muzix) {
        try {
            muzixService.updateMuzix(muzix);
            return "Song Updated!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

package com.verhext.sharkmeapi.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verhext.sharkmeapi.models.BoxAssignModel;
import com.verhext.sharkmeapi.models.BoxModel;
import com.verhext.sharkmeapi.repos.BoxAssignRepository;
import com.verhext.sharkmeapi.repos.BoxRepository;

import org.apache.tinkerpop.gremlin.structure.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class BoxController {

    @Autowired
    private BoxRepository boxRepository;
    @Autowired
    private BoxAssignRepository boxAssignRepository;

    @RequestMapping(path = "/box", method = RequestMethod.POST)
    public ResponseEntity<String> home(Principal p, @RequestBody BoxModel box) throws JsonProcessingException {
        java.time.Instant timestamp = new java.util.Date().toInstant();
        UUID boxUUID = UUID.randomUUID();

        BoxModel newBox = new BoxModel(boxUUID, box.getName(), box.getDescription(), false, new ArrayList<String>(),
                timestamp, "#fff");
        boxRepository.save(newBox);
        boxAssignRepository.save(new BoxAssignModel(UUID.randomUUID(), boxUUID, UUID.fromString(p.getName())));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body(new ObjectMapper().writeValueAsString(newBox));
    }

    @RequestMapping(path = "/box", method = RequestMethod.GET)
    public ResponseEntity<String> home(Principal p) throws JsonProcessingException {
        java.time.Instant timestamp = new java.util.Date().toInstant();
        List<BoxModel> boxIds = new ArrayList<BoxModel>();
        List<BoxAssignModel> boxAssign = boxAssignRepository.findByUserId(UUID.fromString(p.getName()));
        for (int i = 0; i < boxAssign.size(); i++) {
            boxIds.add(boxRepository.findById(boxAssign.get(i).getBoxId()).get());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body(new ObjectMapper().writeValueAsString(boxIds));
    }

    @RequestMapping(path = "/box/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> home(Principal p, @PathVariable("id") String id) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        Optional<BoxAssignModel> boxAssign = boxAssignRepository.findByBoxIdAndUserId(UUID.fromString(id),
                UUID.fromString(p.getName()));
        if (!boxAssign.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("");
        }
        Optional<BoxModel> box = boxRepository.findById(boxAssign.get().getBoxId());
        if (box.isPresent())
            return ResponseEntity.ok().headers(headers).body(new ObjectMapper().writeValueAsString(box.get()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("");
    }

}
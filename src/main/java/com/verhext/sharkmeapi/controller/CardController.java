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
import com.verhext.sharkmeapi.models.CardModel;
import com.verhext.sharkmeapi.repos.BoxAssignRepository;
import com.verhext.sharkmeapi.repos.BoxRepository;
import com.verhext.sharkmeapi.repos.CardRepository;

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
public class CardController {

    @Autowired
    private BoxRepository boxRepository;
    @Autowired
    private BoxAssignRepository boxAssignRepository;
    @Autowired
    private CardRepository cardRepository;

    @RequestMapping(path = "/{boxuid}/card", method = RequestMethod.POST)
    public ResponseEntity<String> home(Principal p, @PathVariable String boxuid, @RequestBody CardModel card)
            throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        java.time.Instant timestamp = new java.util.Date().toInstant();
        UUID cardUUID = UUID.randomUUID();

        Optional<BoxAssignModel> boxAssign = boxAssignRepository.findByBoxIdAndUserId(UUID.fromString(boxuid),
                UUID.fromString(p.getName()));
        if (!boxAssign.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("");
        }

        CardModel newCard = new CardModel(cardUUID, card.getQuestion(), card.getAnswer(), card.getQuestionNote(),
                card.getAnswerNote(), card.getGrammar(), card.getDictionaryUrl(), UUID.fromString(boxuid));
        // ToDo Check hasPermission
        cardRepository.save(newCard);

        return ResponseEntity.ok().headers(headers).body(new ObjectMapper().writeValueAsString(newCard));
    }

    @RequestMapping(path = "/{boxuid}/card", method = RequestMethod.GET)
    public ResponseEntity<String> home(Principal p, @PathVariable String boxuid) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");

        Optional<BoxAssignModel> boxAssign = boxAssignRepository.findByBoxIdAndUserId(UUID.fromString(boxuid),
                UUID.fromString(p.getName()));
        if (!boxAssign.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("");
        }

        List<CardModel> cards = cardRepository.findAllByBox(UUID.fromString(boxuid));

        return ResponseEntity.ok().headers(headers).body(new ObjectMapper().writeValueAsString(cards));
    }
}
package com.verhext.sharkmeapi.controller;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verhext.sharkmeapi.ConfigBinder;
import com.verhext.sharkmeapi.KeycloakInstance;
import com.verhext.sharkmeapi.models.UserModel;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class MeController {

    @Autowired
    private ConfigBinder configBinder;

    @RequestMapping(path = "/me", method = RequestMethod.GET)
    public ResponseEntity home(Principal p) throws JsonProcessingException {

        Keycloak keycloakInstance = KeycloakInstance.getInstance(configBinder);
        UserRepresentation user = keycloakInstance.realm("sharkme").users().get(p.getName()).toRepresentation();

        UserModel userResponse = new UserModel(UUID.fromString(user.getId()), user.getEmail(), user.getUsername(),
                user.getFirstName(), user.getLastName(), false);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body(new ObjectMapper().writeValueAsString(userResponse));
    }

}
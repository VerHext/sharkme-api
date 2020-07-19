package com.verhext.sharkmeapi.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verhext.sharkmeapi.ConfigBinder;
import com.verhext.sharkmeapi.KeycloakInstance;
import com.verhext.sharkmeapi.models.EmailModel;
import com.verhext.sharkmeapi.models.NameModel;
import com.verhext.sharkmeapi.models.PasswordModel;
import com.verhext.sharkmeapi.models.UserModel;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groovy.transform.Undefined;

@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    private ConfigBinder configBinder;

    @RequestMapping(path = "/user/email", method = RequestMethod.POST)
    public ResponseEntity home(Principal p, @RequestBody EmailModel email) throws JsonProcessingException {

        Keycloak keycloakInstance = KeycloakInstance.getInstance(configBinder);
        UserResource userResource = keycloakInstance.realm("sharkme").users().get(p.getName());
        UserRepresentation user = userResource.toRepresentation();
        if (!isValidEmailAddress(email.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
        user.setEmail(email.getEmail());
        userResource.update(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body("");
    }

    @RequestMapping(path = "/user/password", method = RequestMethod.POST)
    public ResponseEntity home(Principal p, @RequestBody PasswordModel password) throws JsonProcessingException {

        Keycloak keycloakInstance = KeycloakInstance.getInstance(configBinder);
        UserResource userResource = keycloakInstance.realm("sharkme").users().get(p.getName());
        UserRepresentation user = userResource.toRepresentation();
        if (password.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password.getPassword());

        user.setCredentials(Arrays.asList(passwordCred));
        userResource.update(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body("");
    }

    @RequestMapping(path = "/user/name", method = RequestMethod.POST)
    public ResponseEntity home(Principal p, @RequestBody NameModel name) throws JsonProcessingException {

        Keycloak keycloakInstance = KeycloakInstance.getInstance(configBinder);
        UserResource userResource = keycloakInstance.realm("sharkme").users().get(p.getName());
        UserRepresentation user = userResource.toRepresentation();
        if (name.getFname() == null || name.getLname() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
        user.setFirstName(name.getFname());
        user.setLastName(name.getLname());
        userResource.update(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body("");
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
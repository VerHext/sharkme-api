package com.verhext.sharkmeapi;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakInstance {

    public static Keycloak getInstance(ConfigBinder config) {
        return KeycloakBuilder.builder().serverUrl(config.getServerUrl()).grantType(OAuth2Constants.PASSWORD)
                .realm(config.getRealmMaster()).clientId(config.getClientId()).username(config.getUsername())
                .password(config.getPassword())
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

    }

}
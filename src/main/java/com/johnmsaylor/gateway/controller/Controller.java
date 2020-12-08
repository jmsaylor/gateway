package com.johnmsaylor.gateway.controller;

import com.google.gson.Gson;
import com.johnmsaylor.gateway.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//TODO - logs and status codes in error handling

@RestController
public class Controller {
    @Autowired
    RestTemplate forward;

    @PostMapping
    public ResponseEntity<?> main(@RequestBody Payload payload) {
        switch (payload.getAction()) {
            case "TOP_HEADLINES": case "SEARCH_TERM":
                try {
                    return forward.postForEntity("http://localhost:3000", payload, Object.class, "");
                } catch (Exception e) {
                    return ResponseEntity.ok("Service Unreachable");
                }
            case "SIGN_IN":
                try {
                    return ResponseEntity.ok().header("Message", "hello").body(payload);
                } catch (Exception e) {
                    return ResponseEntity.ok("Service Unreachable");
            }
            case "SIGN_UP":
                try {
                    return ResponseEntity.ok("Yerp");
                } catch (Exception e) {
                    return ResponseEntity.ok("Service Unreachable");
                }
            default:
                return ResponseEntity.badRequest().build();
        }


    }


}

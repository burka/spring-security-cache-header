package com.example.cachingheaderbug;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/hello")
public class ServerWithEtag {

    @GetMapping("/mono")
    public Mono<ResponseEntity<String>> mono() {
        return Mono.just(ResponseEntity.ok()
                .header("Cache-Control", "max-age=120000, public")
                .header("ETag", "\"Hello\"").body("Hello String from Mono!"));
    }

    @GetMapping("/string")
    public ResponseEntity<String> string() {
        return ResponseEntity.ok()
                .header("Cache-Control", "max-age=120000, public")
                .header("ETag", "\"Hello\"").body("Hello String-World!");
    }
}

package com.example.filter;


import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import org.reactivestreams.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Base64;

@Filter(patterns = {"/v1/demo/**"})
public class FilterDemo implements HttpFilter {

    private final Logger logger = LoggerFactory.getLogger(FilterDemo.class);

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
        logger.info("Executing demo filter");

        final Base64.Decoder decoder = Base64.getUrlDecoder();
        final String token = request.getHeaders().getAuthorization().orElse(null);

        if (token == null) {
            return Mono.just(HttpResponse.status(HttpStatus.UNAUTHORIZED).body("Authorization is required"));
        }

        String[] chucks = token.split("\\.");

        if (chucks.length < 3) {
            return Mono.just(HttpResponse.status(HttpStatus.UNAUTHORIZED).body("The token is not valid"));
        }

        String payload = new String(decoder.decode(chucks[1]));




        return null;
    }
}

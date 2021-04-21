package com.switchfully.parksharkfisher.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class IndexController {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}

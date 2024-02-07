package hw.springWeb.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/chao")
    public  String chao(){
        return  "chao";
    }
}

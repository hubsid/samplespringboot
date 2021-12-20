package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class IPaddresscontroller {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public Map<String, String> ipaddress() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();

        map.put("ip", Inet4Address.getLocalHost().getHostAddress());
        map.put("hostname", Inet4Address.getLocalHost().getHostName());
        return map;
    }

    @GetMapping("/hello/in")
    public String helloin() {
        return "hello in ";
    }

    @GetMapping("/hello/out")
    public String helloout() {
        return "hello out";
    }

    @GetMapping("/call")
    public String callurl(@RequestParam String url) {
        return restTemplate.getForObject(url, String.class);
    }
}

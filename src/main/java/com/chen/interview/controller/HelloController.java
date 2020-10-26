package com.chen.interview.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/api/hello")
  public Map<String, Object> get() {
    Map<String, Object> map = new HashMap<>();
    map.put("interview", "I am code farmer.");
    return map;
  }
}

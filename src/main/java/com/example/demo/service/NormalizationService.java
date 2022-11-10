package com.example.demo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NormalizationService {

    public Map<String,String> normalize(Map<String, String> itemSpecifics){
        Map<String, String> normalizedSpecifics = new HashMap<>();
        itemSpecifics.entrySet().parallelStream().forEach(entry -> {
            normalizedSpecifics.put(StringUtils.capitalize(entry.getKey()), entry.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
         return normalizedSpecifics;
    }
}

package com.mc.aws.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class GatewayController {

    Logger log = Logger.getLogger("GatewayController");



    @GetMapping("/{appPathURI}/{entity}/{id}")
    public String getApp(@PathVariable("appPathURI") String appPathURI,
                         @PathVariable("entity") String entity, @PathVariable("id") String id ){
        log.info("Request for App : "+ appPathURI);
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder urlBuilder = new StringBuilder("http://");
        urlBuilder.append(appPathURI).append("/").append(entity).append("/").append(id);
        return restTemplate.getForObject(urlBuilder.toString(), String.class);
    }

}

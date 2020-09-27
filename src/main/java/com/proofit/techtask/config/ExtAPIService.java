package com.proofit.techtask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ExtAPIService {

    @Value("${tax.url}")
    String taxUrl;
    @Value("${prices.url}")
    String priceUrl;

    private RestTemplate restTemplate;

    @Autowired
    public ExtAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
    }

    public Double getBasePrice(String terminalName) {
        return restTemplate.getForObject(priceUrl + terminalName, Double.class);
    }

    public Double getVAT() {
        return restTemplate.getForObject(taxUrl, Double.class);
    }
}

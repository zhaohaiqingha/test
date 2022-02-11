package com.page.service;

import com.page.fallbackfeigin.FallbackFeigin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "market-service-product",fallback = FallbackFeigin.class)
public interface Feigin {


    @GetMapping("/product/port")
    String port();

}

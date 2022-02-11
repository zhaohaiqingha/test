package com.page.fallbackfeigin;

import com.page.service.Feigin;
import org.springframework.stereotype.Component;

@Component
public class FallbackFeigin implements Feigin {

    @Override
    public String port() {
        return "127.0.0.1";
    }
}

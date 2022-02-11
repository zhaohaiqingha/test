package com.page;

import com.common.pojo.Products;
import com.page.service.Feigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("page")
public class PageController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    Feigin feigin;

    @GetMapping("query")
    // 熔断
   /* @HystrixCommand(
            // threadPoolKey:线程池名称 要保持唯一 不唯一就共用所有的默认线程池是10
            // 如果定义了threadPoolKey 那么就是开启了舱壁模式 每个方法都有独立的线程池
//            threadPoolKey = "getProduct",
//            threadPoolProperties = {
//                    // 线程池大小
//                    @HystrixProperty(name = "coreSize",value = "1"),
//                    // 线程池等待队列大小
//                    @HystrixProperty(name = "maxQueueSize",value = "20")
//            },

            commandProperties = {
                    // 线程池超时时间 超时将会报错500 就会触发熔断
                   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                    //统计窗口时间的设置
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "8000"),
                    //统计窗口内的最小请求数
                     @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "1"),
                    //统计窗口内错误请求阈值的设置 50%
                     @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "10"),
                    //自我修复的活动窗口时间
                     @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
            },
            // 触发熔断超时 返回方法 触发熔断:方法执行错误了 那么可以给一些默认数据(兜底数据)
            fallbackMethod = "fallBack"

    )*/

    public Products getProduct(@RequestParam int id){
        String url = "http://market-service-product/producr/query?id="+id;
       return restTemplate.getForObject(url, Products.class);
    }
    int count = 0;
    /**
     * 触发熔断返回方法 参数和返回类型和父方法一致
     * @return
     */
    public Products fallBack(int id){
        return new Products();
    }


    @GetMapping("port")
    public String port(){
        String port = feigin.port();
        return port;
    }
}


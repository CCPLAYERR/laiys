package com.ddjb.laiys.controller;

import com.ddjb.laiys.pojo.Url;
import com.ddjb.laiys.service.DDJBService;
import com.pdd.pop.sdk.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@CrossOrigin
@RestController
public class DDJBController {

    @Autowired
    private DDJBService DDJBservice;


    @RequestMapping(value = "/Url/getSingleGoodsPromotionUrl", produces = "text/script;charset=UTF-8", method = RequestMethod.GET)
    public String getGoodsPromotionUrl(Long goodsId, String callback) {
//    public Url getGoodsPromotionUrl(){
        ArrayList<Long> longs = new ArrayList<>();
//        longs.add(93466463587L);
        longs.add(goodsId);
        Url url = DDJBservice.PddDdkGoodsPromotionUrlGenerateService(longs);
        System.out.println("拼多多拼单转换链接: " + url.getMobile_url());
        return callback + "(" + JsonUtil.transferToJson(url) + ")";
    }

    @RequestMapping(value = "/Url/helloWorld", produces = "text/script;charset=UTF-8", method = RequestMethod.GET)
    public String sayHello( String callback) {
        return callback + "(" + "hello" + ")";
    }
}

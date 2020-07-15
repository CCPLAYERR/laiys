package com.ddjb.laiys.controller;

import com.ddjb.laiys.pojo.Url;
import com.ddjb.laiys.service.DDJBService;
import com.pdd.pop.sdk.common.util.JsonUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//@CrossOrigin
@Controller
@RequestMapping("/ddjb")
public class DDJBController {

    @Autowired
    private DDJBService DDJBservice;


    @ResponseBody
    @GetMapping("/linkGenerate")
    public Url getGoodsPromotionUrl(@RequestParam("goodsId") String goodsId) {
        long goodsId1 = Long.parseLong(goodsId);
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(goodsId1);
        Url url = DDJBservice.PddDdkGoodsPromotionUrlGenerateService(longs);
        System.out.println("拼多多拼单转换链接: " + url.getMobile_url());
        return url;
    }

    @GetMapping("/getSingleGoodsPromotionUrl")
    public String getSingleGoodsPromotionUrl() {
        return "/ddjb/ddjb";
    }

}

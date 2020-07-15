package com.ddjb.laiys.controller;

import com.ddjb.laiys.pojo.Url;
import com.ddjb.laiys.service.DDJBService;
import com.pdd.pop.sdk.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@Controller
public class LoginController {

    @GetMapping("/index")
    public String index() {
        return "/index";
    }
}

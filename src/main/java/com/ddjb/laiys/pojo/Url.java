package com.ddjb.laiys.pojo;

import lombok.Data;

@Data
public class Url {
    /*{"{goods_promotion_url_generate_response":
        {"goods_promotion_url_list":
            [{"we_app_web_view_short_url":"https://p.pinduoduo.com/aOjQ2ezL",
            "we_app_web_view_url":"https://mobile.yangkeduo.com/duo_coupon_landing.html?goods_id=93466463587&pid=9465135_131476285&cpsSign=CC_200318_9465135_131476285_bb1b48cf4896cf11fb80146914842f00&duoduo_type=2",
            "mobile_short_url":"https://p.pinduoduo.com/OPaQ2zaG","
            mobile_url":"https://mobile.yangkeduo.com/app.html?use_reload=1&launch_url=duo_coupon_landing.html%3Fgoods_id%3D93466463587%26pid%3D9465135_131476285%26cpsSign%3DCC_200318_9465135_131476285_bb1b48cf4896cf11fb80146914842f00%26duoduo_type%3D2&campaign=ddjb&cid=launch_dl_force_",
            "short_url":"https://p.pinduoduo.com/aOjQ2ezL","url":"https://mobile.yangkeduo.com/duo_coupon_landing.html?goods_id=93466463587&pid=9465135_131476285&cpsSign=CC_200318_9465135_131476285_bb1b48cf4896cf11fb80146914842f00&duoduo_type=2"}
            ]
        }
    }*/

    private String we_app_web_view_short_url;  //唤起微信app推广短链接
    private String we_app_web_view_url; //唤起微信app推广链接
    private String mobile_url; //唤醒拼多多app的推广长链接
    private String mobile_short_url; //唤醒拼多多app的推广短链接
    private String short_url; //推广短链接

    private String PID;  //PID



}

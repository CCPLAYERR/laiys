package com.ddjb.laiys.service;

import com.ddjb.laiys.pojo.Url;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPromotionUrlGenerateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DDJBService {

    @Value("${laiys.clientId}")
    private String clientId; //754db0ff0ba546c3a2c18b44ae40b919
    @Value("${laiys.clientSecret}")
    private String clientSecret; //e8a74cfb64b57376af047f55c81a3c8f2148a514
    @Value("${laiys.duoId}")
    private String duoId; //9465135_131476285
    @Value("${laiys.duoIdLv1}")
    private String duoIdLv1; //131476285


    /**
     * 根据商品id生成推广链接
     *
     * @param list 商品id
     * @return
     */
    public Url PddDdkGoodsPromotionUrlGenerateService(List<Long> list) {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        String Pid = duoId + "_" + duoIdLv1;
        request.setPId(Pid);
        request.setGoodsIdList(list);
        //request.setZsDuoId(9869006L);
        /*request.setPId("9465135_131476285");
        List<Long> goodsIdList = new ArrayList<Long>();
        goodsIdList.add(20865448343L);
        goodsIdList.add(93466463587L);
        request.setGenerateShortUrl(false);
        request.setMultiGroup(false);
        request.setCustomParameters("str");
        request.setGenerateWeappWebview(false);
        request.setZsDuoId(0L);
        request.setGenerateWeApp(false);
        request.setGenerateWeiboappWebview(false);
        request.setGenerateMallCollectCoupon(false);
        request.setGenerateSchemaUrl(false);
        request.setGenerateQqApp(false);
        request.setSearchId("");*/

        //此行有实现签名 不需要再写签名了
        PddDdkGoodsPromotionUrlGenerateResponse response = null;
        try {
            //向拼多多服务器请求
            System.out.println("请求参数:   " + JsonUtil.transferToJson(request));
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }


        PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponse goodsPromotionUrlGenerateResponse = response.getGoodsPromotionUrlGenerateResponse();
        List<PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem> goodsPromotionUrlList = null;
        if (goodsPromotionUrlGenerateResponse == null) {
            //打印请求失败返回的异常信息
            System.out.println(JsonUtil.transferToJson(response));
        } else {
            goodsPromotionUrlList = goodsPromotionUrlGenerateResponse.getGoodsPromotionUrlList();
        }

        Url url = new Url();

        if (goodsPromotionUrlList != null) {
            //因为是单个查询 所以list里面应该只有一个元素
            for (int i = 0; i < goodsPromotionUrlList.size(); i++) {
                if (i > 0) {
                    break;
                }
                PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem urlListItem = goodsPromotionUrlList.get(i);
                //装填pojo
                url.setWe_app_web_view_short_url(urlListItem.getWeAppWebViewShortUrl());
                url.setWe_app_web_view_url(urlListItem.getWeAppWebViewUrl());
                url.setMobile_short_url(urlListItem.getMobileShortUrl());
                url.setMobile_url(urlListItem.getMobileUrl());
                url.setShort_url(urlListItem.getShortUrl());
                url.setPID(Pid);
            }
            System.out.println("返回的集合长度为>>>>" + goodsPromotionUrlList.size());
        }
        return url;
    }

}

package com.example.demo.controller;


import com.example.demo.bean.WebSiteBean;
import com.example.demo.service.SearchListService;
import com.example.demo.util.ResultObjectMsg;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Author: leesanghyuk
 * Date: 2019-05-21 09:51
 * Description:
 */

@RestController
@RequestMapping("/")
public class ESController {

    @Autowired
    private SearchListService searchListService;

    @ResponseBody
    @RequestMapping(value = "/test")
    public ResultObjectMsg<String> test() {
        ResultObjectMsg<String> resultObjectMsg = new ResultObjectMsg<>();
        //创建es客户端工具，验证环境
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        //验证环境,获取es状态
        String response = clientUtil.executeHttp("/kibana_sample_data_logs/_search", ClientInterface.HTTP_GET);
        System.out.println(response);
        resultObjectMsg.setObj(response);
        return resultObjectMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/searchList")
    public List<WebSiteBean> getWebSiteByPage(Integer from,Integer size) {

        return searchListService.getWebSiteByPage(from,size);
    }

}

package com.example.demo.service.impl;

import com.example.demo.bean.WebSiteBean;
import com.example.demo.mapper.esmapper.ESMapper;
import com.example.demo.service.SearchListService;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: leesanghyuk
 * Date: 2019-05-21 10:52
 * Description:
 */
@Service
public class SearchListServiceImpl implements SearchListService {
    @Override
    public List<WebSiteBean> getWebSiteByPage(Integer from,Integer size) {

        ClientInterface clientUtil = ESMapper.getListByPage();

        Map params = new HashMap();
        params.put("from",from);
        params.put("size",size);

        ESDatas<WebSiteBean> esDatas =clientUtil.searchList(
                "/kibana_sample_data_logs/_search",
                "searchList",params,
                WebSiteBean.class);
        //获取结果对象列表
        List<WebSiteBean> demos = esDatas.getDatas();

        //获取总记录数
        long totalSize = esDatas.getTotalSize();
        System.out.println(totalSize);
        return demos;
    }
}

package com.example.demo.mapper.esmapper;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;

/**
 * Author: leesanghyuk
 * Date: 2019-05-21 10:23
 * Description:
 */
public class ESMapper {
    public static ClientInterface getListByPage() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("dsl/searchList.xml");
        return clientUtil;
    }
}

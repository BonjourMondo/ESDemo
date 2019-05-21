package com.example.demo;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void getOrderDetailNum(){
        ClientInterface clientUtil =  ElasticSearchHelper.getConfigRestClientUtil("sql/searchList.xml");
        Map map = clientUtil.sqlObject(Map.class,"getListNum",null);
        System.out.println(map);

    }

}

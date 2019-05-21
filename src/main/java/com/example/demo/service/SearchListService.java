package com.example.demo.service;

import com.example.demo.bean.WebSiteBean;

import java.util.List;

/**
 * Author: leesanghyuk
 * Date: 2019-05-21 10:52
 * Description:
 */
public interface SearchListService {

    List<WebSiteBean>  getWebSiteByPage(Integer from,Integer size);
}

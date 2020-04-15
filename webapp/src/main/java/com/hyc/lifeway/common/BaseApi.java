package com.hyc.lifeway.common;

import com.hyc.cs.core.common.BaseController;
import com.hyc.cs.core.enums.HappyCountry;
import com.hyc.cs.core.enums.HappyLanguage;
import com.hyc.lifeway.module.user.model.User;

/**
 * @Author ：胡友成
 * @Date ：2020/4/13 12:16 下午
 * @Description：
 */
public class BaseApi extends BaseController {

    public User getAccessUser() {
        WebApiContext apiContext = WebApiContext.get();
        if (apiContext != null) {
            return apiContext.getAccessUser();
        } else {
            return null;
        }
    }

    @Override
    public HappyLanguage getApiLanguage() {
        HappyLanguage language = super.getApiLanguage();
        return language != null ? language : HappyLanguage.zh_CN;
    }

    @Override
    public HappyCountry getApiCountry() {
        HappyCountry country = super.getApiCountry();
        return country != null ? country : HappyCountry.CN;
    }
}

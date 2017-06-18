package com.kmdms.service;

/**
 * Created by JAMES on 2017/6/18.
 */
public interface AdminService {
    /**
     * 检查登陆账号
     * @param adminName
     * @param password
     */
    void loginCheck(String adminName, String password) throws Exception;
}

package com.kmdms.service.impl;

import com.kmdms.common.exception.KMDMSException;
import com.kmdms.service.AdminService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JAMES on 2017/6/18.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public void loginCheck(String adminName, String password) throws Exception {
        if(adminName != null && !"".equals(adminName)){
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(this.getClass().getClassLoader().getResourceAsStream("adminInfo.xml"));
            //得到根节点
            Element root = document.getRootElement();
            //得到admins
            List<Element> elements = root.element("admins").elements();
            //用于存储匹配的账号
            Element currEle = null;
            for(Element element : elements){
                String name = element.elementText("name");
                if(name != null && name.equals(adminName)){
                    currEle = element;
                    break;
                }
            }
            //无匹配时，抛出异常
            if(currEle == null){
                KMDMSException kmdmsException = new KMDMSException("没有该账号！", "admin/admin_login");
                kmdmsException.getModel().put("adminName", adminName);
                kmdmsException.getModel().put("password", password);
                throw kmdmsException;
            }
            //得到匹配的账号的密码
            String pwd = currEle.elementText("password");
            //密码不匹配时，抛出异常
            if(pwd != null && !pwd.equals(password)){
                KMDMSException kmdmsException = new KMDMSException("账号或密码错误", "admin/admin_login");
                kmdmsException.getModel().put("adminName", adminName);
                kmdmsException.getModel().put("password", password);
                throw kmdmsException;
            }
            //执行到这里说明账号密码正确
        } else {
            KMDMSException kmdmsException = new KMDMSException("账号不能为空！", "admin/admin_login");
            kmdmsException.getModel().put("adminName", adminName);
            kmdmsException.getModel().put("password", password);
            throw kmdmsException;
        }
    }
}

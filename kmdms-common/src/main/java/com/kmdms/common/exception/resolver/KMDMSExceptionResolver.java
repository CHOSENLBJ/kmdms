package com.kmdms.common.exception.resolver;

import com.kmdms.common.exception.KMDMSException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by JAMES on 2017/5/22.
 */
public class KMDMSExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) {
        //打印错误信息
        exception.printStackTrace();

        ModelAndView modelAndView = null;
        KMDMSException kmdmsException = null;
        //判断是否为KMDMSException异常
        if(exception instanceof KMDMSException){
            kmdmsException = (KMDMSException) exception;
            //实例模型视图
            modelAndView = new ModelAndView();
            //得到model
            Map<String, Object> model = kmdmsException.getModel();
            //得到view
            String view = kmdmsException.getView();
            modelAndView.addAllObjects(model);
            modelAndView.addObject("msg", kmdmsException.getMessage());
            modelAndView.setViewName(view);
        }
        return modelAndView;
    }
}

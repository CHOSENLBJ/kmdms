package com.kmdms.common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JAMES on 2017/5/22.
 */
public class KMDMSException extends Exception {

    private Map<String, Object> model;
    private String view;

    public KMDMSException() {
        super();
    }

    public KMDMSException(String message, String view) {
        super(message);
        model = new HashMap<String, Object>();
        this.view = view;
    }

    public Map<String, Object> getModel() {
        return model;
    }
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }
}

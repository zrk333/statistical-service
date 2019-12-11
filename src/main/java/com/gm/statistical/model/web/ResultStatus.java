package com.gm.statistical.model.web;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一封装返回值对象
 * @Description: 返回对象包装类
 * @Author: zrk
 * @Date: 2019/8/20
 */
@Data
public class ResultStatus implements Serializable{

    private static final long serialVersionUID = 1169288101683556205L;

    /**状态码*/
    private Integer code;

    /**状态码*/
    private Integer status;

    /**信息*/
    private String msg = "";

    /**数据*/
    private Object data;

    public enum GlobalStatus {
        /**成功*/
        SUCCESS(0)
        ;

        public Integer value;

        GlobalStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public ResultStatus(){
        this.status = GlobalStatus.SUCCESS.getValue();
        this.code = GlobalStatus.SUCCESS.getValue();
        this.msg = map.get(this.status);
        this.data = null;
    }

    public ResultStatus(GlobalStatus status) {
        this.status = status.getValue();
        this.code = status.getValue();
        this.msg = map.get(status.getValue());
        this.data = null;
    }

    public ResultStatus(GlobalStatus status, String msg) {
        this.status = status.getValue();
        this.code = status.getValue();
        this.msg = msg;
        this.data = null;
    }

    public static final Map<Integer, String> map = new HashMap<Integer, String>(){
        {
            put(GlobalStatus.SUCCESS.getValue(),"成功");
        }
    };

}

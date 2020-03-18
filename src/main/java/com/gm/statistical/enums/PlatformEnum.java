package com.gm.statistical.enums;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/3/18
 */
public enum PlatformEnum {
    /**安卓*/
    ANDROID(0,"android"),
    /**ios*/
    IOS(1,"ios"),
    /**web*/
    WEB(2,"web"),
    /**小程序*/
    SP(3,"smallProgram")
    ;

    Integer id;
    String name;

    PlatformEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static String getNameById(Integer id) {
        if (id == null) {
            return "";
        }
        for (PlatformEnum subjectEnum : values()) {
            if(subjectEnum.getId().equals(id)){
                return subjectEnum.getName();
            }
        }
        return "";
    }
}

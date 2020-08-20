package com.hb.pro.bean;

/**
 * @author hb
 * @create 2020-07-07 9:54
 */
public class ModuleVO extends Module{

    private Integer keyindex;
    private String keyCode;
    private Integer num;

    public Integer getKeyindex() {
        return keyindex;
    }

    public void setKeyindex(Integer keyindex) {
        this.keyindex = keyindex;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

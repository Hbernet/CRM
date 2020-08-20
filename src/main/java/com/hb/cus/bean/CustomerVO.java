package com.hb.cus.bean;

/**
 * @author hb
 * @create 2020-07-02 14:38
 */
public class CustomerVO extends Customer{

    private Integer keyindex;
    private String  keyCode;
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

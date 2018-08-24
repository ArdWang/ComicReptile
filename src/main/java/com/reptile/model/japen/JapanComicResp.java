package com.reptile.model.japen;


import java.util.List;

public class JapanComicResp {
    //状态编码
    private String code;
    //消息
    private String message;
    //更多
    private String more;
    //动画列表
    private List<JapanComic> japanComicList;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public List<JapanComic> getJapanComicList() {
        return japanComicList;
    }

    public void setJapanComicList(List<JapanComic> japanComicList) {
        this.japanComicList = japanComicList;
    }


}

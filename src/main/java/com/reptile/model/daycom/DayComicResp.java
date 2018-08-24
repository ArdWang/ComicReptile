package com.reptile.model.daycom;

public class DayComicResp {
    //状态编码
    private String code;
    //消息
    private String message;
    //更多
    private String more;
    //每日的推荐
    private DayComic dayComic;

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

    public DayComic getDayComic() {
        return dayComic;
    }

    public void setDayComic(DayComic dayComic) {
        this.dayComic = dayComic;
    }

}

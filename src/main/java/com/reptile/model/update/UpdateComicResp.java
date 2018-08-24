package com.reptile.model.update;

import java.util.List;

public class UpdateComicResp {

    //状态编码
    private String code;

    //消息
    private String message;

    //更多
    private String more;

    //更新的集合
    private List<UpdateComic> updateComicList;

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

    public List<UpdateComic> getUpdateComicList() {
        return updateComicList;
    }

    public void setUpdateComicList(List<UpdateComic> updateComicList) {
        this.updateComicList = updateComicList;
    }


}

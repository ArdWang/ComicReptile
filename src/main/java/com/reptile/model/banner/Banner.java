package com.reptile.model.banner;

public class Banner {
    //标题
    protected String title;

    //url的路径
    private String herf;

    //封面图片
    private String cover;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }


    public String getHerf() {
        return herf;
    }

    public void setHerf(String herf) {
        this.herf = herf;
    }

}

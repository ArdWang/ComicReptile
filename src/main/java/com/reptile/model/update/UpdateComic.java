package com.reptile.model.update;

/**
 * 每日更新
 */
public class UpdateComic {
    //封面图片
    private String cover;
    //封面标题
    private String title;
    //作者
    private String author;
    //点赞数
    private String star;
    //更新集数
    private String collect;
    //点击链接
    private String href;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }



}

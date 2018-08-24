package com.reptile.utils;

import com.reptile.model.banner.Banner;
import com.reptile.model.banner.BannerResp;
import com.reptile.model.daycom.DayComic;
import com.reptile.model.daycom.DayComicResp;
import com.reptile.model.japen.JapanComic;
import com.reptile.model.japen.JapanComicResp;
import com.reptile.model.main.Comic;
import com.reptile.model.main.ComicResp;
import com.reptile.model.newcomic.NewComic;
import com.reptile.model.newcomic.NewComicResp;
import com.reptile.model.update.UpdateComic;
import com.reptile.model.update.UpdateComicResp;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class DataHelpUtils {

    /**
     * 获取腾讯漫画的Banner数据
     */
    public static List<Banner> TransToBanner(Document doc){
        List<Banner> dataList = new ArrayList<>();
        Element detail = doc.getElementsByAttributeValue("class","banner-list").get(0);
        List<Element> infos = detail.getElementsByTag("a");
        for(int i=0;i<infos.size();i++){
            Banner banner = new Banner();
            banner.setTitle(infos.get(i).select("a").attr("title"));
            banner.setCover(infos.get(i).select("img").attr("src"));
            banner.setHerf(infos.get(i).select("a").attr("href"));
            dataList.add(banner);
        }
        return dataList;
    }


    /**
     * 获取无良推荐
     */
    public static ComicResp TransToRecommendComic(Document doc){
        ComicResp resp = new ComicResp();
        List<Comic> dataList = new ArrayList<>();
        //获取得到更多
        Element more = doc.getElementsByAttributeValue("class","recommend").get(0);
        resp.setMore(more.select("a").attr("href"));
        Element detail = doc.getElementsByAttributeValue("class","comic-list col-3 no-tag recommend-list").get(0);
        List<Element> recommendList = detail.getElementsByTag("li");

        for(int i=0;i<recommendList.size();i++){
            Comic comic = new Comic();
            comic.setHerf(recommendList.get(i).select("a").attr("href"));
            comic.setCover(recommendList.get(i).select("img").attr("src"));
            Element ElementDescribe = recommendList.get(i).getElementsByAttributeValue("class","comic-content").get(0);
            comic.setTitle(ElementDescribe.select("strong").text());
            comic.setDescribe(ElementDescribe.select("small").text());
            dataList.add(comic);
        }
        resp.setComicList(dataList);
        return resp;
    }

    /**
     * 获取每日一推
     */
    public static DayComicResp TransToDayRecomComic(Document doc){
        DayComicResp resp = new DayComicResp();
        DayComic dayComic = new DayComic();

        //获取得到更多
        Element more = doc.getElementsByAttributeValue("class","light-comic").get(0);
        resp.setMore(more.select("a").attr("href"));

        Element detail = doc.getElementsByAttributeValue("class","light-comic-recommend").get(0);

        dayComic.setHref(detail.select("a").attr("href"));
        Element elementImg = detail.getElementsByAttributeValue("class","link comic-cover").get(0);
        dayComic.setCover(elementImg.select("img").attr("src"));
        Element elementDescribe = detail.getElementsByAttributeValue("class","link comic-title").get(0);
        dayComic.setTitle(elementDescribe.select("span").text());
        dayComic.setAuthor(elementDescribe.select("small").text());
        resp.setDayComic(dayComic);

        return resp;
    }

    /**
     * 获取每日更新
     */
    public static UpdateComicResp TransToDayUpdate(Document doc) {
        UpdateComicResp resp = new UpdateComicResp();
        List<UpdateComic> updateComicList = new ArrayList<>();

        //获取得到更多
        Element all = doc.getElementsByAttributeValue("class", "update-today").get(0);
        resp.setMore(all.select("a").attr("href"));

        Element updateArea = all.getElementsByAttributeValue("class","update-area").get(0);
        Element ul = updateArea.getElementsByAttributeValue("class", "comic-list col-1").get(0);
        List<Element> li = ul.getElementsByClass("comic-item");

        for (int i = 0; i < li.size(); i++) {
            UpdateComic updateComic = new UpdateComic();
            updateComic.setHref(li.get(i).select("a").attr("href"));
            //获取封面图片
            Element elementImg = li.get(i).getElementsByAttributeValue("class", "comic-cover").get(0);
            updateComic.setCover(elementImg.select("img").attr("src"));

            Element elementContent = li.get(i).getElementsByAttributeValue("class", "comic-content").get(0);

            updateComic.setTitle(elementContent.select("strong").text());
            Element elementAuthor = elementContent.getElementsByAttributeValue("class", "comic-artist").get(0);
            updateComic.setAuthor(elementAuthor.select("small").text());

            Element collectLatest = elementContent.getElementsByAttributeValue("class", "comic-latest").get(0);
            updateComic.setCollect(collectLatest.select("small").text());

            Element rankBar = li.get(i).getElementsByAttributeValue("class", "rank-bar").get(0);
            updateComic.setStar(rankBar.getElementsByAttributeValue("class","rank-score").text());

            updateComicList.add(updateComic);
        }
        resp.setUpdateComicList(updateComicList);
        return resp;
    }

    /**
     * 获取上线新作品
     */
    public static NewComicResp TransToNewComic(Document doc){
        NewComicResp resp = new NewComicResp();
        List<NewComic> dataList = new ArrayList<>();

        //获取得到更多
        Element all = doc.getElementsByAttributeValue("class", "new-comic").get(0);
        resp.setMore(all.select("a").attr("href"));

        Element ul = all.getElementsByAttributeValue("class","comic-list col-3 no-desc").get(0);
        List<Element> li = ul.getElementsByClass("comic-item");

        for(int i=0;i<li.size();i++){
            NewComic newComic = new NewComic();
            newComic.setHref(li.get(i).select("a").attr("href"));

            //获取封面图片
            Element img = li.get(i).getElementsByAttributeValue("class", "comic-cover").get(0);
            newComic.setCover(img.select("img").attr("src"));

            //获取标题
            Element content = li.get(i).getElementsByAttributeValue("class","comic-content").get(0);
            newComic.setTitle(content.getElementsByAttributeValue("class","comic-title").text());
            newComic.setCategory(content.getElementsByAttributeValue("class","comic-tag").text());

            //添加到List中去
            dataList.add(newComic);
        }
        resp.setNewComicList(dataList);
        return resp;

    }

    /**
     * 获取日漫推荐作品
     */
    public static JapanComicResp TransToJapanComic(Document doc){
        JapanComicResp resp = new JapanComicResp();
        List<JapanComic> dataList = new ArrayList<>();

        //获取得到更多
        Element all = doc.getElementsByAttributeValue("class", "japan-comic").get(0);
        resp.setMore(all.select("a").attr("href"));

        Element ul = all.getElementsByAttributeValue("class","comic-list col-3 no-desc").get(0);
        List<Element> li = ul.getElementsByClass("comic-item");

        for(int i=0;i<li.size();i++){
            JapanComic japanComic = new JapanComic();
            japanComic.setHref(li.get(i).select("a").attr("href"));

            //获取封面图片
            Element img = li.get(i).getElementsByAttributeValue("class", "comic-cover").get(0);
            japanComic.setCover(img.select("img").attr("src"));

            //获取标题
            Element content = li.get(i).getElementsByAttributeValue("class","comic-content").get(0);
            japanComic.setTitle(content.getElementsByAttributeValue("class","comic-title").text());
            japanComic.setCategory(content.getElementsByAttributeValue("class","comic-tag").text());

            //添加到List中去
            dataList.add(japanComic);
        }

        resp.setJapanComicList(dataList);

        return resp;

    }


}

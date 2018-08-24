package com.reptile.controller;

import com.reptile.model.BaseResp;
import com.reptile.model.banner.Banner;
import com.reptile.model.banner.BannerResp;
import com.reptile.model.daycom.DayComicResp;
import com.reptile.model.japen.JapanComicResp;
import com.reptile.model.main.ComicResp;
import com.reptile.model.newcomic.NewComicResp;
import com.reptile.model.update.UpdateComicResp;
import com.reptile.utils.DataHelpUtils;
import com.reptile.utils.StatusCode;
import com.reptile.utils.UrlUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/comic"})
public class ReptitleController extends BaseController{

    /**
     * 获取Banner栏目
     */
    @RequestMapping(value = {"/getBanner"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BannerResp getBanner(){
        BannerResp resp = new BannerResp();
        try{
            Document doc = Jsoup.connect(UrlUtils.tencentUrl).get();
            List<Banner> dataList = DataHelpUtils.TransToBanner(doc);
            if(dataList==null||dataList.size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("数据获取错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setBannerList(dataList);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    /**
     * 获取无良推荐
     */
    @RequestMapping(value = {"/getRecommend"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ComicResp getRecommend(){
        ComicResp resp = new ComicResp();
        try{
            Document recommend = Jsoup.connect(UrlUtils.tencentUrl).get();
            resp = DataHelpUtils.TransToRecommendComic(recommend);

            if(resp==null||resp.getComicList().size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取数据错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 获取每日一推
     */
    @RequestMapping(value = {"/getDayRecommend"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public DayComicResp getDayRecomme(){
        DayComicResp resp = new DayComicResp();
        try{
            Document dayrecommend = Jsoup.connect(UrlUtils.tencentUrl).get();
            resp = DataHelpUtils.TransToDayRecomComic(dayrecommend);

            if(resp==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取数据错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 获取每日更新
     */
    @RequestMapping(value = {"/getDayUpdate"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public UpdateComicResp getDayUpdate(){
        UpdateComicResp resp = new UpdateComicResp();
        try{
            Document dayupdate = Jsoup.connect(UrlUtils.tencentUrl).get();
            resp = DataHelpUtils.TransToDayUpdate(dayupdate);

            if(resp==null||resp.getUpdateComicList().size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取数据错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 获取上线新作品
     */
    @RequestMapping(value = {"/getNewComic"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public NewComicResp getNewComic(){
        NewComicResp resp = new NewComicResp();
        try{
            Document newDoc = Jsoup.connect(UrlUtils.tencentUrl).get();
            resp = DataHelpUtils.TransToNewComic(newDoc);

            if(resp==null||resp.getNewComicList().size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取数据错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 获取日漫作品
     */
    @RequestMapping(value = {"/getJapanComic"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public JapanComicResp getJapanComic(){
        JapanComicResp resp = new JapanComicResp();
        try{
            Document japanDoc = Jsoup.connect(UrlUtils.tencentUrl).get();
            resp = DataHelpUtils.TransToJapanComic(japanDoc);

            if(resp==null||resp.getJapanComicList().size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取数据错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            return resp;


        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }



}

package com.android.benben.myretrofit.model;

import java.util.List;

/**
 * Time      2017/3/13 16:57 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class MoveModel {
    private String title;
    private String tag;
    private String act;
    private String year;
    private int rating;
    private String area;
    private String dir;
    private String desc;
    private String cover;
    private String vdo_status;
    /**
     * tudou : http://www.tudou.com/albumplay/KE2zJh9AWII/2Otbf25W5h4.html?tpa=dW5pb25faWQ9MTAyMjEzXzEwMDAwMV8wMV8wMQ
     * youku : http://v.youku.com/v_show/id_XODMzOTcyNjg0.html?tpa=dW5pb25faWQ9MTAyMjEzXzEwMDAwN18wMV8wMQ
     * qq : http://v.qq.com/cover/r/relqwr6c0in3s5b.html?ptag=360kan.movie
     * pptv : http://v.pptv.com/show/lyibYF3iclVZP2dHg.html
     * imgo : http://www.mgtv.com/b/102839/1103088.html?cxid=90f0zbamf
     */

    private PlaylinksBean playlinks;
    /**
     * cover : http://p4.qhimg.com/t01b2c8f106c3a06fc8.jpg
     * detail_url : http://www.360kan.com/m/gKPkYUH6SHnAUR.html
     * title : 人再囧途之泰囧
     */

    private List<VideoRecBean> video_rec;
    /**
     * name : 黄渤
     * url : http://baike.so.com/doc/4300540-4504310.html
     * image : http://p5.qhmsg.com/dmsmty/120_110_100/t0175e2bf9bc9d6559e.jpg
     */

    private List<ActSBean> act_s;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVdo_status() {
        return vdo_status;
    }

    public void setVdo_status(String vdo_status) {
        this.vdo_status = vdo_status;
    }

    public PlaylinksBean getPlaylinks() {
        return playlinks;
    }

    public void setPlaylinks(PlaylinksBean playlinks) {
        this.playlinks = playlinks;
    }

    public List<VideoRecBean> getVideo_rec() {
        return video_rec;
    }

    public void setVideo_rec(List<VideoRecBean> video_rec) {
        this.video_rec = video_rec;
    }

    public List<ActSBean> getAct_s() {
        return act_s;
    }

    public void setAct_s(List<ActSBean> act_s) {
        this.act_s = act_s;
    }

    public static class PlaylinksBean {
        private String tudou;
        private String youku;
        private String qq;
        private String pptv;
        private String imgo;

        public String getTudou() {
            return tudou;
        }

        public void setTudou(String tudou) {
            this.tudou = tudou;
        }

        public String getYouku() {
            return youku;
        }

        public void setYouku(String youku) {
            this.youku = youku;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getPptv() {
            return pptv;
        }

        public void setPptv(String pptv) {
            this.pptv = pptv;
        }

        public String getImgo() {
            return imgo;
        }

        public void setImgo(String imgo) {
            this.imgo = imgo;
        }
    }

    public static class VideoRecBean {
        private String cover;
        private String detail_url;
        private String title;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class ActSBean {
        private String name;
        private String url;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}


package com.maxin.liang.bean.share.InfoBean;

import java.util.List;

/**
 * Created by shkstart on 2017/7/11.
 */

public class VideoInfoBean {

    /**
     * author_uid : 20356190
     * hot : {"info":{"count":0,"np":null},"list":[]}
     * normal : {"info":{"count":7,"np":null},"list":[{"status":2,"ctime":"2017-07-11T08:49:34","hate_count":0,"data_id":25646220,"content":"哈哈哈，什么电影啊，我想听原版","like_count":1,"user":{"username":"青草味的小胖次丶","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/06/21/594a7558596e1_mini.jpg","weibo_uid":"","personal_page":"http://user.qzone.qq.com/433663FA88752D780F855ED599290A7F","room_name":"","room_role":"","total_cmt_like_count":"27279","is_vip":false,"room_url":"","qzone_uid":"433663FA88752D780F855ED599290A7F","sex":"f","id":20905849,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84535547},{"status":2,"ctime":"2017-07-11T08:48:41","hate_count":0,"data_id":25646220,"content":"妹子从裤裆掏出那根电话，亮瞎你们的眼","like_count":0,"user":{"username":"莫可言","qq_uid":"","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/D5C5D84ECBB03E129C60F59E52DD246C/100","weibo_uid":"","personal_page":"http://user.qzone.qq.com/D5C5D84ECBB03E129C60F59E52DD246C","room_name":"","room_role":"","total_cmt_like_count":"357","is_vip":false,"room_url":"","qzone_uid":"D5C5D84ECBB03E129C60F59E52DD246C","sex":"f","id":20006754,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84535507},{"status":2,"ctime":"2017-07-11T08:47:01","hate_count":0,"data_id":25646220,"content":"谁赞我","like_count":0,"user":{"username":"掏粪专业户","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/10/08/57f9131b5e6b4_mini.jpg","weibo_uid":"","personal_page":"http://user.qzone.qq.com/7F4DCBE3034E45703FCD46E89A69A4FD","room_name":"","room_role":"","total_cmt_like_count":"730","is_vip":false,"room_url":"","qzone_uid":"7F4DCBE3034E45703FCD46E89A69A4FD","sex":"f","id":16645759,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84535397},{"status":0,"ctime":"2017-07-11T08:38:00","hate_count":0,"data_id":25646220,"content":"老梗","like_count":0,"user":{"username":"乄小轩 [为爱逆战]","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/06/09/593a62f02d3c7_mini.jpg","weibo_uid":"","personal_page":"","room_name":"为爱逆战","room_role":"帮主","total_cmt_like_count":"18715","is_vip":true,"room_url":"","qzone_uid":"","sex":"m","id":16243410,"room_icon":"http://wimg.spriteapp.cn/ugc/2016/1101/gang_level_7.png"},"vote":[],"precmts":[],"type":"text","id":84534887},{"status":0,"ctime":"2017-07-06T15:25:36","hate_count":0,"data_id":25646220,"content":"模仿岛国的","like_count":0,"user":{"username":"这名字还不能通过","qq_uid":"","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/F2716D4A2B80718DBA384F724D57A825/100","weibo_uid":"","personal_page":"http://user.qzone.qq.com/F2716D4A2B80718DBA384F724D57A825","room_name":"","room_role":"","total_cmt_like_count":"79","is_vip":false,"room_url":"","qzone_uid":"F2716D4A2B80718DBA384F724D57A825","sex":"m","id":9250941,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84183676},{"status":0,"ctime":"2017-07-06T14:17:52","hate_count":0,"data_id":25646220,"content":"这是什么电影啊","like_count":0,"user":{"username":"用户Z5bNbd","qq_uid":"","profile_image":"http://wx.qlogo.cn/mmopen/PiajxSqBRaEJMej93C3mC9ZouX6v4ufsNql91P5XVLVkMBaYSDyjS1C9PUS5y0ztsfr5yyHsabiaHp8Oibrm4nvWw/0","weibo_uid":"","personal_page":"","room_name":"","room_role":"","total_cmt_like_count":"0","is_vip":false,"room_url":"","qzone_uid":"","sex":"f","id":21030824,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84179902},{"status":0,"ctime":"2017-07-06T14:14:54","hate_count":0,"data_id":25646220,"content":"沙发","like_count":0,"user":{"username":"紅花會","qq_uid":"","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/C914BE3B9A69F816AAE324ED7205939F/100","weibo_uid":"","personal_page":"http://user.qzone.qq.com/C914BE3B9A69F816AAE324ED7205939F","room_name":"","room_role":"","total_cmt_like_count":"2","is_vip":false,"room_url":"","qzone_uid":"C914BE3B9A69F816AAE324ED7205939F","sex":"m","id":19043204,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84179729}]}
     */

    private int author_uid;
    private HotBean hot;
    private NormalBean normal;

    public int getAuthor_uid() {
        return author_uid;
    }

    public void setAuthor_uid(int author_uid) {
        this.author_uid = author_uid;
    }

    public HotBean getHot() {
        return hot;
    }

    public void setHot(HotBean hot) {
        this.hot = hot;
    }

    public NormalBean getNormal() {
        return normal;
    }

    public void setNormal(NormalBean normal) {
        this.normal = normal;
    }

    public static class HotBean {
        /**
         * info : {"count":0,"np":null}
         * list : []
         */

        private InfoBean info;
        private List<?> list;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public static class InfoBean {
            /**
             * count : 0
             * np : null
             */

            private int count;
            private Object np;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public Object getNp() {
                return np;
            }

            public void setNp(Object np) {
                this.np = np;
            }
        }
    }

    public static class NormalBean {
        /**
         * info : {"count":7,"np":null}
         * list : [{"status":2,"ctime":"2017-07-11T08:49:34","hate_count":0,"data_id":25646220,"content":"哈哈哈，什么电影啊，我想听原版","like_count":1,"user":{"username":"青草味的小胖次丶","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/06/21/594a7558596e1_mini.jpg","weibo_uid":"","personal_page":"http://user.qzone.qq.com/433663FA88752D780F855ED599290A7F","room_name":"","room_role":"","total_cmt_like_count":"27279","is_vip":false,"room_url":"","qzone_uid":"433663FA88752D780F855ED599290A7F","sex":"f","id":20905849,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84535547},{"status":2,"ctime":"2017-07-11T08:48:41","hate_count":0,"data_id":25646220,"content":"妹子从裤裆掏出那根电话，亮瞎你们的眼","like_count":0,"user":{"username":"莫可言","qq_uid":"","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/D5C5D84ECBB03E129C60F59E52DD246C/100","weibo_uid":"","personal_page":"http://user.qzone.qq.com/D5C5D84ECBB03E129C60F59E52DD246C","room_name":"","room_role":"","total_cmt_like_count":"357","is_vip":false,"room_url":"","qzone_uid":"D5C5D84ECBB03E129C60F59E52DD246C","sex":"f","id":20006754,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84535507},{"status":2,"ctime":"2017-07-11T08:47:01","hate_count":0,"data_id":25646220,"content":"谁赞我","like_count":0,"user":{"username":"掏粪专业户","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/10/08/57f9131b5e6b4_mini.jpg","weibo_uid":"","personal_page":"http://user.qzone.qq.com/7F4DCBE3034E45703FCD46E89A69A4FD","room_name":"","room_role":"","total_cmt_like_count":"730","is_vip":false,"room_url":"","qzone_uid":"7F4DCBE3034E45703FCD46E89A69A4FD","sex":"f","id":16645759,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84535397},{"status":0,"ctime":"2017-07-11T08:38:00","hate_count":0,"data_id":25646220,"content":"老梗","like_count":0,"user":{"username":"乄小轩 [为爱逆战]","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/06/09/593a62f02d3c7_mini.jpg","weibo_uid":"","personal_page":"","room_name":"为爱逆战","room_role":"帮主","total_cmt_like_count":"18715","is_vip":true,"room_url":"","qzone_uid":"","sex":"m","id":16243410,"room_icon":"http://wimg.spriteapp.cn/ugc/2016/1101/gang_level_7.png"},"vote":[],"precmts":[],"type":"text","id":84534887},{"status":0,"ctime":"2017-07-06T15:25:36","hate_count":0,"data_id":25646220,"content":"模仿岛国的","like_count":0,"user":{"username":"这名字还不能通过","qq_uid":"","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/F2716D4A2B80718DBA384F724D57A825/100","weibo_uid":"","personal_page":"http://user.qzone.qq.com/F2716D4A2B80718DBA384F724D57A825","room_name":"","room_role":"","total_cmt_like_count":"79","is_vip":false,"room_url":"","qzone_uid":"F2716D4A2B80718DBA384F724D57A825","sex":"m","id":9250941,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84183676},{"status":0,"ctime":"2017-07-06T14:17:52","hate_count":0,"data_id":25646220,"content":"这是什么电影啊","like_count":0,"user":{"username":"用户Z5bNbd","qq_uid":"","profile_image":"http://wx.qlogo.cn/mmopen/PiajxSqBRaEJMej93C3mC9ZouX6v4ufsNql91P5XVLVkMBaYSDyjS1C9PUS5y0ztsfr5yyHsabiaHp8Oibrm4nvWw/0","weibo_uid":"","personal_page":"","room_name":"","room_role":"","total_cmt_like_count":"0","is_vip":false,"room_url":"","qzone_uid":"","sex":"f","id":21030824,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84179902},{"status":0,"ctime":"2017-07-06T14:14:54","hate_count":0,"data_id":25646220,"content":"沙发","like_count":0,"user":{"username":"紅花會","qq_uid":"","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/C914BE3B9A69F816AAE324ED7205939F/100","weibo_uid":"","personal_page":"http://user.qzone.qq.com/C914BE3B9A69F816AAE324ED7205939F","room_name":"","room_role":"","total_cmt_like_count":"2","is_vip":false,"room_url":"","qzone_uid":"C914BE3B9A69F816AAE324ED7205939F","sex":"m","id":19043204,"room_icon":""},"vote":[],"precmts":[],"type":"text","id":84179729}]
         */

        private InfoBeanX info;
        private List<ListBean> list;

        public InfoBeanX getInfo() {
            return info;
        }

        public void setInfo(InfoBeanX info) {
            this.info = info;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBeanX {
            /**
             * count : 7
             * np : null
             */

            private int count;
            private Object np;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public Object getNp() {
                return np;
            }

            public void setNp(Object np) {
                this.np = np;
            }
        }

        public static class ListBean {
            /**
             * status : 2
             * ctime : 2017-07-11T08:49:34
             * hate_count : 0
             * data_id : 25646220
             * content : 哈哈哈，什么电影啊，我想听原版
             * like_count : 1
             * user : {"username":"青草味的小胖次丶","qq_uid":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/06/21/594a7558596e1_mini.jpg","weibo_uid":"","personal_page":"http://user.qzone.qq.com/433663FA88752D780F855ED599290A7F","room_name":"","room_role":"","total_cmt_like_count":"27279","is_vip":false,"room_url":"","qzone_uid":"433663FA88752D780F855ED599290A7F","sex":"f","id":20905849,"room_icon":""}
             * vote : []
             * precmts : []
             * type : text
             * id : 84535547
             */

            private int status;
            private String ctime;
            private int hate_count;
            private int data_id;
            private String content;
            private int like_count;
            private UserBean user;
            private String type;
            private int id;
            private List<?> vote;
            private List<?> precmts;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public int getHate_count() {
                return hate_count;
            }

            public void setHate_count(int hate_count) {
                this.hate_count = hate_count;
            }

            public int getData_id() {
                return data_id;
            }

            public void setData_id(int data_id) {
                this.data_id = data_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<?> getVote() {
                return vote;
            }

            public void setVote(List<?> vote) {
                this.vote = vote;
            }

            public List<?> getPrecmts() {
                return precmts;
            }

            public void setPrecmts(List<?> precmts) {
                this.precmts = precmts;
            }

            public static class UserBean {
                /**
                 * username : 青草味的小胖次丶
                 * qq_uid :
                 * profile_image : http://wimg.spriteapp.cn/profile/large/2017/06/21/594a7558596e1_mini.jpg
                 * weibo_uid :
                 * personal_page : http://user.qzone.qq.com/433663FA88752D780F855ED599290A7F
                 * room_name :
                 * room_role :
                 * total_cmt_like_count : 27279
                 * is_vip : false
                 * room_url :
                 * qzone_uid : 433663FA88752D780F855ED599290A7F
                 * sex : f
                 * id : 20905849
                 * room_icon :
                 */

                private String username;
                private String qq_uid;
                private String profile_image;
                private String weibo_uid;
                private String personal_page;
                private String room_name;
                private String room_role;
                private String total_cmt_like_count;
                private boolean is_vip;
                private String room_url;
                private String qzone_uid;
                private String sex;
                private int id;
                private String room_icon;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getQq_uid() {
                    return qq_uid;
                }

                public void setQq_uid(String qq_uid) {
                    this.qq_uid = qq_uid;
                }

                public String getProfile_image() {
                    return profile_image;
                }

                public void setProfile_image(String profile_image) {
                    this.profile_image = profile_image;
                }

                public String getWeibo_uid() {
                    return weibo_uid;
                }

                public void setWeibo_uid(String weibo_uid) {
                    this.weibo_uid = weibo_uid;
                }

                public String getPersonal_page() {
                    return personal_page;
                }

                public void setPersonal_page(String personal_page) {
                    this.personal_page = personal_page;
                }

                public String getRoom_name() {
                    return room_name;
                }

                public void setRoom_name(String room_name) {
                    this.room_name = room_name;
                }

                public String getRoom_role() {
                    return room_role;
                }

                public void setRoom_role(String room_role) {
                    this.room_role = room_role;
                }

                public String getTotal_cmt_like_count() {
                    return total_cmt_like_count;
                }

                public void setTotal_cmt_like_count(String total_cmt_like_count) {
                    this.total_cmt_like_count = total_cmt_like_count;
                }

                public boolean isIs_vip() {
                    return is_vip;
                }

                public void setIs_vip(boolean is_vip) {
                    this.is_vip = is_vip;
                }

                public String getRoom_url() {
                    return room_url;
                }

                public void setRoom_url(String room_url) {
                    this.room_url = room_url;
                }

                public String getQzone_uid() {
                    return qzone_uid;
                }

                public void setQzone_uid(String qzone_uid) {
                    this.qzone_uid = qzone_uid;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getRoom_icon() {
                    return room_icon;
                }

                public void setRoom_icon(String room_icon) {
                    this.room_icon = room_icon;
                }
            }
        }
    }
}

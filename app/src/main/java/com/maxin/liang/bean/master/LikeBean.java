package com.maxin.liang.bean.master;

import java.util.List;

/**
 * Created by shkstart on 2017/7/9.
 */

public class LikeBean {

    /**
     * meta : {"status":0,"server_time":"2017-07-09 14:53:00","account_id":0,"cost":0.49074482917786,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":true,"num_items":"260","items":{"user_id":"17962","user_name":"Briere\r\n","is_daren":"0","email":"","user_image":{"self_img":"1","orig":"http://imgs-qn.iliangcang.com/ware/userhead/orig/2/17/17962.jpg?t=1499583179","mid":"http://imgs-qn.iliangcang.com/ware/userhead/mid/2/17/17962.jpg?t=1499583179","tmb":"http://imgs-qn.iliangcang.com/ware/userhead/tmb/2/17/17962.jpg?t=1499583179"},"user_desc":"","friend":"0","like_count":"260","recommendation_count":"0","following_count":"41","followed_count":"790","template_id":"0","goods":[{"goods_id":"256940","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/256/256940.jpg?t=1489457545","goods_name":"Rose Kiss小奥汀玫瑰之吻水性指彩套装","price":"198.00","owner_id":"0","comment_count":"0","like_count":"467","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"252126","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/252/252126.jpg","goods_name":"LOMO 拍立得相机 标准版 Sanremo真皮特别版","price":"1099.00","owner_id":"0","comment_count":"0","like_count":"2129","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"251523","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/251/251523.jpg","goods_name":"丹麦儿童设计 灰色猫头鹰玩偶","price":"279.00","owner_id":"0","comment_count":"0","like_count":"411","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"251165","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/251/251165.jpg","goods_name":"ADER error","price":"0.00","owner_id":"5562","comment_count":"7","like_count":"154","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250956","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250956.jpg","goods_name":"David Bowie sitting on fllor mirror","price":"0.00","owner_id":"5562","comment_count":"2","like_count":"390","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250804","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250804.jpg","goods_name":"A Common Mistake When Choosing The Perfect Pale Blue Paint","price":"0.00","owner_id":"5619","comment_count":"0","like_count":"134","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250672","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250672.jpg","goods_name":"CHIN Spring/Summer 2016 Lookbook","price":"0.00","owner_id":"5562","comment_count":"4","like_count":"401","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250549","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250549.jpg","goods_name":"T.D.C | Styling by Lotta Agaton and photography by Kristoffer Johnsson for Residence magazine","price":"0.00","owner_id":"5581","comment_count":"0","like_count":"152","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"249747","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/249/249747.jpg","goods_name":"The Tali Wallet 大立牛皮零钱包 绿迷彩","price":"498.00","owner_id":"0","comment_count":"0","like_count":"382","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250251","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250251.jpg","goods_name":"sandro","price":"0.00","owner_id":"5562","comment_count":"2","like_count":"230","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"}]}}
     */

    private MetaBean meta;
    private int version;
    private DataBean data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * status : 0
         * server_time : 2017-07-09 14:53:00
         * account_id : 0
         * cost : 0.49074482917786
         * errdata : null
         * errmsg :
         */

        private int status;
        private String server_time;
        private int account_id;
        private double cost;
        private Object errdata;
        private String errmsg;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getServer_time() {
            return server_time;
        }

        public void setServer_time(String server_time) {
            this.server_time = server_time;
        }

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public Object getErrdata() {
            return errdata;
        }

        public void setErrdata(Object errdata) {
            this.errdata = errdata;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }

    public static class DataBean {
        /**
         * has_more : true
         * num_items : 260
         * items : {"user_id":"17962","user_name":"Briere\r\n","is_daren":"0","email":"","user_image":{"self_img":"1","orig":"http://imgs-qn.iliangcang.com/ware/userhead/orig/2/17/17962.jpg?t=1499583179","mid":"http://imgs-qn.iliangcang.com/ware/userhead/mid/2/17/17962.jpg?t=1499583179","tmb":"http://imgs-qn.iliangcang.com/ware/userhead/tmb/2/17/17962.jpg?t=1499583179"},"user_desc":"","friend":"0","like_count":"260","recommendation_count":"0","following_count":"41","followed_count":"790","template_id":"0","goods":[{"goods_id":"256940","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/256/256940.jpg?t=1489457545","goods_name":"Rose Kiss小奥汀玫瑰之吻水性指彩套装","price":"198.00","owner_id":"0","comment_count":"0","like_count":"467","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"252126","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/252/252126.jpg","goods_name":"LOMO 拍立得相机 标准版 Sanremo真皮特别版","price":"1099.00","owner_id":"0","comment_count":"0","like_count":"2129","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"251523","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/251/251523.jpg","goods_name":"丹麦儿童设计 灰色猫头鹰玩偶","price":"279.00","owner_id":"0","comment_count":"0","like_count":"411","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"251165","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/251/251165.jpg","goods_name":"ADER error","price":"0.00","owner_id":"5562","comment_count":"7","like_count":"154","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250956","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250956.jpg","goods_name":"David Bowie sitting on fllor mirror","price":"0.00","owner_id":"5562","comment_count":"2","like_count":"390","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250804","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250804.jpg","goods_name":"A Common Mistake When Choosing The Perfect Pale Blue Paint","price":"0.00","owner_id":"5619","comment_count":"0","like_count":"134","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250672","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250672.jpg","goods_name":"CHIN Spring/Summer 2016 Lookbook","price":"0.00","owner_id":"5562","comment_count":"4","like_count":"401","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250549","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250549.jpg","goods_name":"T.D.C | Styling by Lotta Agaton and photography by Kristoffer Johnsson for Residence magazine","price":"0.00","owner_id":"5581","comment_count":"0","like_count":"152","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"249747","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/249/249747.jpg","goods_name":"The Tali Wallet 大立牛皮零钱包 绿迷彩","price":"498.00","owner_id":"0","comment_count":"0","like_count":"382","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250251","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250251.jpg","goods_name":"sandro","price":"0.00","owner_id":"5562","comment_count":"2","like_count":"230","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"}]}
         */

        private boolean has_more;
        private String num_items;
        private ItemsBean items;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getNum_items() {
            return num_items;
        }

        public void setNum_items(String num_items) {
            this.num_items = num_items;
        }

        public ItemsBean getItems() {
            return items;
        }

        public void setItems(ItemsBean items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * user_id : 17962
             * user_name : Briere

             * is_daren : 0
             * email :
             * user_image : {"self_img":"1","orig":"http://imgs-qn.iliangcang.com/ware/userhead/orig/2/17/17962.jpg?t=1499583179","mid":"http://imgs-qn.iliangcang.com/ware/userhead/mid/2/17/17962.jpg?t=1499583179","tmb":"http://imgs-qn.iliangcang.com/ware/userhead/tmb/2/17/17962.jpg?t=1499583179"}
             * user_desc :
             * friend : 0
             * like_count : 260
             * recommendation_count : 0
             * following_count : 41
             * followed_count : 790
             * template_id : 0
             * goods : [{"goods_id":"256940","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/256/256940.jpg?t=1489457545","goods_name":"Rose Kiss小奥汀玫瑰之吻水性指彩套装","price":"198.00","owner_id":"0","comment_count":"0","like_count":"467","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"252126","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/252/252126.jpg","goods_name":"LOMO 拍立得相机 标准版 Sanremo真皮特别版","price":"1099.00","owner_id":"0","comment_count":"0","like_count":"2129","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"251523","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/251/251523.jpg","goods_name":"丹麦儿童设计 灰色猫头鹰玩偶","price":"279.00","owner_id":"0","comment_count":"0","like_count":"411","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"251165","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/251/251165.jpg","goods_name":"ADER error","price":"0.00","owner_id":"5562","comment_count":"7","like_count":"154","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250956","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250956.jpg","goods_name":"David Bowie sitting on fllor mirror","price":"0.00","owner_id":"5562","comment_count":"2","like_count":"390","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250804","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250804.jpg","goods_name":"A Common Mistake When Choosing The Perfect Pale Blue Paint","price":"0.00","owner_id":"5619","comment_count":"0","like_count":"134","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250672","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250672.jpg","goods_name":"CHIN Spring/Summer 2016 Lookbook","price":"0.00","owner_id":"5562","comment_count":"4","like_count":"401","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250549","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250549.jpg","goods_name":"T.D.C | Styling by Lotta Agaton and photography by Kristoffer Johnsson for Residence magazine","price":"0.00","owner_id":"5581","comment_count":"0","like_count":"152","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"249747","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/249/249747.jpg","goods_name":"The Tali Wallet 大立牛皮零钱包 绿迷彩","price":"498.00","owner_id":"0","comment_count":"0","like_count":"382","liked":"0","is_outter":"0","sale_by":"liangcang","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"250251","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/250/250251.jpg","goods_name":"sandro","price":"0.00","owner_id":"5562","comment_count":"2","like_count":"230","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"}]
             */

            private String user_id;
            private String user_name;
            private String is_daren;
            private String email;
            private UserImageBean user_image;
            private String user_desc;
            private String friend;
            private String like_count;
            private String recommendation_count;
            private String following_count;
            private String followed_count;
            private String template_id;
            private List<GoodsBean> goods;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getIs_daren() {
                return is_daren;
            }

            public void setIs_daren(String is_daren) {
                this.is_daren = is_daren;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public UserImageBean getUser_image() {
                return user_image;
            }

            public void setUser_image(UserImageBean user_image) {
                this.user_image = user_image;
            }

            public String getUser_desc() {
                return user_desc;
            }

            public void setUser_desc(String user_desc) {
                this.user_desc = user_desc;
            }

            public String getFriend() {
                return friend;
            }

            public void setFriend(String friend) {
                this.friend = friend;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getRecommendation_count() {
                return recommendation_count;
            }

            public void setRecommendation_count(String recommendation_count) {
                this.recommendation_count = recommendation_count;
            }

            public String getFollowing_count() {
                return following_count;
            }

            public void setFollowing_count(String following_count) {
                this.following_count = following_count;
            }

            public String getFollowed_count() {
                return followed_count;
            }

            public void setFollowed_count(String followed_count) {
                this.followed_count = followed_count;
            }

            public String getTemplate_id() {
                return template_id;
            }

            public void setTemplate_id(String template_id) {
                this.template_id = template_id;
            }

            public List<GoodsBean> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBean> goods) {
                this.goods = goods;
            }

            public static class UserImageBean {
                /**
                 * self_img : 1
                 * orig : http://imgs-qn.iliangcang.com/ware/userhead/orig/2/17/17962.jpg?t=1499583179
                 * mid : http://imgs-qn.iliangcang.com/ware/userhead/mid/2/17/17962.jpg?t=1499583179
                 * tmb : http://imgs-qn.iliangcang.com/ware/userhead/tmb/2/17/17962.jpg?t=1499583179
                 */

                private String self_img;
                private String orig;
                private String mid;
                private String tmb;

                public String getSelf_img() {
                    return self_img;
                }

                public void setSelf_img(String self_img) {
                    this.self_img = self_img;
                }

                public String getOrig() {
                    return orig;
                }

                public void setOrig(String orig) {
                    this.orig = orig;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getTmb() {
                    return tmb;
                }

                public void setTmb(String tmb) {
                    this.tmb = tmb;
                }
            }

            public static class GoodsBean {
                /**
                 * goods_id : 256940
                 * goods_image : http://imgs-qn.iliangcang.com/ware/goods/big/2/256/256940.jpg?t=1489457545
                 * goods_name : Rose Kiss小奥汀玫瑰之吻水性指彩套装
                 * price : 198.00
                 * owner_id : 0
                 * comment_count : 0
                 * like_count : 467
                 * liked : 0
                 * is_outter : 0
                 * sale_by : liangcang
                 * promotion_imgurl : http://imgs-qn.iliangcang.com
                 */

                private String goods_id;
                private String goods_image;
                private String goods_name;
                private String price;
                private String owner_id;
                private String comment_count;
                private String like_count;
                private String liked;
                private String is_outter;
                private String sale_by;
                private String promotion_imgurl;

                public String getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(String goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_image() {
                    return goods_image;
                }

                public void setGoods_image(String goods_image) {
                    this.goods_image = goods_image;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getOwner_id() {
                    return owner_id;
                }

                public void setOwner_id(String owner_id) {
                    this.owner_id = owner_id;
                }

                public String getComment_count() {
                    return comment_count;
                }

                public void setComment_count(String comment_count) {
                    this.comment_count = comment_count;
                }

                public String getLike_count() {
                    return like_count;
                }

                public void setLike_count(String like_count) {
                    this.like_count = like_count;
                }

                public String getLiked() {
                    return liked;
                }

                public void setLiked(String liked) {
                    this.liked = liked;
                }

                public String getIs_outter() {
                    return is_outter;
                }

                public void setIs_outter(String is_outter) {
                    this.is_outter = is_outter;
                }

                public String getSale_by() {
                    return sale_by;
                }

                public void setSale_by(String sale_by) {
                    this.sale_by = sale_by;
                }

                public String getPromotion_imgurl() {
                    return promotion_imgurl;
                }

                public void setPromotion_imgurl(String promotion_imgurl) {
                    this.promotion_imgurl = promotion_imgurl;
                }
            }
        }
    }
}

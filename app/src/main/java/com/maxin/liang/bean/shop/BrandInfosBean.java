package com.maxin.liang.bean.shop;

import java.util.List;

/**
 * Created by shkstart on 2017/7/10.
 */

public class BrandInfosBean {

    /**
     * meta : {"status":0,"server_time":"2017-07-10 09:37:01","account_id":0,"cost":0.011605024337769,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":false,"num_items":"1","items":[{"goods_id":"258358","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/258/258358.jpg","goods_name":"纳米液体手机贴膜 | 屏幕坚固15倍 防摔防刮防撞击 无气泡","owner_id":"0","like_count":"684","price":"198.00","is_gift":"0","sale_by":"liangcang","comment_count":"0","liked":"0","goods_url":"http://imgs-qn.iliangcang.com/i/goods/?id=258358","brand_info":{"brand_id":"846","brand_name":"WHOOSH","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/846.jpg","brand_desc":"我们的产品是生活中肮脏的时刻的解决方案，定义了一个全新的清洁类别。嗖!是下一代的清洁产品，利用了配方开发和生物技术的最新进步，我们创造出比其他传统和天然清洁产品更优越、更安全的产品。"},"promotion_imgurl":"","discount_price":"","promotion_note":"","shop_price":"198.00"}]}
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
         * server_time : 2017-07-10 09:37:01
         * account_id : 0
         * cost : 0.011605024337769
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
         * has_more : false
         * num_items : 1
         * items : [{"goods_id":"258358","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/258/258358.jpg","goods_name":"纳米液体手机贴膜 | 屏幕坚固15倍 防摔防刮防撞击 无气泡","owner_id":"0","like_count":"684","price":"198.00","is_gift":"0","sale_by":"liangcang","comment_count":"0","liked":"0","goods_url":"http://imgs-qn.iliangcang.com/i/goods/?id=258358","brand_info":{"brand_id":"846","brand_name":"WHOOSH","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/846.jpg","brand_desc":"我们的产品是生活中肮脏的时刻的解决方案，定义了一个全新的清洁类别。嗖!是下一代的清洁产品，利用了配方开发和生物技术的最新进步，我们创造出比其他传统和天然清洁产品更优越、更安全的产品。"},"promotion_imgurl":"","discount_price":"","promotion_note":"","shop_price":"198.00"}]
         */

        private boolean has_more;
        private String num_items;
        private List<ItemsBean> items;

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

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * goods_id : 258358
             * goods_image : http://imgs-qn.iliangcang.com/ware/goods/big/2/258/258358.jpg
             * goods_name : 纳米液体手机贴膜 | 屏幕坚固15倍 防摔防刮防撞击 无气泡
             * owner_id : 0
             * like_count : 684
             * price : 198.00
             * is_gift : 0
             * sale_by : liangcang
             * comment_count : 0
             * liked : 0
             * goods_url : http://imgs-qn.iliangcang.com/i/goods/?id=258358
             * brand_info : {"brand_id":"846","brand_name":"WHOOSH","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/846.jpg","brand_desc":"我们的产品是生活中肮脏的时刻的解决方案，定义了一个全新的清洁类别。嗖!是下一代的清洁产品，利用了配方开发和生物技术的最新进步，我们创造出比其他传统和天然清洁产品更优越、更安全的产品。"}
             * promotion_imgurl :
             * discount_price :
             * promotion_note :
             * shop_price : 198.00
             */

            private String goods_id;
            private String goods_image;
            private String goods_name;
            private String owner_id;
            private String like_count;
            private String price;
            private String is_gift;
            private String sale_by;
            private String comment_count;
            private String liked;
            private String goods_url;
            private BrandInfoBean brand_info;
            private String promotion_imgurl;
            private String discount_price;
            private String promotion_note;
            private String shop_price;

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

            public String getOwner_id() {
                return owner_id;
            }

            public void setOwner_id(String owner_id) {
                this.owner_id = owner_id;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getIs_gift() {
                return is_gift;
            }

            public void setIs_gift(String is_gift) {
                this.is_gift = is_gift;
            }

            public String getSale_by() {
                return sale_by;
            }

            public void setSale_by(String sale_by) {
                this.sale_by = sale_by;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getLiked() {
                return liked;
            }

            public void setLiked(String liked) {
                this.liked = liked;
            }

            public String getGoods_url() {
                return goods_url;
            }

            public void setGoods_url(String goods_url) {
                this.goods_url = goods_url;
            }

            public BrandInfoBean getBrand_info() {
                return brand_info;
            }

            public void setBrand_info(BrandInfoBean brand_info) {
                this.brand_info = brand_info;
            }

            public String getPromotion_imgurl() {
                return promotion_imgurl;
            }

            public void setPromotion_imgurl(String promotion_imgurl) {
                this.promotion_imgurl = promotion_imgurl;
            }

            public String getDiscount_price() {
                return discount_price;
            }

            public void setDiscount_price(String discount_price) {
                this.discount_price = discount_price;
            }

            public String getPromotion_note() {
                return promotion_note;
            }

            public void setPromotion_note(String promotion_note) {
                this.promotion_note = promotion_note;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public static class BrandInfoBean {
                /**
                 * brand_id : 846
                 * brand_name : WHOOSH
                 * brand_logo : http://imgs-qn.iliangcang.com/ware/brand/846.jpg
                 * brand_desc : 我们的产品是生活中肮脏的时刻的解决方案，定义了一个全新的清洁类别。嗖!是下一代的清洁产品，利用了配方开发和生物技术的最新进步，我们创造出比其他传统和天然清洁产品更优越、更安全的产品。
                 */

                private String brand_id;
                private String brand_name;
                private String brand_logo;
                private String brand_desc;

                public String getBrand_id() {
                    return brand_id;
                }

                public void setBrand_id(String brand_id) {
                    this.brand_id = brand_id;
                }

                public String getBrand_name() {
                    return brand_name;
                }

                public void setBrand_name(String brand_name) {
                    this.brand_name = brand_name;
                }

                public String getBrand_logo() {
                    return brand_logo;
                }

                public void setBrand_logo(String brand_logo) {
                    this.brand_logo = brand_logo;
                }

                public String getBrand_desc() {
                    return brand_desc;
                }

                public void setBrand_desc(String brand_desc) {
                    this.brand_desc = brand_desc;
                }
            }
        }
    }
}

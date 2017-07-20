package com.maxin.liang.bilibili.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by shkstart on 2017/7/20.
 */

public class PersonBean {

    @JSONField(name = "code")
    private int _$Code257; // FIXME check this code
    private String message;
    private DataBean data;

    public int get_$Code257() {
        return _$Code257;
    }

    public void set_$Code257(int _$Code257) {
        this._$Code257 = _$Code257;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BannerBean> banner;
        private List<EntranceIconsBean> entranceIcons;
        private List<PartitionsBean> partitions;
        private List<NavigatorBean> navigator;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<EntranceIconsBean> getEntranceIcons() {
            return entranceIcons;
        }

        public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
            this.entranceIcons = entranceIcons;
        }

        public List<PartitionsBean> getPartitions() {
            return partitions;
        }

        public void setPartitions(List<PartitionsBean> partitions) {
            this.partitions = partitions;
        }

        public List<NavigatorBean> getNavigator() {
            return navigator;
        }

        public void setNavigator(List<NavigatorBean> navigator) {
            this.navigator = navigator;
        }

        public static class BannerBean {
            /**
             * title : 友爱社活动最后一周
             * img : http://i0.hdslb.com/bfs/live/b9edb8801133580daaeaf0fd5b31e46483944124.jpg
             * remark : 友爱社活动最后一周
             * link : http://live.bilibili.com/AppBanner/index?id=537
             */

            private String title;
            private String img;
            private String remark;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class EntranceIconsBean {
            /**
             * id : 9
             * name : 绘画专区
             * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?20170717153252","height":"66","width":"66"}
             */

            private int id;
            private String name;
            private EntranceIconBean entrance_icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public EntranceIconBean getEntrance_icon() {
                return entrance_icon;
            }

            public void setEntrance_icon(EntranceIconBean entrance_icon) {
                this.entrance_icon = entrance_icon;
            }

            public static class EntranceIconBean {
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?20170717153252
                 * height : 66
                 * width : 66
                 */

                private String src;
                private String height;
                private String width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }

        public static class PartitionsBean {
            /**
             * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?20170717153252","height":"32","width":"32"},"count":122}
             * lives : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/080837f61a21b08f988cfbd58b75c94020b20cee.jpg","mid":4277009,"name":"NoriZC"},"cover":{"src":"http://i0.hdslb.com/bfs/live/e998b22e66dbd276d70135dda7bb9b9111822c7f.jpg","height":180,"width":320},"title":"NoriZC的绘画直播间","room_id":21398,"check_version":0,"online":1867,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/383167/live_4277009_332_c521e483.flv?wsSecret=4ea9dbd9d8ead4f330d5cef3d56dfd31&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/b0fca4ee7c12cb6f38e4caec833e7378b54c4173.jpg","mid":31023803,"name":"痴人浅语"},"cover":{"src":"http://i0.hdslb.com/bfs/live/bd0aaea97767bbeb1efb23e85480d890f629cfe2.jpg","height":180,"width":320},"title":"又起早了","room_id":268888,"check_version":0,"online":334,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/140565/live_31023803_5616703.flv?wsSecret=7f75d131057b9d703234ae307487d24a&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/de79e7c9d623bfa328c9944eae080f8f347aeba6.jpg","mid":22118395,"name":"玉珩十一"},"cover":{"src":"http://i0.hdslb.com/bfs/live/44163e18db3465fbe8ee76d1f88b16e853189bd3.jpg","height":180,"width":320},"title":"突突突","room_id":94646,"check_version":0,"online":13,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/329546/live_22118395_8052380.flv?wsSecret=177d6e234094726512d677a76613625b&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/ce8af5ba39f59dcd898ed59dbc26e9d0021a3ce1.jpg","mid":35271215,"name":"PumpkinJakk-金鱼"},"cover":{"src":"http://i0.hdslb.com/bfs/live/42d362167790ddd4aa311ac71e8a6767f7a9b20a.jpg","height":180,"width":320},"title":"【金鱼】寻找前世之旅","room_id":472538,"check_version":0,"online":1717,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/907617/live_35271215_8431452.flv?wsSecret=c3250b4b71e3d7c9d357b5010666c8ec&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/56157d60c8c2c0b8f7e137262bbb2e577c95c7a0.png","mid":5050136,"name":"Kirito丶桐人君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/375e1b19a907b9cfa85dbd41f6ab98f6ac5a602a.jpg","height":180,"width":320},"title":"【清新主播（雾）】随便摸摸图，周末开车","room_id":73945,"check_version":0,"online":2425,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/261912/live_5050136_7329209.flv?wsSecret=1b53f07c04b1a70dc13d1914e5d9963e&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/456faf0d3f626447b8aac471025b1f809b6efa09.jpg","mid":32122361,"name":"麻辣图图"},"cover":{"src":"http://i0.hdslb.com/bfs/live/471ec31c52884d8b8bad65f5b9db01686137f7fd.jpg","height":180,"width":320},"title":"摸只军服公主-阿尔泰尔","room_id":280070,"check_version":0,"online":55,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/386/live_32122361_6331550.flv?wsSecret=5061281744c2618245ca735c50cc83ef&wsTime=59489c1e","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/15251f69a1174a3f33cb24fb9476f585c84d3aea.jpg","mid":31845587,"name":"次世代玄明"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7db7009a1bc9871f59cc7d0f33c246bfba47973e.jpg","height":180,"width":320},"title":"沉风绘画  进可点曲","room_id":276949,"check_version":0,"online":43,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/808/live_31845587_1200271.flv?wsSecret=435aad92406abd685142722fad399460&wsTime=59489c1e","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/66d0bbecbb979c6b8c4cbaf2587163f89b8fdfb9.jpg","mid":2456830,"name":"飛鸾"},"cover":{"src":"http://i0.hdslb.com/bfs/live/40cd190e7ceb2f90412b52de03354719c263cda9.jpg","height":180,"width":320},"title":"暑期咸鱼党的练字日常","room_id":109362,"check_version":0,"online":683,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/539524/live_2456830_5759655.flv?wsSecret=2082c6c0d74fe09c037af3ef31492710&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/6e084c0c3c48aa35d95b0a6c531e4a53bc944d1a.jpg","mid":76500814,"name":"半盏halfcup"},"cover":{"src":"http://i0.hdslb.com/bfs/live/80088954a60c23e8ac644780521403b916f20976.jpg","height":180,"width":320},"title":"日常练习（板子新手）","room_id":3309174,"check_version":0,"online":32,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/145526/live_76500814_5873468.flv?wsSecret=ff02407a42a02819f1510c25d18243a1&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/c6cee7b2a02e7315212488b1efab14658ed56a24.jpg","mid":21295777,"name":"狐十四"},"cover":{"src":"http://i0.hdslb.com/bfs/live/015e6295cc0f6eacdad780e4806eb6ec4518ef2f.jpg","height":180,"width":320},"title":"画画的小狐狸沉迷短发小姐姐","room_id":2541786,"check_version":0,"online":25,"area":"绘画专区","area_id":9,"playurl":"http://xl.live-play.acgvideo.com/live-xl/238339/live_21295777_6273675.flv?wsSecret=d3a91a1d53d7bfa04833f783ebbaf34c&wsTime=1500520982","accept_quality":"4","broadcast_type":0,"is_tv":0}]
             */

            private PartitionBean partition;
            private List<LivesBean> lives;

            public PartitionBean getPartition() {
                return partition;
            }

            public void setPartition(PartitionBean partition) {
                this.partition = partition;
            }

            public List<LivesBean> getLives() {
                return lives;
            }

            public void setLives(List<LivesBean> lives) {
                this.lives = lives;
            }

            public static class PartitionBean {
                /**
                 * id : 9
                 * name : 绘画专区
                 * area : draw
                 * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?20170717153252","height":"32","width":"32"}
                 * count : 122
                 */

                private int id;
                private String name;
                private String area;
                private SubIconBean sub_icon;
                private int count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public SubIconBean getSub_icon() {
                    return sub_icon;
                }

                public void setSub_icon(SubIconBean sub_icon) {
                    this.sub_icon = sub_icon;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public static class SubIconBean {
                    /**
                     * src : http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?20170717153252
                     * height : 32
                     * width : 32
                     */

                    private String src;
                    private String height;
                    private String width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }
                }
            }

            public static class LivesBean {
                /**
                 * owner : {"face":"http://i1.hdslb.com/bfs/face/080837f61a21b08f988cfbd58b75c94020b20cee.jpg","mid":4277009,"name":"NoriZC"}
                 * cover : {"src":"http://i0.hdslb.com/bfs/live/e998b22e66dbd276d70135dda7bb9b9111822c7f.jpg","height":180,"width":320}
                 * title : NoriZC的绘画直播间
                 * room_id : 21398
                 * check_version : 0
                 * online : 1867
                 * area : 绘画专区
                 * area_id : 9
                 * playurl : http://dl.live-play.acgvideo.com/live-dl/383167/live_4277009_332_c521e483.flv?wsSecret=4ea9dbd9d8ead4f330d5cef3d56dfd31&wsTime=1500520982
                 * accept_quality : 4
                 * broadcast_type : 0
                 * is_tv : 0
                 */

                private OwnerBean owner;
                private CoverBean cover;
                private String title;
                private int room_id;
                private int check_version;
                private int online;
                private String area;
                private int area_id;
                private String playurl;
                private String accept_quality;
                private int broadcast_type;
                private int is_tv;

                public OwnerBean getOwner() {
                    return owner;
                }

                public void setOwner(OwnerBean owner) {
                    this.owner = owner;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getRoom_id() {
                    return room_id;
                }

                public void setRoom_id(int room_id) {
                    this.room_id = room_id;
                }

                public int getCheck_version() {
                    return check_version;
                }

                public void setCheck_version(int check_version) {
                    this.check_version = check_version;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getPlayurl() {
                    return playurl;
                }

                public void setPlayurl(String playurl) {
                    this.playurl = playurl;
                }

                public String getAccept_quality() {
                    return accept_quality;
                }

                public void setAccept_quality(String accept_quality) {
                    this.accept_quality = accept_quality;
                }

                public int getBroadcast_type() {
                    return broadcast_type;
                }

                public void setBroadcast_type(int broadcast_type) {
                    this.broadcast_type = broadcast_type;
                }

                public int getIs_tv() {
                    return is_tv;
                }

                public void setIs_tv(int is_tv) {
                    this.is_tv = is_tv;
                }

                public static class OwnerBean {
                    /**
                     * face : http://i1.hdslb.com/bfs/face/080837f61a21b08f988cfbd58b75c94020b20cee.jpg
                     * mid : 4277009
                     * name : NoriZC
                     */

                    private String face;
                    private int mid;
                    private String name;

                    public String getFace() {
                        return face;
                    }

                    public void setFace(String face) {
                        this.face = face;
                    }

                    public int getMid() {
                        return mid;
                    }

                    public void setMid(int mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class CoverBean {
                    /**
                     * src : http://i0.hdslb.com/bfs/live/e998b22e66dbd276d70135dda7bb9b9111822c7f.jpg
                     * height : 180
                     * width : 320
                     */

                    private String src;
                    private int height;
                    private int width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }
                }
            }
        }

        public static class NavigatorBean {
            /**
             * id : 9
             * name : 绘画
             * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/blink/9_2x.png?20170710161652","height":"66","width":"66"}
             */

            private int id;
            private String name;
            private EntranceIconBeanX entrance_icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public EntranceIconBeanX getEntrance_icon() {
                return entrance_icon;
            }

            public void setEntrance_icon(EntranceIconBeanX entrance_icon) {
                this.entrance_icon = entrance_icon;
            }

            public static class EntranceIconBeanX {
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/blink/9_2x.png?20170710161652
                 * height : 66
                 * width : 66
                 */

                private String src;
                private String height;
                private String width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }
    }
}

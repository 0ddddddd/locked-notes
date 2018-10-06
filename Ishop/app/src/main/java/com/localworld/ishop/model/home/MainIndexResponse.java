package com.localworld.ishop.model.home;

import android.support.annotation.Keep;

import java.io.Serializable;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenfeng
 * @since 2018-03-24 15:17
 */

@Keep
public class MainIndexResponse implements Serializable {

    public List<IndexBanner> banners;
    public IndexPage pageList;

    public static class IndexBanner implements Serializable {
        public long endTime;
        public long id;
        public String param;
        public String path;
        public String picPath;
        public int sort;
        public long startTime;
        public String theme;
    }

    public static class IndexPage implements Serializable {
        public int count;
        public int pageCount;
        public List<IndexPageItem> list;
    }

}

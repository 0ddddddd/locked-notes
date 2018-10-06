package com.localworld.ishop.model.login;

import java.io.Serializable;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenfeng
 * @since 2018-08-05 13:27
 */
public class FollowListBean implements Serializable {

    public List<FollowerBean> list;

    public static class FollowerBean implements Serializable {
        public long created;
        public String headPic;
        public long id;
        public long targetId;
        public String targetType;
        public long userId;
        public String userName;
    }

}

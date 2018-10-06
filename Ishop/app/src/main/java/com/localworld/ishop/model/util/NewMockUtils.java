package com.localworld.ishop.model.util;

import com.localworld.ishop.model.IndexResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 * 新情报界面模拟数据
 *
 * @author Even.P
 * @since 2018/3/27 10:13
 */
public class NewMockUtils {
    private static List<IndexResponse> mockHomeDataList;

    static {
        initMockData();
    }

    private static void initMockData(){
        mockHomeDataList = new ArrayList<>();
//        mockHomeDataList.add(new MainIndexResponse("",1004));
//        mockHomeDataList.add(new MainIndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140206112&di=de4c160725ddb06e51a6b1fa163fe2fc&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi2%2F33895962%2FTB2XNj9gJfJ8KJjy0FeXXXKEXXa_%2521%252133895962-0-daren.jpg_790x10000.jpg",1004));
//        mockHomeDataList.add(new MainIndexResponse("http://img01.hua.com/uploadpic/images/201772017256480914.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140347426&di=2a6ae4ba122863ad8a94d209c15b491e&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Faa64034f78f0f736414c872c0155b319ebc41369.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140447022&di=891fb5aaec726c0d5695c67700c5609d&imgtype=0&src=http%3A%2F%2Fimage10.71.net%2Fimage10%2F52%2F14%2F92%2F77%2Ffe2566cd-607b-457e-84bb-b0d5b9eba71f.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140516576&di=fc70e43b61c37ba0b698ad758fd04801&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F97%2F86%2F25%2F13978625.jpg",1004));
//        mockHomeDataList.add(new MainIndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140571476&di=5d3184e6c2e91c37bf78fb3302b79209&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170830%2F59e293d2215a416fb87e9b46b11e32e6.jpeg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140687738&di=ae05f33fe88ad17576b5748e224e1e50&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161227%2F12cc5b119d424a9abe0f29d366305a6b_th.jpeg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140750130&di=5e2f6b493191691e25b55685de984b5b&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi4%2F371832545%2FTB2fxQlif2H8KJjy0FcXXaDlFXa_%2521%2521371832545-0-beehive-scenes.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140775968&di=d383a2c3d03acb49bb8e07388ba4dea3&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi1%2F1660463313%2FTB2w6rqc4PI8KJjSspoXXX6MFXa_%2521%25211660463313-0-daren.jpg",1004));

        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140206112&di=de4c160725ddb06e51a6b1fa163fe2fc&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi2%2F33895962%2FTB2XNj9gJfJ8KJjy0FeXXXKEXXa_%2521%252133895962-0-daren.jpg_790x10000.jpg",1004));
        mockHomeDataList.add(new IndexResponse("http://img01.hua.com/uploadpic/images/201772017256480914.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140347426&di=2a6ae4ba122863ad8a94d209c15b491e&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Faa64034f78f0f736414c872c0155b319ebc41369.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140447022&di=891fb5aaec726c0d5695c67700c5609d&imgtype=0&src=http%3A%2F%2Fimage10.71.net%2Fimage10%2F52%2F14%2F92%2F77%2Ffe2566cd-607b-457e-84bb-b0d5b9eba71f.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140516576&di=fc70e43b61c37ba0b698ad758fd04801&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F97%2F86%2F25%2F13978625.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140571476&di=5d3184e6c2e91c37bf78fb3302b79209&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170830%2F59e293d2215a416fb87e9b46b11e32e6.jpeg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140687738&di=ae05f33fe88ad17576b5748e224e1e50&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161227%2F12cc5b119d424a9abe0f29d366305a6b_th.jpeg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140750130&di=5e2f6b493191691e25b55685de984b5b&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi4%2F371832545%2FTB2fxQlif2H8KJjy0FcXXaDlFXa_%2521%2521371832545-0-beehive-scenes.jpg",1004));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522140775968&di=d383a2c3d03acb49bb8e07388ba4dea3&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi1%2F1660463313%2FTB2w6rqc4PI8KJjSspoXXX6MFXa_%2521%25211660463313-0-daren.jpg",1004));
    }

    public static List<IndexResponse> getMockHomeDataList() {
        return mockHomeDataList;
    }
}

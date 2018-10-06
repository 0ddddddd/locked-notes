package com.localworld.ishop.model.util;

import com.localworld.ishop.model.IndexResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author Even.P
 * @since 2018/3/30 18:58
 */
public class MyMockUtils {

    private static List<IndexResponse> mockHomeDataList;

    static {
        initMockData();
    }

    private static void initMockData() {
        mockHomeDataList = new ArrayList<>();
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419748670&di=d11cafc60e6bd7bde793d5c6129132fc&imgtype=0&src=http%3A%2F%2Fwww.hkbtv.cn%2Fupload%2Farticle%2F1%2F2017%2F06%2F19%2F0mbmqffusb5.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419816596&di=f49b6d8cf39f730bcd0f7e4b7be13e4a&imgtype=0&src=http%3A%2F%2Fimg1.wuhoo.cn%2Fi2%2F388603335%2FTB22ylysXXXXXXbXpXXXXXXXXXX_%2521%2521388603335.jpg_300x300.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419853422&di=66e83b0de71d9e868303985369ef9fed&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170829%2F8b1f7efbf8a84640a9f5dc7f7521efe3.jpeg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3505918669,2802944141&fm=200&gp=0.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419888312&di=ccb9699c20dfa8642fb84d72aa1d83ae&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170718%2F2aedd83294f94afd8e597556c312a5c2_th.png", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419931458&di=230562b2bb7f1ec88fcf940c99977e54&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi2%2F287788417%2FTB2juToiv2H8KJjy0FcXXaDlFXa_%2521%2521287788417-0-daren.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419948254&di=3c867b8c7107f638fa865f6eb63be6fe&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170615%2F83d53e7f1f0e479d80799459664b2cbf_th.png", "商品1",1005));
//        mockHomeDataList.add(new MainIndexResponse("", "商品1",1005));

        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419748670&di=d11cafc60e6bd7bde793d5c6129132fc&imgtype=0&src=http%3A%2F%2Fwww.hkbtv.cn%2Fupload%2Farticle%2F1%2F2017%2F06%2F19%2F0mbmqffusb5.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419816596&di=f49b6d8cf39f730bcd0f7e4b7be13e4a&imgtype=0&src=http%3A%2F%2Fimg1.wuhoo.cn%2Fi2%2F388603335%2FTB22ylysXXXXXXbXpXXXXXXXXXX_%2521%2521388603335.jpg_300x300.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419853422&di=66e83b0de71d9e868303985369ef9fed&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170829%2F8b1f7efbf8a84640a9f5dc7f7521efe3.jpeg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3505918669,2802944141&fm=200&gp=0.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419888312&di=ccb9699c20dfa8642fb84d72aa1d83ae&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170718%2F2aedd83294f94afd8e597556c312a5c2_th.png", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419931458&di=230562b2bb7f1ec88fcf940c99977e54&imgtype=0&src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi2%2F287788417%2FTB2juToiv2H8KJjy0FcXXaDlFXa_%2521%2521287788417-0-daren.jpg", "商品1",1005));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419948254&di=3c867b8c7107f638fa865f6eb63be6fe&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170615%2F83d53e7f1f0e479d80799459664b2cbf_th.png", "商品1",1005));
//        mockHomeDataList.add(new MainIndexResponse("", "商品1",1005));
    }

    public static List<IndexResponse> getMockHomeDataList() {
        return mockHomeDataList;
    }

}

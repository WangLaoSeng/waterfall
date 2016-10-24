package com.testwaterfall;

        import android.app.Activity;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.StaggeredGridLayoutManager;

        import com.facebook.drawee.view.DraweeView;
        import com.facebook.drawee.view.SimpleDraweeView;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private WaterFallAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //设置布局管理器为2列，纵向
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new WaterFallAdapter(this, buildData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    //生成6个明星数据，这些Url地址都来源于网络
    private List<PersonCard> buildData() {

        String[] names = {"邓紫棋","范冰冰","杨幂","Angelababy","唐嫣","柳岩"};
        String[] imgUrs = {"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477122728&di=21924aeef8f7847a651fc8bf00a28f49&src=http://www.tengtv.com/file/upload/201609/18/232836341.jpg",
                "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477122795&di=f740bd484870f9bcb0cafe454a6465a2&src=http://tpic.home.news.cn/xhCloudNewsPic/xhpic1501/M08/28/06/wKhTlVfs1h2EBoQfAAAAAF479OI749.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=673651839,1464649612&fm=111&gp=0.jpg",
                "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=fd90a83e900a304e4d22a7fae1c9a7c3/d01373f082025aafa480a2f1fcedab64034f1a5d.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1849074283,1272897972&fm=111&gp=0.jpg",
                "https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=005560fc8b5494ee982208191df4e0e1/c2fdfc039245d68827b453e7a3c27d1ed21b243b.jpg",
        };

        List<PersonCard> list = new ArrayList<>();
        for(int i=0;i<6;i++) {
            PersonCard p = new PersonCard();
            p.avatarUrl = imgUrs[i];
            p.name = names[i];
            p.imgHeight = (i % 2)*100 + 400; //偶数和奇数的图片设置不同的高度，以到达错开的目的
            list.add(p);
        }

        return list;
    }

}

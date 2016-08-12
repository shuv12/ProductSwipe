package app.com.example.android.productswipe;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import app.com.example.android.productswipe.adapter.ProductSwipeAdapter;
import app.com.example.android.productswipe.model.ProductModel;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ImageView imageView;
    private boolean mSlideState = false;
    public ListView listView;
    public float factor = 0.7f;

    RelativeLayout drawerView, mainView;

    private List<ProductModel> productModelList;

    //String[] productPrice = new String[]{"$3000","$40000","$50000","$60000","$80000","$999999","$786689","$347695","$9887489","$465","$343","$42332","$56456","$3000","$40000","$50000","$60000","$80000","$999999","$786689","$347695","$9887489"};
    String[] sellerName = new String[]{"Tommy","Bob","Modric","Ronaldo","Bale","Shuvam","Tommy","Bob","Modric","Ronaldo","Bale","Shuvam","Tommy","Bob","Modric","Ronaldo","Bale","Shuvam",
            "Jimmy"};
    String[] sellerPic = new String[]{"https://cdn3.iconfinder.com/data/icons/pretty-office-part-8-reflection-style/256/User-blue.png",
            "https://cdn3.iconfinder.com/data/icons/pretty-office-part-8-reflection-style/256/User-blue.png",
            "https://s-media-cache-ak0.pinimg.com/564x/dc/d8/c1/dcd8c1b5ef41a7c81fd4790a843056cb.jpg",
            "http://smsranjish.com/wp-content/uploads/2015/12/Beautiful-girl-display-pic-for-fb-profile.jpg",
            "http://4.bp.blogspot.com/-hh6tv59GF_A/UcmYi3Vf91I/AAAAAAAAAPE/TGpTOuhurug/s1600/boys-attitude-kids-profile-pics-7.jpg",
            "http://3.bp.blogspot.com/-AiTY0p-5FWc/Uz2UcJl_v7I/AAAAAAAABBw/FCIY5Z1KJas/s1600/funadress123+boy+1.jpg",
            "https://c2.staticflickr.com/4/3893/14921394066_cb305327fe_b.jpg",
            "https://dontpakao.files.wordpress.com/2015/06/cool_fb_profile_pics_for_girl-2xjra46jod1x90mg7zylfu.jpg",
            "http://in2.ccio.co/V9/2D/d7/CoolAndStylishProfilePicturesForFacebookForGirls2015600x300.jpg","https://s-media-cache-ak0.pinimg.com/564x/dc/d8/c1/dcd8c1b5ef41a7c81fd4790a843056cb.jpg",
            "http://smsranjish.com/wp-content/uploads/2015/12/Beautiful-girl-display-pic-for-fb-profile.jpg",
            "http://4.bp.blogspot.com/-hh6tv59GF_A/UcmYi3Vf91I/AAAAAAAAAPE/TGpTOuhurug/s1600/boys-attitude-kids-profile-pics-7.jpg",
            "http://3.bp.blogspot.com/-AiTY0p-5FWc/Uz2UcJl_v7I/AAAAAAAABBw/FCIY5Z1KJas/s1600/funadress123+boy+1.jpg",
            "https://c2.staticflickr.com/4/3893/14921394066_cb305327fe_b.jpg",
            "https://dontpakao.files.wordpress.com/2015/06/cool_fb_profile_pics_for_girl-2xjra46jod1x90mg7zylfu.jpg",
            "http://in2.ccio.co/V9/2D/d7/CoolAndStylishProfilePicturesForFacebookForGirls2015600x300.jpg","https://s-media-cache-ak0.pinimg.com/564x/dc/d8/c1/dcd8c1b5ef41a7c81fd4790a843056cb.jpg",
            "http://smsranjish.com/wp-content/uploads/2015/12/Beautiful-girl-display-pic-for-fb-profile.jpg",
            "http://4.bp.blogspot.com/-hh6tv59GF_A/UcmYi3Vf91I/AAAAAAAAAPE/TGpTOuhurug/s1600/boys-attitude-kids-profile-pics-7.jpg",
            "http://3.bp.blogspot.com/-AiTY0p-5FWc/Uz2UcJl_v7I/AAAAAAAABBw/FCIY5Z1KJas/s1600/funadress123+boy+1.jpg",
            "https://c2.staticflickr.com/4/3893/14921394066_cb305327fe_b.jpg",
            "https://dontpakao.files.wordpress.com/2015/06/cool_fb_profile_pics_for_girl-2xjra46jod1x90mg7zylfu.jpg",
            "http://in2.ccio.co/V9/2D/d7/CoolAndStylishProfilePicturesForFacebookForGirls2015600x300.jpg"};
    String[] productImage = new String[]{"http://www.kemecer.com/i/car-wallpapers-lamborghini-wallpapers-high-resolution.jpeg",
            "http://digitalsynopsis.com/wp-content/uploads/2014/06/supercar-wallpapers-lamborghini-5.jpg",
            "http://wallpapercave.com/wp/UFYQ97k.jpg",
            "http://cdn.pinthiscars.com/images/cool-lamborghini-wallpapers-blue-wallpaper-4.jpg",
            "http://hdwallpaperbackgrounds.net/wp-content/uploads/2015/11/Audi-Car-Desktop-Wallpapers-White.jpg",
            "http://fullhdpictures.com/wp-content/uploads/2016/06/Great-Muscle-Car-Wallpaper.jpg",
            "http://wallpapercave.com/wp/gw6WLd8.jpg","http://wallpapercave.com/wp/gw6WLd8.jpg","http://wallpapercave.com/wp/gw6WLd8.jpg",
            "http://wallpapercave.com/wp/gw6WLd8.jpg","http://www.kemecer.com/i/car-wallpapers-lamborghini-wallpapers-high-resolution.jpeg",
            "http://digitalsynopsis.com/wp-content/uploads/2014/06/supercar-wallpapers-lamborghini-5.jpg",
            "http://wallpapercave.com/wp/UFYQ97k.jpg",
            "http://cdn.pinthiscars.com/images/cool-lamborghini-wallpapers-blue-wallpaper-4.jpg",
            "http://hdwallpaperbackgrounds.net/wp-content/uploads/2015/11/Audi-Car-Desktop-Wallpapers-White.jpg",
            "http://fullhdpictures.com/wp-content/uploads/2016/06/Great-Muscle-Car-Wallpaper.jpg",
            "http://wallpapercave.com/wp/gw6WLd8.jpg","http://wallpapercave.com/wp/gw6WLd8.jpg","http://wallpapercave.com/wp/gw6WLd8.jpg",
            "http://wallpapercave.com/wp/gw6WLd8.jpg","http://www.kemecer.com/i/car-wallpapers-lamborghini-wallpapers-high-resolution.jpeg",
            "http://digitalsynopsis.com/wp-content/uploads/2014/06/supercar-wallpapers-lamborghini-5.jpg",
            "http://wallpapercave.com/wp/UFYQ97k.jpg",
            "http://cdn.pinthiscars.com/images/cool-lamborghini-wallpapers-blue-wallpaper-4.jpg",
            "http://hdwallpaperbackgrounds.net/wp-content/uploads/2015/11/Audi-Car-Desktop-Wallpapers-White.jpg",
            "http://fullhdpictures.com/wp-content/uploads/2016/06/Great-Muscle-Car-Wallpaper.jpg",
            "http://wallpapercave.com/wp/gw6WLd8.jpg","http://wallpapercave.com/wp/gw6WLd8.jpg","http://wallpapercave.com/wp/gw6WLd8.jpg",
            "http://wallpapercave.com/wp/gw6WLd8.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //addDrawerItems();


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerView = (RelativeLayout) findViewById(R.id.drawerView);
        mainView = (RelativeLayout) findViewById(R.id.mainView);
        imageView = (ImageView) findViewById(R.id.drawer_icon);
        listView = (ListView) drawerView.findViewById(R.id.list_slidermenu);
        //final Animation animationZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
        //final Animation animationZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomout);

        String[] items = getResources().getStringArray(R.array.list_menu);
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this,R.layout.drawer_list_item,items);
        listView.setAdapter(arrayAdapter1);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSlideState){
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                }
                else
                    mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_name,R.string.app_name){

            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                //mainView.setAnimation(animationZoomIn);
                mSlideState = false;
            }

            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                //mainView.setAnimation(animationZoomIn);
                mSlideState = true;
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset){
                super.onDrawerSlide(drawerView,slideOffset);
                int newWidth = Math.round(mainView.getWidth() * factor),
                        newHeight = Math.round(mainView.getHeight() * factor);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());
                //DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams)mainView.getLayoutParams();
                //int diffX = mainView.getWidth() - newWidth;
                //int diffY = mainView.getHeight() - newHeight;
                //diffX = Math.round(diffX / 2);
                //diffY = Math.round(diffY / 2);

                //params.setMargins(diffX,diffY,diffX,diffY);
                if (mSlideState){
                    mainView.setScaleY((slideOffset)+ 1);
                }
                else {
                    mainView.setScaleY((1 - slideOffset) + 1);
                }
                //mainView.setScaleY(0.7f);
                //mainView.getLayoutParams().height = Math.round(slideOffset * drawerView.getWidth());
                //RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, pixels);
                //params.height = 400;
                //mainView.setLayoutParams(params);
                mDrawerLayout.bringChildToFront(drawerView);
                mDrawerLayout.requestLayout();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        this.productModelList = new ArrayList<>();
        for (int i=0; i<15; i++){
            ProductModel productModel = new ProductModel();
            productModel.setProductImage(this.productImage[i]);
            //productModel.setProductPrice(this.productPrice[i]);
            productModel.setProductSellerName(this.sellerName[i]);
            productModel.setProductSellerPic(this.sellerPic[i]);
            this.productModelList.add(productModel);
        }




        SwipeFlingAdapterView flingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.frame);

        /*final ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("15");*/

        final ProductSwipeAdapter arrayAdapter = new ProductSwipeAdapter(this,R.layout.item,productModelList);

        flingAdapterView.setAdapter(arrayAdapter);
        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!");
                productModelList.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                Log.d("Card","Left");
                Toast.makeText(getApplicationContext(), "Left!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRightCardExit(Object o) {
                Log.d("Card","Right");
                Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
               // arrayList.add("XML ".concat(String.valueOf(i)));
                //arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                //i = i++;
            }

            @Override
            public void onScroll(float v) {
                Log.d("card","scroll");
            }

        });

        flingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                Log.d("card","clicked");
                Toast.makeText(getApplicationContext(), "Did you just click on me?", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //public void addDrawerItems(){
      //  String[] listArray = {"Home", "Profile", "Hosts", "Settings", "Likes"};
     // arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listArray);
       // listView.setAdapter(arrayAdapter);
    //}

}


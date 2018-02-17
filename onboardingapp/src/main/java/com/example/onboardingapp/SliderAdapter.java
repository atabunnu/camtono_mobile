package com.example.onboardingapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by User on 2/4/2018.
 */

public class SliderAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;

    private   Integer[] slide_images = {


            R.drawable.appslogo,
            R.drawable.fileslogo,
            R.drawable.folderlogo,
            R.drawable.gallerylogo

    };

    public SliderAdapter(Context context){
        this.context = context;
    }


//arrays stroes value fr the cliders

public String [] slide_headings ={
        "Apps",
        "Files",
        "Folders",
        "Gallery"



};



public  String[] slide_descs={

        "Select the apps you want to lock",
        "Select the files you want to lock",
        "Select the folders you want to lock",
        "Select the gallery you want to lock"
};

    Class[] activity_array = {
            AppActivity.class, FilesActivity.class, FolderActivity.class, GalleryActivity.class
    };




    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @SuppressLint("ServiceCast")
    @Override


    public Object instantiateItem(final ViewGroup container, final int position) {
         layoutInflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);

        slideImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, activity_array[position]);
                context.startActivity(intent);


            }
        });

        TextView slideHeadling = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
    slideImageView.setImageResource(slide_images[position]);
    slideHeadling.setText(slide_headings[position]);
    slideDescription.setText(slide_descs[position]);

return  view;
    };
//once reach the last page it will stop
    public  void destroyItem(ViewGroup container , int position , Object object){
        container.removeView((RelativeLayout)object);
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}

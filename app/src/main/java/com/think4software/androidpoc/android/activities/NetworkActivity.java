package com.think4software.androidpoc.android.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.think4software.androidpoc.R;
import com.think4software.androidpoc.model.ImageResult;
import com.think4software.androidpoc.service.UnsplashService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_network)
public class NetworkActivity extends AppCompatActivity {

    @ViewById(R.id.randomImage)
    ImageView imageView;

    @Bean
    UnsplashService unsplashService;


    @AfterViews
    public void init() {

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }

    @Click(R.id.generate_image)
    public void generateImage() {

        asyncCall();
    }

    @Background
    public void asyncCall() {

        ImageResult imageResult = unsplashService.fetchRandomImage();
        setGeneratedImage(imageResult);
    }

    @UiThread
    public void setGeneratedImage(ImageResult imageResult) {

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(imageResult.getUrls().getRegular(), imageView);
    }
}

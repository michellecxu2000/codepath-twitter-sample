package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    Tweet tweet;
    ImageView ivProfileImage;
    TextView tvUserName;
    TextView tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfileImage = (ImageView)findViewById(R.id.ivProfileImage);
        tvUserName = (TextView)findViewById(R.id.tvUserName);
        tvBody = (TextView)findViewById(R.id.tvBody);

        //unwraps the tweet that was passed here through the adapter
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));
        Log.d("DetailActivity", String.format("Showing details for  '%s'", tweet.getClass()));

        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileImage);
        tvBody.setText(tweet.body);
        tvUserName.setText(tweet.user.name);

    }
}

package com.example.postlists.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.postlists.R;

/* TODO Ideally an imageService loader instead of a static class */

public class Utils {
    private static final String IMAGE_URL = "https://api.adorable.io/avatars/285/%s.png";

    public static void showAvatar(String userEmail, Context context, ImageView userAvatarView) {
        Glide.with(context).load(String.format(IMAGE_URL, userEmail))
                .dontAnimate()
                .placeholder(R.drawable.placeholder)
                .into(userAvatarView);
    }
}

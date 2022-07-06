package com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.adpter;

import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.AdvancedMediaPlayer;
import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.MediaPlayer;
import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.impl.MP4Player;
import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.impl.VLCPlayer;

/**
 * @author 廖钒
 * @ClassName MediaAdapter
 * @description: TODO
 * @datetime 2022年 06月 17日 14:27
 * @version: 1.0
 */
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String addioType) {
        if (addioType.equals("vlc")) {
            advancedMediaPlayer = new VLCPlayer();
        } else if (addioType.equals("mp4")) {
            advancedMediaPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new MP4Player();
        }
    }
}

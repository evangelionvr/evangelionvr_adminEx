package com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.impl;

import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.MediaPlayer;
import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.adpter.MediaAdapter;

/**
 * @author 廖钒
 * @ClassName AudioPlayer
 * @description: 音频播放器
 * @datetime 2022年 06月 17日 14:41
 * @version: 1.0
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String filename) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("播放mp3文件,文件名:" + filename);
        }
        else if(audioType.equals("vlc") || audioType.equals("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}

package com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.impl;

import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.AdvancedMediaPlayer;

/**
 * @author 廖钒
 * @ClassName VLCPlayer
 * @description: VLC播放器
 * @datetime 2022年 06月 17日 14:25
 * @version: 1.0
 */
public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename) {
        System.out.println("播放VLC文件,文件名:" + filename);
    }

    @Override
    public void PlayMP4(String filename) {

    }
}

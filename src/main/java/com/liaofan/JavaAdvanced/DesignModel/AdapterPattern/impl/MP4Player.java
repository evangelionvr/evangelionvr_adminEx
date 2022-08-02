package com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.impl;

import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.AdvancedMediaPlayer;

/**
 * @author 廖钒
 * @ClassName MP4Player
 * @description: Mp4播放器
 * @datetime 2022年 06月 17日 14:26
 * @version: 1.0
 */
public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename) {

    }

    @Override
    public void PlayMP4(String filename) {
        System.out.println("播放MP4文件,文件名:" + filename);
    }
}

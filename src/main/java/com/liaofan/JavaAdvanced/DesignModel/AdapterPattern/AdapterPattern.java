package com.liaofan.JavaAdvanced.DesignModel.AdapterPattern;

import com.liaofan.JavaAdvanced.DesignModel.AdapterPattern.impl.AudioPlayer;

/**
 * @author 廖钒
 * @ClassName AdapterPattern
 * @description: TODO
 * @datetime 2022年 06月 17日 14:46
 * @version: 1.0
 */
public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}

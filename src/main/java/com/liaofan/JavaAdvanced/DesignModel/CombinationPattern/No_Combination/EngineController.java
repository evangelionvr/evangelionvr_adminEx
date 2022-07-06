package com.liaofan.JavaAdvanced.DesignModel.CombinationPattern.No_Combination;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 廖钒
 * @ClassName EngineController
 * @description: TODO
 * @datetime 2022年 07月 06日 20:12
 * @version: 1.0
 */

@Slf4j
public class EngineController {
    public String process(final String userId, final String userSex, final int userAge) {
        log.info("ifelse实现方式判断用户结果:userid:{}, userSex:{},userAge:{}",userId,userSex,userAge);

        if("man".equals(userSex)) {
            if (userAge < 25) {
                return "果实A";
            }

            if(userAge >= 25) {
                return "果实B";
            }
        }

        if("woman".equals(userSex)) {
            if(userAge < 25) {
                return "果实C";
            }

            if(userAge >= 25) {
                return "果实D";
            }
        }

        return null;
    }

    public static void main(String[] args) {
        EngineController engineController = new EngineController();
        String processResult = engineController.process("ccc", "man", 63);
        System.out.println(processResult);
    }
}

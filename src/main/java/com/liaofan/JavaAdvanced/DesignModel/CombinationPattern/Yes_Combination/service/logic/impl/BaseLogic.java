package com.liaofan.JavaAdvanced.DesignModel.CombinationPattern.Yes_Combination.service.logic.impl;

import com.liaofan.JavaAdvanced.DesignModel.CombinationPattern.Yes_Combination.model.vo.TreeNodeLink;
import com.liaofan.JavaAdvanced.DesignModel.CombinationPattern.Yes_Combination.service.logic.LogicFilter;

import java.util.List;
import java.util.Map;

/**
 * @author 廖钒
 * @ClassName BaseLogic
 * @description: TODO
 * @datetime 2022年 07月 06日 20:52
 * @version: 1.0
 */
public class BaseLogic implements LogicFilter {
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        return null;
    }

    @Override
    public String matterValue(Long treeId, String userid, Map<String, String> decisioMatter) {
        return null;
    }

    private boolean decisionLogic(String matterValue, TreeNodeLink
            treeNodeLink) {
        //switch (treeNodeLink.get)
        return false;
    }
}

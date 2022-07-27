package com.liaofan.JavaAdvanced.DesignModel.CombinationPattern.Yes_Combination.service.logic;

import com.liaofan.JavaAdvanced.DesignModel.CombinationPattern.Yes_Combination.model.vo.TreeNodeLink;

import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.Map;

public interface LogicFilter {
    /**
     * 逻辑决策器
     * @param matterValue
     * @param treeNodeLinkList
     * @return
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    String matterValue(Long treeId, String userid, Map<String, String> decisioMatter);

}

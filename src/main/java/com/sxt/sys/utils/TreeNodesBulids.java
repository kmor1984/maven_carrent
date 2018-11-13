package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;
/*把简单的json转成有层级关系的标准jason*/
public  class TreeNodesBulids {
	public static List<TreeNode>  bulider (List<TreeNode> treeNodes,Integer rootID){
		List<TreeNode> node = new ArrayList<>();
		for(TreeNode treeNode1:treeNodes){
			//先找到根结点，就是第一个结点
			if(treeNode1.getpId()==rootID){
				node.add(treeNode1);
			}
			for(TreeNode treeNode2:treeNodes){
				if(treeNode2.getpId()==treeNode1.getId()){
					//如要treeNode2的父结点等于treeNode1的结点ID，说明treeNode2是treeNode1的一个
					//的一个字结点，就把它放到treeNode1的children里面去
					treeNode1.getChildren().add(treeNode2);
					
				}
			}
			
		}
		
		return node;
		
	}
}

package wy.core.util;

import net.sf.json.JSONArray;
import wy.core.node.NodeString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/10.
 */
public class TreeStringBuilder {

    List<NodeString>nodes=new ArrayList<>();

    public String buildTree(List<NodeString> nodes) {

        TreeStringBuilder treeStringBuilder = new TreeStringBuilder(nodes);

        return treeStringBuilder.buildJSONTree();
    }


    public TreeStringBuilder() {
    }

    public TreeStringBuilder(List<NodeString>nodes) {
        super();
        this.nodes = nodes;
    }

    public String buildJSONTree() {
        List<NodeString> nodeTree = buildTree();
        JSONArray jsonArray = JSONArray.fromObject(nodeTree);
        return jsonArray.toString();
    }


    // 构建树形结构
    public List<NodeString> buildTree() {
        List<NodeString> treeNodes = new ArrayList<>();
        List<NodeString> rootNodes = getRootNodes();
        for (NodeString rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    // 递归子节点
    public void buildChildNodes(NodeString node) {
        List<NodeString> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (NodeString child : children) {
                buildChildNodes(child);
            }
            node.setChildren(children);
        }
    }

    // 获取父节点下所有的子节点
    public List<NodeString> getChildNodes(NodeString pnode) {
        List<NodeString> childNodes = new ArrayList<>();
        for (NodeString n : nodes) {
            if (pnode.getId().equals(n.getPid())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    // 判断是否为根节点
    public boolean rootNode(NodeString node) {
        boolean isRootNode = true;
        for (NodeString n : nodes) {
            if (node.getPid().equals(n.getId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    // 获取集合中所有的根节点
    public List<NodeString> getRootNodes() {
        List<NodeString> rootNodes = new ArrayList<>();
        for (NodeString n : nodes) {
            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }
}

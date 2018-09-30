package wy.core.node;


import java.util.List;

/**
 * Created by Administrator on 2018/8/10.
 */
public class NodeString {
    private String id;
    private String pid;
    private String name;
    private List<NodeString> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeString> getChildren() {
        return children;
    }

    public void setChildren(List<NodeString> children) {
        this.children = children;
    }

    public NodeString(String id, String pid, String name, List<NodeString> children) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.children = children;
    }

    public NodeString() {
    }
}

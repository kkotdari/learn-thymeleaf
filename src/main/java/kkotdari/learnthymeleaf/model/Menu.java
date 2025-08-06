package kkotdari.learnthymeleaf.model;

import java.util.List;

public class Menu {

    private String parentId;
    private int order;
    private String id;
    private String name;
    private String path;
    private List<Menu> subs;

    public String getParentId() {
        return parentId;
    }

    public int getOrder() {
        return order;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public List<Menu> getSubs() {
        return subs;
    }

}

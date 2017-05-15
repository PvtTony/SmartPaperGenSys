package me.songt.smartpaper.vo.question;

import java.util.List;

/**
 * Created by Sarah on 2017/3/30.
 */
public class  OptionSolution {

    private int id;
    private List<String> items;  //选项
    private String solutions;    //解析

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getSolutions() {
        return solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }
}

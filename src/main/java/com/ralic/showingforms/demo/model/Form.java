package com.ralic.showingforms.demo.model;

public class  Form {
    private String id;
    private String name;
    private FormItem[] items;

    public Form() {

    }                                                     

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FormItem[] getItems() {
        return items;
    }

    public void setItems(FormItem[] items) {
        this.items = items;
    }
}





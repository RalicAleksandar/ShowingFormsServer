package com.ralic.showingforms.demo.model;

public class FormItem {
    private int type;
    private String label;
    private boolean required;


    public FormItem() {

    }

    public FormItem(int type, String label, boolean required) {
        this.type = type;
        this.label = label;
        this.required = required;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}

















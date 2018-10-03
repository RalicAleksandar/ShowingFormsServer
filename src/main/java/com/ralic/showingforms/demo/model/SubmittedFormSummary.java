package com.ralic.showingforms.demo.model;

import java.util.Date;

public class SubmittedFormSummary {
    private String id;
    private String formName;
    private String submittedBy;
    private Date submittedAt;

    public SubmittedFormSummary(SubmittedForm form) {
        this.id = form.getId();
        this.submittedBy = form.getSubmittedBy();
        this.submittedAt = form.getSubmittedAt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }
}

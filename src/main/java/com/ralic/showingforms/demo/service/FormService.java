package com.ralic.showingforms.demo.service;

import com.ralic.showingforms.demo.model.Form;
import com.ralic.showingforms.demo.model.SubmittedForm;
import com.ralic.showingforms.demo.model.SubmittedFormSummary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FormService {

    private static HashMap<String, Form> forms = new HashMap<>();
    private static HashMap<String, SubmittedForm> submittedForms = new HashMap<>();

    private static String generateId() {
        return UUID.randomUUID().toString();
    }

    public ResponseEntity<Form> getForm(String id) {
        Form form = forms.get(id);
        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public String persistForm(Form form) {
        String id = form.getId() != null ? form.getId() : FormService.generateId();
        form.setId(id);
        forms.put(id, form);
        return id;
    }

    public ResponseEntity<SubmittedForm> getSubmittedForm(String id) {
        SubmittedForm form = submittedForms.get(id);
        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public String submitForm(SubmittedForm values) {
        String id = FormService.generateId();
        values.setId(id);
        submittedForms.put(id, values);
        return id;
    }

    public ResponseEntity<Collection<Form>> getAllForms() {
        return new ResponseEntity<>(forms.values(), HttpStatus.OK);
    }

    public ResponseEntity<Collection<SubmittedFormSummary>> getAllSubmittedForms() {
        return new ResponseEntity<>(submittedForms.values().stream()
                .map(submittedForm -> {
                    SubmittedFormSummary summary = new SubmittedFormSummary(submittedForm);
                    summary.setFormName(getFormName(submittedForm.getFormId()));
                    return summary;
                }).collect(Collectors.toList()), HttpStatus.OK);
    }

    private String getFormName(String formId) {
        return forms.get(formId).getName();
    }
}

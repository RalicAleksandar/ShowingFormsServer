package com.ralic.showingforms.demo.service;

import com.ralic.showingforms.demo.enums.ItemType;
import com.ralic.showingforms.demo.model.Form;
import com.ralic.showingforms.demo.model.FormItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FormService {

    private static HashMap<String, Form> forms = new HashMap<>();

    private static int id = 0;

    private static String generateId() {
        return Integer.toString(++id);
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

    public ResponseEntity<Collection<Form>> getAllForms() {
        return new ResponseEntity<>(forms.values(), HttpStatus.OK);
    }
}

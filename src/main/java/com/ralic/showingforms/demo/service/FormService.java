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

    static {
        Form f = new Form();
        f.setId("1");
        f.setName("Form 4222123322");
        FormItem[] fi = new FormItem[]{
                new FormItem(ItemType.CHECKBOX, "las", false),
                new FormItem(ItemType.INPUT, "las", true),
                new FormItem(ItemType.CHECKBOX, "las", false)
        };
        f.setItems(fi);
        forms.put(f.getId(), f);
    }

    public ResponseEntity<Form> getForm(String id) {
        Form form = forms.get(id);
        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public String createForm(Form form) {
        String id = FormService.generateId();
        form.setId(id);
        forms.put(id, form);
        return id;
    }

    private static String generateId() {
        return Integer.toString(++id);
    }

    public ResponseEntity<Collection<Form>> getAllForms() {
        return new ResponseEntity<>(forms.values(), HttpStatus.OK);
    }
}

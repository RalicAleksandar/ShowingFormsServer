package com.ralic.showingforms.demo.controller;

import com.ralic.showingforms.demo.model.Form;
import com.ralic.showingforms.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
public class FormController {

    @Autowired
    FormService formService;

    @RequestMapping(
            value = "/form/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Form> getForm(@PathVariable("id") String id) {
        return formService.getForm(id);
    }

    @RequestMapping(
            value = "/forms",
            method = RequestMethod.GET
    )
    public ResponseEntity<Collection<Form>> getAllSummary() {
        return formService.getAllForms();
    }

    @RequestMapping(
            value = "/submitted",
            method = RequestMethod.GET
    )
    public String getAllSubmitted() {
        return "";
    }

    @RequestMapping(
            value = "/submitted/{id}",
            method = RequestMethod.GET
    )
    public String getSubmitted(@PathVariable("id") String id) {
        return "";
    }

    @RequestMapping(
            value = "/form",
            method = RequestMethod.POST
    )
    public String createForm(@RequestBody Form form) {
        return this.formService.createForm(form);
    }

    @RequestMapping(
            value = "/form/{id}",
            method = RequestMethod.PATCH
    )
    public String updateForm(@PathVariable("id") String id) {
        return "";
    }

    @RequestMapping(
            value = "/submit/{id}",
            method = RequestMethod.POST
    )
    public String submitted(@PathVariable("id") String id) {
        return "";
    }
}

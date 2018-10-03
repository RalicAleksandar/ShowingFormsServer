package com.ralic.showingforms.demo.controller;

import com.ralic.showingforms.demo.model.Form;
import com.ralic.showingforms.demo.model.SubmittedForm;
import com.ralic.showingforms.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Collection<Form>> getAllForms() {
        return formService.getAllForms();
    }

    @RequestMapping(
            value = "/submitted",
            method = RequestMethod.GET
    )
    public ResponseEntity getAllSubmitted() {
        return this.formService.getAllSubmittedForms();
    }

    @RequestMapping(
            value = "/submit",
            method = RequestMethod.POST
    )
    public ResponseEntity submitForm(@RequestBody SubmittedForm form) {
        this.formService.submitForm(form);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/submitted/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity getSubmitted(@PathVariable("id") String id) {
        return this.formService.getSubmittedForm(id);
    }

    @RequestMapping(
            value = "/form",
            method = RequestMethod.POST
    )
    public ResponseEntity createForm(@RequestBody Form form) {
        this.formService.persistForm(form);
        return new ResponseEntity (HttpStatus.OK);
    }

    @RequestMapping(
            value = "/form",
            method = RequestMethod.PATCH
    )
    public ResponseEntity updateForm(@RequestBody Form form) {
        this.formService.persistForm(form);
        return new ResponseEntity(HttpStatus.OK);
    }
}

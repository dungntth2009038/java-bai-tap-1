package com.example.cooanhbaitap1.controller;

import com.example.cooanhbaitap1.model.TbclassEntity;
import com.example.cooanhbaitap1.service.TbclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

public class TbclassController {
    @Autowired
    TbclassService tbclassService;

    @RequestMapping(value = "tbclass", method = RequestMethod.GET)
    public ResponseEntity<List<TbclassEntity>> finAllUser(){
        List<TbclassEntity> lsTbclass = tbclassService.findAll();
        if (lsTbclass.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            return new ResponseEntity.ok(lsUser);
        }
        return new  ResponseEntity<List<TbclassEntity>>(lsTbclass,HttpStatus.OK);
    }
    @RequestMapping(value = "tbclass", method = RequestMethod.GET)
    public ResponseEntity<List<TbclassEntity>> finAllUser(@PathParam("name") String name){
        List<TbclassEntity> lsTbclass = tbclassService.findAllByName(name);
        if (lsTbclass.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            return new ResponseEntity.ok(lsUser);
        }
        return new  ResponseEntity<List<TbclassEntity>>(lsTbclass,HttpStatus.OK);
    }

    @RequestMapping(value = "savetbclass", method = RequestMethod.POST)
    public ResponseEntity<TbclassEntity> saveNewUser(@RequestBody TbclassEntity a){
        tbclassService.saveTbClass(a);
        return new ResponseEntity<TbclassEntity>(a, HttpStatus.OK);
    }
    @RequestMapping(value = "updatetbclass", method = RequestMethod.PUT)
    public ResponseEntity<TbclassEntity> updateUser(
            @PathParam("id") Integer id,
            @RequestBody TbclassEntity a){
        TbclassEntity oldTbclass = tbclassService.findById(id);
        oldTbclass.setId(a.getId());
        oldTbclass.setName(a.getName());
        oldTbclass.setRoom(a.getRoom());
        oldTbclass.setNote(a.getNote());
        tbclassService.saveTbClass(oldTbclass);
        return new ResponseEntity<TbclassEntity>(a, HttpStatus.OK);
    }
    @RequestMapping(value = "updateuser2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TbclassEntity> updateUser2(
            @PathParam(value = "id") Integer id,
            @RequestBody TbclassEntity a){
        TbclassEntity oldTbclass = tbclassService.findById(id);
        oldTbclass.setId(a.getId());
        oldTbclass.setName(a.getName());
        oldTbclass.setRoom(a.getRoom());
        oldTbclass.setNote(a.getNote());
        tbclassService.saveTbClass(oldTbclass);
        return new ResponseEntity<TbclassEntity>(a, HttpStatus.OK);
    }
    @RequestMapping(value = "updatetbclass/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TbclassEntity> deleteUser(@PathVariable(value = "id") Integer id){
        tbclassService.deleteTbClass(id);
        return ResponseEntity.ok().build();
    }
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName()  + " "
                    + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}

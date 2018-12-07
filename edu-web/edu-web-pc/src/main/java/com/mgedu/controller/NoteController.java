package com.mgedu.controller;

import com.mgedu.NoteService;
import com.myedu.dto.NoteBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "/api", tags = "note接口模块")
@RestController
public class NoteController {

    @Autowired
    NoteService noteService;


    // Create a new Note
    @ApiOperation(value = "新增note", notes = "新增note,不需要新增时间和更新时间")
    @ApiImplicitParam(name = "note", value = "笔记实体note", required = true, dataType = "Note")
    @PostMapping("/notes/createNote")
    public NoteBean createNote(@Valid @RequestBody NoteBean note) {
        return noteService.createNote(note);
    }

    @RequestMapping("/show")
    public String show() {
        return "成功";
    }

}
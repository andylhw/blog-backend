package com.alwayslearn.blog.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @GetMapping("/{boardId)")
    @ResponseStatus(HttpStatus.OK)
    public void getBoards(@RequestParam(required = false) int page){

    }

}

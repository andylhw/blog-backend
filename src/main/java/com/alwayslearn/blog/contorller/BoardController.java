package com.alwayslearn.blog.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @GetMapping("/{boardId}")
    @ResponseStatus(HttpStatus.OK)
    public void getBoards(@PathVariable long boardId){

    }
}

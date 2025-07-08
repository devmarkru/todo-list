package ru.devmark.todo_list.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ContentController {

    @GetMapping("/")
    fun index() = "index"
}

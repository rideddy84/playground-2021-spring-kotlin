package com.rideddy84.playground

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @RequestMapping("/")
    fun index(): String {
        return "Welcome home."
    }
}

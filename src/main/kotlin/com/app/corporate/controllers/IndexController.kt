package com.app.corporate.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Base view which returns useful links.
 */
@Controller
class IndexController {
    @GetMapping(path = ["/"])
    fun index(): ModelAndView? {
        val modelAndView = ModelAndView()
        modelAndView.viewName = "index"
        return modelAndView
    }
}
package org.launchcode.skillstracker.controllers;

import jdk.jfr.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {
    @GetMapping
    @ResponseBody
    public String home() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>";
    }

    @GetMapping("form")
    @ResponseBody
    public String form() {
        return "<form method='POST' action='skills'>" +
                "<label>Name:</label><br>" +
                "<input type='text' name='name'><br>" +
                "<label>My favorite language:</label><br>" +
                "<select name='language1'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select><br>" +
                "<label>My second favorite language:</label><br>" +
                "<select name='language2'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select><br>" +
                "<label>My third favorite language</label><br>" +
                "<select name='language3'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select><br>" +

                "<input type='submit' value='Submit'>" +
                "</form>";
    }

    @PostMapping ("skills")
    @ResponseBody
    public String skills(@RequestParam String name, @RequestParam String language1, @RequestParam String language2, @RequestParam String language3) {
        return generateForm(name, language1, language2, language3);
    }

    public static String generateForm(String name, String language1, String language2, String language3) {
        String form = "<h1>" + name + "</h1>" +
                        "<ol>" +
                        "<li>" + language1 + "</li>" +
                        "<li>" + language2 + "</li>" +
                        "<li>" + language3 + "</li>" +
                        "</ol>";

        return form;
    }
}
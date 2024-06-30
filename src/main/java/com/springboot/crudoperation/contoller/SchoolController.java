package com.springboot.crudoperation.contoller;


import com.springboot.crudoperation.model.School;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /*@GetMapping(value = "/school")
    public School getScholDetails()
    {
        return schoolService.findSchoolById(1);
    }*/

    @GetMapping(value = "/school/{schoolId}")
    public ResponseEntity<?> getScholDetailsResponseEntity(@PathVariable int schoolId)
    {
        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.OK);
    }

    @GetMapping(value = "/school")
    public ResponseEntity<?> getScholDetailsRequestParam(@RequestParam(value = "schoolID",required = false) int schoolId)
    {
        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.OK);
    }

    @PostMapping("/school")
    public ResponseEntity<?> createSchool(@RequestBody School school)
    {
        return new ResponseEntity<>(schoolService.saveSchool(school), HttpStatus.OK);
    }

    @PutMapping ("/school")
    public ResponseEntity<?> updateSchool(@RequestBody School school)throws Exception
    {
        return new ResponseEntity<>(schoolService.updateSchool(school), HttpStatus.OK);
    }

    @DeleteMapping ("/school/{schoolId}")
    public ResponseEntity<?> deleteSchool(@PathVariable int schoolId)
    {
        return new ResponseEntity<>(schoolService.deleteSchool(schoolId), HttpStatus.OK);
    }




}

package com.training.rest.webservices.restfulwebservices.controller;

import com.training.rest.webservices.restfulwebservices.entity.User;
import com.training.rest.webservices.restfulwebservices.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController {

    public UserController(User user) {
    }

    private UserDaoService service;

    @Autowired
    public UserController(UserDaoService service) {
        this.service = service;
    }

    @RequestMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @RequestMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        //"all-users", SERVER_PATH+"/users"
        //retrieveAllUsers
        EntityModel<User> resource = EntityModel.of(user);
        Link link = Link.of("all-users");
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        //HATEOAS
        return resource;
    }

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.webdevawesomeprojectserverjava.controllers;

import com.example.webdevawesomeprojectserverjava.models.User;
import com.example.webdevawesomeprojectserverjava.repositories.UserRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpSessionController {

  private UserRepository userRepository;

  @Autowired
  public HttpSessionController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping
  public void register(@RequestBody User user, HttpSession session) {
    if (!this.userRepository.exists(Example.of(user))) {
      this.userRepository.save(user);
      session.setAttribute("currentUser", user.getUsername());
    }
  }

  @PostMapping("/api/login")
  public String login(@RequestBody User user, HttpSession session) {
    Object correctPassword = session.getAttribute(user.getUsername());
    if (correctPassword != null && correctPassword == user.getPassword()) {
      return "Success";
    }
    return "An issue happened when logging in.";
  }

  @PostMapping("/api/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

}

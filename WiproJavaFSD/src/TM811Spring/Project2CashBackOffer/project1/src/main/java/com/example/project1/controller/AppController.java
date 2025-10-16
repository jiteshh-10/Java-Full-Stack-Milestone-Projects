package com.example.project1.controller;


import com.example.project1.model.User;
import com.example.project1.model.Employee;
import com.example.project1.repository.EmployeeRepository;
import com.example.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired private UserRepository userRepo;
    @Autowired private EmployeeRepository employeeRepo;

    // --- Authentication ---
    @GetMapping({"/", "/login"})
    public String viewLoginPage() { return "login"; }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid User user, BindingResult result, RedirectAttributes attrs) {
        if (userRepo.existsById(user.getUsername())) {
            result.rejectValue("username", "error.user", "Username already exists");
        }
        if (result.hasErrors()) return "register";
        userRepo.save(user);
        attrs.addFlashAttribute("message", "Registration successful!");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attrs) {
        Optional<User> userOpt = userRepo.findById(username);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            session.setAttribute("user", userOpt.get());
            return "redirect:/menu";
        }
        attrs.addFlashAttribute("error", "Invalid credentials");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // --- CRUD ---
    @GetMapping("/menu")
    public String showMenu() { return "menu"; }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        return "employee-list";
    }

    @GetMapping("/employees/form")
    public String showEmployeeForm(@RequestParam Optional<Integer> id, Model model) {
        Employee employee = id.isPresent() ? employeeRepo.findById(id.get()).orElse(new Employee()) : new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(Employee employee, RedirectAttributes attrs) {
        employeeRepo.save(employee);
        attrs.addFlashAttribute("message", "Employee saved successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam int id, RedirectAttributes attrs) {
        employeeRepo.deleteById(id);
        attrs.addFlashAttribute("message", "Employee deleted successfully!");
        return "redirect:/employees";
    }
}
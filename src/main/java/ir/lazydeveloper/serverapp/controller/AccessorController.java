package ir.lazydeveloper.serverapp.controller;

import ir.lazydeveloper.serverapp.config.auth.ApplicationUser;
import ir.lazydeveloper.serverapp.config.auth.ApplicationUserService;
import ir.lazydeveloper.serverapp.model.Accessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public/log-in")
public class AccessorController {   private final ApplicationUserService applicationUserService;

    public AccessorController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping
    public ResponseEntity<ApplicationUser> getUserByUsername(@RequestBody ApplicationUser applicationUser) {
        applicationUserService.loadUserByUsername(applicationUser.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(applicationUser);
    }



    @PostMapping
    public ResponseEntity<Accessor> saveUser(@RequestBody Accessor accessor) {
        applicationUserService.save(accessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(accessor);
    }
}

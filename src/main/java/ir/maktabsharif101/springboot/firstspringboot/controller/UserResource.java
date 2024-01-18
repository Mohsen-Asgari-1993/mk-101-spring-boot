package ir.maktabsharif101.springboot.firstspringboot.controller;

import ir.maktabsharif101.springboot.firstspringboot.dto.CurrentUserInfoDTO;
import ir.maktabsharif101.springboot.firstspringboot.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserResource {

    @GetMapping("/current")
    public ResponseEntity<CurrentUserInfoDTO> getCurrentUserInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            MyUserDetails userDetails = (MyUserDetails) authentication
                    .getPrincipal();
            return ResponseEntity.ok(
                    new CurrentUserInfoDTO(
                            userDetails.getUser().getFirstName(),
                            userDetails.getUser().getLastName(),
                            userDetails.getUser().getMobileNumber()
                    )
            );
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}

package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(User user) {
        // Validate full_name
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            return "Full name cannot be empty";
        }

        // Validate mob_num
        String mobNum = adjustMobileNumber(user.getMobNum());
        if (!isValidMobileNumber(mobNum)) {
            return "Invalid mobile number";
        }

        // Validate pan_num
        String panNum = user.getPanNum().toUpperCase();
        if (!isValidPANNumber(panNum)) {
            return "Invalid PAN number";
        }

        // Validate manager_id
        UUID managerId = user.getManagerId();
        // Implement manager validation logic if needed

        // If all validations pass, create the user
        user.setUserId(UUID.randomUUID());
        user.setMobNum(mobNum);
        user.setPanNum(panNum);
        user.setCreatedAt(new Date());
        user.setIsActive(true);
        userRepository.save(user);

        return "User created successfully";
    }

    // Adjust mobile number if it contains country code or prefix
    private String adjustMobileNumber(String mobNum) {
        // Implement adjustment logic if needed
        return mobNum;
    }

    // Validate mobile number format
    private boolean isValidMobileNumber(String mobNum) {
        // Implement validation logic
        return mobNum.matches("\\d{10}");
    }

    // Validate PAN number format
    private boolean isValidPANNumber(String panNum) {
        // Implement validation logic
        return panNum.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    }
}

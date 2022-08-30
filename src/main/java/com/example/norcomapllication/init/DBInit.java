package com.example.norcomapllication.init;

import com.example.norcomapllication.service.DeviceService;
import com.example.norcomapllication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;
    private final DeviceService deviceService;

    public DBInit(UserService userService, DeviceService deviceService) {
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @Override
    public void run(String... args) throws Exception {
    userService.initUsersAndRoles();
    deviceService.initDevices();
    }

}
package com.example.norcomapllication.web;

import com.example.norcomapllication.model.entity.DeviceEntity;
import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.entity.enums.OperationSystemType;
import com.example.norcomapllication.repository.DeviceRepository;
import com.example.norcomapllication.repository.RoleRepository;
import com.example.norcomapllication.repository.UserRepository;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class DeviceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    private void initialization() {

        UserEntity testUser = new UserEntity();

        testUser.setUsername("testUser")
                .setFullName("Test Testov")
                .setGender("male")
                .setAddress("teestttttt")
                .setEmail("test@gmail.com");

        testUser.setPassword(passwordEncoder.encode("test"));

        userRepository.save(testUser);


        DeviceEntity samsung = new DeviceEntity();
        samsung.setFirstImageUrl("https://s13emagst.akamaized.net/products/34408/34407359/images/res_2b0fa73eba769c1da5c288f35c92dc01.jpg")
                .setSecondImageUrl("https://i.guim.co.uk/img/media/460229e455cd38808a11b1d0ebe866fcfd5f06ae/373_437_4638_2783/master/4638.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=a738f3c6316aaa69b8ffffbd56933c78")
                .setThirdImageUrl("https://images.samsung.com/bg/smartphones/galaxy-s21-ultra-5g/images/galaxy-s21-ultra-5g-share-image.jpg")
                .setFourthImageUrl("https://www.counterpointresearch.com/wp-content/uploads/2021/08/counterpoint-samsung-galaxy-s21-ultra-review.jpg")
                .setFifthImageUrl("https://icdn.digitaltrends.com/image/digitaltrends/galaxy-s21-ultra-bottom-ports-500x500.jpg")
                .setName("Samsung Galaxy S21 Ultra")
                .setPrice(new BigDecimal("2530.00"))
                .setType("5G")
                .setOperationSystem(OperationSystemType.Android)
                .setProcessor("Octa-core (1x2.84 GHz Kryo 680 & 3x2.42 GHz Kryo 680 & 4x1.80 GHz Kryo 680) ")
                .setChipset("Snapdragon 888 5G (5 nm)")
                .setSizeDevice("165.1 x 75.6 x 8.9 mm")
                .setWeightDevice(227L)
                .setTypeOfScreen("Dynamic AMOLED 2X, 120Hz, HDR10+, 1500 nits (peak)")
                .setSizeOfScreen(new BigDecimal("6.8"))
                .setResolutionOfScreen("1440 x 3200")
                .setCardMemory("няма")
                .setDeviceStorage("256 GB")
                .setDeviceRamStorage("12 GB")
                .setBackCamera("108 MP, f/1.8, 24mm (wide), 1/1.33\", 0.8µm, PDAF, Laser AF, OIS\n" +
                        "10 MP, f/4.9, 240mm (periscope telephoto), 1/3.24\", 1.22µm, dual pixel PDAF, OIS, 10x optical zoom\n" +
                        "10 MP, f/2.4, 72mm (telephoto), 1/3.24\", 1.22µm, dual pixel PDAF, OIS, 3x optical zoom\n" +
                        "12 MP, f/2.2, 13mm (ultrawide), 1/2.55\", 1.4µm, dual pixel PDAF, Super Steady video\n")
                .setFrontCamera("40 MP, f/2.2, 26mm (wide), 1/2.8\", 0.7µm, PDAF")
                .setSpeaker("Има")
                .setHeadphoneSlot("няма")
                .setBatteryCapacity("5000 mAh");
        deviceRepository.save(samsung);
    }

    @AfterEach
    void delete() {
        this.userRepository.deleteAll();
        this.deviceRepository.deleteAll();
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void allDevices() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/devices/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("devices"));
    }


    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void createDeviceValid() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/devices/add-device"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-device"));
    }


    @Test
    @WithMockUser(username="admin")
    public void testDetails() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/devices/1/device-page"))
                .andExpect(status().isOk())
                .andExpect(view().name("device-page"));
    }
}

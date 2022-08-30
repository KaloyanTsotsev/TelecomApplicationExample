package com.example.norcomapllication.service.impl;

import com.example.norcomapllication.model.binding.DeviceAddBindingModel;
import com.example.norcomapllication.model.entity.DeviceEntity;
import com.example.norcomapllication.model.entity.RoleEntity;
import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.entity.enums.OperationSystemType;
import com.example.norcomapllication.model.entity.enums.RoleEnumClass;
import com.example.norcomapllication.model.service.DeviceAddServiceModel;
import com.example.norcomapllication.model.service.DeviceUpdateServiceModel;
import com.example.norcomapllication.model.view.DeviceDetailsView;
import com.example.norcomapllication.model.view.DeviceSummaryView;
import com.example.norcomapllication.repository.DeviceRepository;
import com.example.norcomapllication.repository.UserRepository;
import com.example.norcomapllication.service.DeviceService;
import com.example.norcomapllication.service.errorPackage.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public DeviceServiceImpl(DeviceRepository deviceRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DeviceSummaryView> getAllDevices() {
        return deviceRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public DeviceDetailsView findById(Long id, String name) {
        return deviceRepository.findById(id).map(device -> mapDeviceDetailsView(name,device)).get();
    }

    private DeviceDetailsView mapDeviceDetailsView(String name, DeviceEntity device) {
        DeviceDetailsView deviceDetailsView = this.modelMapper.map(device,DeviceDetailsView.class);
        deviceDetailsView.setCanDelete(isOwner(name,device.getId()));
        return deviceDetailsView;
    }

    public boolean isOwner(String name, Long id) {
        Optional<DeviceEntity> deviceOptinal = deviceRepository.findById(id);
        Optional<UserEntity> userOptional = userRepository.findByUsername(name);
        if(deviceOptinal.isEmpty() || userOptional.isEmpty()) {
            return false;
        } else {
            DeviceEntity device = deviceOptinal.get();
            return isAdmin(userOptional.get()) || device.getUser().getUsername().equals(name);
        }
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void updateOffer(DeviceUpdateServiceModel serviceModel) {
        DeviceEntity device=deviceRepository.findById(serviceModel.getId()).orElseThrow(()->new ObjectNotFoundException("Device with this id: "+serviceModel.getId()+"not found!"));
        device.setFirstImageUrl(serviceModel.getFirstImageUrl())
                .setSecondImageUrl(serviceModel.getSecondImageUrl())
                .setThirdImageUrl(serviceModel.getThirdImageUrl())
                .setFourthImageUrl(serviceModel.getFourthImageUrl())
                .setFifthImageUrl(serviceModel.getFifthImageUrl())
                .setName(serviceModel.getName())
                .setPrice(serviceModel.getPrice())
                .setType(serviceModel.getType())
                .setOperationSystem(serviceModel.getOperationSystem())
                .setProcessor(serviceModel.getProcessor())
                .setChipset(serviceModel.getChipset())
                .setSizeDevice(serviceModel.getSizeDevice())
                .setWeightDevice(serviceModel.getWeightDevice())
                .setTypeOfScreen(serviceModel.getTypeOfScreen())
                .setSizeOfScreen(serviceModel.getSizeOfScreen())
                .setResolutionOfScreen(serviceModel.getResolutionOfScreen())
                .setCardMemory(serviceModel.getCardMemory())
                .setDeviceStorage(serviceModel.getDeviceStorage())
                .setDeviceRamStorage(serviceModel.getDeviceRamStorage())
                .setBackCamera(serviceModel.getBackCamera())
                .setFrontCamera(serviceModel.getFrontCamera())
                .setSpeaker(serviceModel.getSpeaker())
                .setHeadphoneSlot(serviceModel.getHeadphoneSlot())
                .setBatteryCapacity(serviceModel.getBatteryCapacity());
        deviceRepository.save(device);
    }

    @Override
    public DeviceAddServiceModel addDevice(DeviceAddBindingModel deviceAddBindingModel, String userIdentifier) {
        UserEntity user = userRepository.findByUsername(userIdentifier).orElseThrow();
        DeviceAddServiceModel deviceAddServiceModel = modelMapper.map(deviceAddBindingModel,DeviceAddServiceModel.class);
        DeviceEntity newDevice = modelMapper.map(deviceAddServiceModel, DeviceEntity.class);
        newDevice.setUser(user);
        DeviceEntity savedOffer = deviceRepository.save(newDevice);
        return modelMapper.map(savedOffer,DeviceAddServiceModel.class);
    }



    private boolean isAdmin(UserEntity user) {
        return user.getRoles().stream().map(RoleEntity::getRole).anyMatch(roleEnumClass -> roleEnumClass == RoleEnumClass.ADMIN);
    }

    private DeviceSummaryView map(DeviceEntity device) {

        return this.modelMapper
                .map(device, DeviceSummaryView.class);
    }

    @Override
    public void initDevices() {
        if(deviceRepository.count() == 0) {
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
            DeviceEntity oneplus = new DeviceEntity();
            oneplus.setFirstImageUrl("https://hicomm.bg/uploads/articles/202103/66374/600-mainimage-displeyat-na-oneplus-9-pro-e-nai-blizkoto-do-svrshenstvoto.jpg")
                    .setSecondImageUrl("https://cdn57.androidauthority.net/wp-content/uploads/2021/03/OnePlus-9-Pro-in-hand-angled.jpg")
                    .setThirdImageUrl("https://shop.izgradi.net/wp-content/uploads/2021/08/%D1%85%D0%B8%D0%B4%D1%80%D0%BE%D0%B3%D0%B5%D0%BB-%D0%BF%D1%80%D0%BE%D1%82%D0%B5%D0%BA%D1%82%D0%BE%D1%80-%D0%B7%D0%B0-oneplus-9-pro.jpg")
                    .setFourthImageUrl("https://forums-images.oneplus.net/data/webimg/2021/04-05/606ab98f26b5e.jpg")
                    .setFifthImageUrl("https://www.xiaomitoday.it/wp-content/uploads/2021/04/OnePlus-9-Pro.jpg")
                    .setName("Oneplus 9 Pro")
                    .setPrice(new BigDecimal("2099.00"))
                    .setType("5G")
                    .setOperationSystem(OperationSystemType.Android)
                    .setProcessor("Octa-core (1x2.84 GHz Kryo 680 & 3x2.42 GHz Kryo 680 & 4x1.80 GHz Kryo 680")
                    .setChipset("Snapdragon 888 5G (5 nm)")
                    .setSizeDevice("163.2 x 73.6 x 8.7  mm")
                    .setWeightDevice(197L)
                    .setTypeOfScreen("LTPO Fluid2 AMOLED, 1B colors, 120Hz, HDR10+, 1300 nits (peak)")
                    .setSizeOfScreen(new BigDecimal("6.7"))
                    .setResolutionOfScreen("1440 x 3216")
                    .setCardMemory("няма")
                    .setDeviceStorage("256 GB")
                    .setDeviceRamStorage("8 GB")
                    .setBackCamera("48 MP, f/1.8, 23mm (wide), 1/1.43\", 1.12µm, omnidirectional PDAF, Laser AF, OIS\n" +
                            "8 MP, f/2.4, 77mm (telephoto), 1.0µm, PDAF, OIS, 3.3x optical zoom\n" +
                            "50 MP, f/2.2, 14mm (ultrawide), 1/1.56\", 1.0µm, AF\n" +
                            "2 MP, f/2.4, (monochrome)\n")
                    .setFrontCamera("16 MP, f/2.4, (wide), 1/3.06\", 1.0µm")
                    .setSpeaker("Има")
                    .setHeadphoneSlot("няма")
                    .setBatteryCapacity("4500 mAh");
            DeviceEntity iPhone = new DeviceEntity();
            iPhone.setFirstImageUrl("https://assets.swappie.com/swappie-product-iphone-13-pro-max-sierra-blue-back.png")
                    .setSecondImageUrl("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-pro-gallery-1?wid=4056&hei=2400&fmt=jpeg&qlt=80&.v=1629956757000")
                    .setThirdImageUrl("https://www.xda-developers.com/files/2021/09/Apple-iPhone-13-Pro-Sierra-Blue-Hands-On-Image-1024x1024.jpg")
                    .setFourthImageUrl("https://www.xda-developers.com/files/2021/09/iPhone-13-Pro-XDA-345345klskjf-1024x683.jpeg")
                    .setFifthImageUrl("https://www.apple.com/v/iphone-13-pro/a/images/overview/design/finishes_2_sierra_blue__csj3bqix6x6q_large.jpg")
                    .setName("Apple iPhone 13 Pro Max")
                    .setPrice(new BigDecimal("2700.00"))
                    .setType("5G")
                    .setOperationSystem(OperationSystemType.iOS)
                    .setProcessor("Hexa-core (2x3.22 GHz Avalanche + 4xX.X GHz Blizzard)")
                    .setChipset("Apple A15 Bionic (5 nm)")
                    .setSizeDevice("160.8 x 78.1 x 7.7")
                    .setWeightDevice(240L)
                    .setTypeOfScreen("Super Retina XDR OLED, 120Hz, HDR10, Dolby Vision, 1000 nits (HBM), 1200 nits (peak)")
                    .setSizeOfScreen(new BigDecimal("6.7"))
                    .setResolutionOfScreen("1284 x 2778")
                    .setCardMemory("няма")
                    .setDeviceStorage("256 GB")
                    .setDeviceRamStorage("6 GB")
                    .setBackCamera("12 MP, f/1.5, 26mm (wide), 1.9µm, dual pixel PDAF, sensor-shift OIS\n" +
                            "12 MP, f/2.8, 77mm (telephoto), PDAF, OIS, 3x optical zoom\n" +
                            "12 MP, f/1.8, 13mm, 120˚ (ultrawide), PDAF\n" +
                            "TOF 3D LiDAR scanner (depth)\n")
                    .setFrontCamera("12 MP, f/2.2, 23mm (wide), 1/3.6\"\n" +
                            "SL 3D, (depth/biometrics sensor)\n")
                    .setSpeaker("Има")
                    .setHeadphoneSlot("няма")
                    .setBatteryCapacity("4352 mAh");
            DeviceEntity huawei = new DeviceEntity();
            huawei.setFirstImageUrl("https://s13emagst.akamaized.net/products/29336/29335294/images/res_1a380af9d1e8941b14410e0bc373a2f6.jpg")
                    .setSecondImageUrl("https://cdn.hum3d.com/wp-content/uploads/Huawei/337_Huawei_P40_Pro_Ice_White/Huawei_P40_Pro_Ice_White_1000_0006.jpg")
                    .setThirdImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRozwSAraGN4YFxJVlXMv-mz5ZetJ8OtyeUoQ&usqp=CAU")
                    .setFourthImageUrl("https://digital.bg/root/f/uploads/images/%D0%A1%D0%B2%D0%B5%D1%82%D0%BE%D0%B2%D0%BD%D0%B0_%D0%BF%D1%80%D0%B5%D0%BC%D0%B8%D0%B5%D1%80%D0%B0_%D0%BD%D0%B0_Huawei_P40_Pro_-_%D0%BF%D1%8A%D1%80%D0%B2%D0%B8_%D0%B2%D0%BF%D0%B5%D1%87%D0%B0%D1%82%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F_%D0%BE%D1%82_%D1%84%D0%BB%D0%B0%D0%B3%D0%BC%D0%B0%D0%BD_%D1%81%D0%BC%D0%B0%D1%80%D1%82%D1%84%D0%BE%D0%BD%D0%B0_(15).jpg")
                    .setFifthImageUrl("https://i2.wp.com/www.huaweiupdate.com/wp-content/uploads/2020/03/Huawei-P40-Pro-Broken.jpg?resize=600%2C661&ssl=1")
                    .setName("Huawei P40 Pro")
                    .setPrice(new BigDecimal("1400.00"))
                    .setType("5G")
                    .setOperationSystem(OperationSystemType.Android)
                    .setProcessor("Octa-core (2x2.86 GHz Cortex-A76 & 2x2.36 GHz Cortex-A76 & 4x1.95 GHz Cortex-A55)")
                    .setChipset("Kirin 990 5G (7 nm+)")
                    .setSizeDevice("158.2 x 72.6 x 9 mm")
                    .setWeightDevice(209L)
                    .setTypeOfScreen("OLED, 90Hz, HDR10")
                    .setSizeOfScreen(new BigDecimal("6.58"))
                    .setResolutionOfScreen("1200 x 2640 ")
                    .setCardMemory("NM (Nano Memory), up to 256GB (uses shared SIM slot)")
                    .setDeviceStorage("128 GB")
                    .setDeviceRamStorage("8 GB")
                    .setBackCamera("50 MP, f/1.9, 23mm (wide), 1/1.28\", 1.22µm, omnidirectional PDAF, OIS\n" +
                            "12 MP, f/3.4, 125mm (periscope telephoto), PDAF, OIS, 5x optical zoom\n" +
                            "40 MP, f/1.8, 18mm (ultrawide), 1/1.54\", PDAF\n" +
                            "TOF 3D, (depth)\n")
                    .setFrontCamera("32 MP, f/2.2, 26mm (wide), 1/2.8\", 0.8µm, AF\n" +
                            "IR TOF 3D, (depth/biometrics sensor)\n")
                    .setSpeaker("Има")
                    .setHeadphoneSlot("няма")
                    .setBatteryCapacity("4200 mAh");
            DeviceEntity google = new DeviceEntity();
            google.setFirstImageUrl("https://lh3.googleusercontent.com/jPh-Y-sM_IznsQbOan7z3vEru2IxgxXp1MAw3nQby3b99Q2dDTfyeP3uYa0TuVAAD39SqLbEK1kMh3ikcjaijIgOmNyItAWiV6ut=e365-s0")
                    .setSecondImageUrl("https://lh3.googleusercontent.com/hkX-mL7we8QNFK7CaNLoi0Wf6j8wcGy4I1KB6Y-eMYF758n75iEAQ0wXHEi6NS4hPkhTPO92ABxCDvuJDBb_ZDad5EKFgc_a4YM")
                    .setThirdImageUrl("https://media.carphonewarehouse.com/is/image/cpw2/pixel-6-proWHITE8?$xl-retina$")
                    .setFourthImageUrl("https://techcrunch.com/wp-content/uploads/2021/10/CMC_0454.jpg?w=730&crop=1")
                    .setFifthImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlblaHEZY-lKFapMTQfLJtggelL7eLN6MebQ&usqp=CAU")
                    .setName("Google Pixel 6 Pro")
                    .setPrice(new BigDecimal("1600.00"))
                    .setType("5G")
                    .setOperationSystem(OperationSystemType.Android)
                    .setProcessor("Octa-core (2x2.80 GHz Cortex-X1 & 2x2.25 GHz Cortex-A76 & 4x1.80 GHz Cortex-A55)")
                    .setChipset("Google Tensor (5 nm)")
                    .setSizeDevice("163.9 x 75.9 x 8.9 mm ")
                    .setWeightDevice(210L)
                    .setTypeOfScreen("LTPO AMOLED, 120Hz, HDR10+")
                    .setSizeOfScreen(new BigDecimal("6.71"))
                    .setResolutionOfScreen("1440 x 3120")
                    .setCardMemory("няма")
                    .setDeviceStorage("128 GB")
                    .setDeviceRamStorage("12 GB")
                    .setBackCamera("50 MP, f/1.9, 25mm (wide), 1/1.31\", 1.2µm, Dual Pixel PDAF, Laser AF, OIS\n" +
                            "48 MP, f/3.5, 104mm (telephoto), 1/2\", 0.8µm, PDAF, OIS, 4x optical zoom\n" +
                            "12 MP, f/2.2, 17mm, 114˚ (ultrawide), 1.25µm\n")
                    .setFrontCamera("11.1 MP, f/2.2, 20mm (ultrawide), 1.22µm")
                    .setSpeaker("Има")
                    .setHeadphoneSlot("няма")
                    .setBatteryCapacity("5003 mAh");
            deviceRepository.saveAll(Set.of(samsung,iPhone,oneplus,google,huawei));
        }
    }

    @Override
    public List<DeviceSummaryView> getAllBySearch(String keyword) {
        if(keyword != null) {
            return deviceRepository.searchDevice(keyword).stream().map(this::map).collect(Collectors.toList());
        }
        return deviceRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }
}

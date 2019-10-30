package com.khg.springdemoapp.db;

import com.khg.springdemoapp.configuration.Profiles;
import com.khg.springdemoapp.model.entity.City;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.User;
import com.khg.springdemoapp.model.entity.utils.Rutbe;
import com.khg.springdemoapp.model.repository.CityRepository;
import com.khg.springdemoapp.model.repository.PersonnelRepository;
import com.khg.springdemoapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Profile(Profiles.DEV)
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public void run(String... args) throws Exception {
        // Adding cities
        City city1 = new City("Bursa");
        City city2 = new City("Ankara");
        List<City> cities = Arrays.asList(city1, city2);
        cityRepository.saveAll(cities);

        // Adding personnel
        Personnel personnel1 = new Personnel("123", "Test1", "Test1", cityRepository.findByName("Bursa"), Rutbe.POLIS_MEMURU, true);
        Personnel personnel2 = new Personnel("124", "Test2", "Test2", cityRepository.findByName("Ankara"), Rutbe.KIDEMLI_BASPOLIS_MEMURU, true);
        List<Personnel> personnelList = Arrays.asList(personnel1, personnel2);
        personnelRepository.saveAll(personnelList);

        // Adding users
        User user1 = new User("a", passwordEncoder.encode("a"), "ADMIN", "");
        User user2 = new User("b", passwordEncoder.encode("b"), "USER", "Test1");
        List<User> users = Arrays.asList(user1, user2);
        userRepository.saveAll(users);
    }
}

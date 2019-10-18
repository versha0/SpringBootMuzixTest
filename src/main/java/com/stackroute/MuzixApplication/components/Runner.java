package com.stackroute.MuzixApplication.components;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixAlreadyExists;
import com.stackroute.MuzixApplication.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Runner implements CommandLineRunner {
    private MuzixService muzixService;
    @Value("${in.name}")
    private String name;
    @Value("${in.comment}")
    private String comment;
    public Runner(@Autowired MuzixService muzixService) {
        this.muzixService = muzixService;

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("here");
        Muzix muzix = new Muzix(444, name, comment);
        try {
            muzixService.saveNewMuzix(muzix);
        } catch (MuzixAlreadyExists muzixAlreadyExists) {
            muzixService.updateMuzix(muzix);
        }
    }
}

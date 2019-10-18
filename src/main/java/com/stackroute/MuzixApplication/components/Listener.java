package com.stackroute.MuzixApplication.components;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixAlreadyExists;
import com.stackroute.MuzixApplication.exception.MuzixNotFoundException;
import com.stackroute.MuzixApplication.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Listener implements ApplicationListener<ContextRefreshedEvent> {
    private MuzixService muzixService;
    @Autowired
    public Listener(MuzixService muzixService){
        this.muzixService = muzixService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            muzixService.saveNewMuzix(new Muzix(22, "Listener", "comment"));
        } catch (MuzixAlreadyExists muzixAlreadyExists) {
            try {
                muzixService.updateMuzix(new Muzix(22, "Listener", "comment"));
            } catch (MuzixNotFoundException e) {
                System.out.println("fuck off");
            }
        }
    }
}

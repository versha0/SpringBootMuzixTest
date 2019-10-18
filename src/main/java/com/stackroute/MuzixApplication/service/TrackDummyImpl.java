package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixAlreadyExists;
import com.stackroute.MuzixApplication.exception.MuzixNotFoundException;
import com.stackroute.MuzixApplication.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("dev")
public class TrackDummyImpl implements MuzixService {

    private MuzixRepository muzixRepository;
    @Autowired
    TrackDummyImpl(MuzixRepository muzixRepository){
        System.out.println("created");
        this.muzixRepository = muzixRepository;
    }


    @Override
    public ArrayList<Muzix> getAllMuzix() {
        return (ArrayList<Muzix>) muzixRepository.findAll();
    }

    @Override
    public void updateMuzixByComment(Muzix musix,String comment) {
        musix.setComment(comment);
        System.out.println(comment);
        muzixRepository.save(musix);

    }

    @Override
    public void deleteMuzixById(int id) throws MuzixNotFoundException {
        if(muzixRepository.findById(id).isPresent()) {
            muzixRepository.deleteById(id);
            System.out.println("id to delete");
        } else {
            throw new MuzixNotFoundException("Not found the Muzix");
        }
    }



    @Override
    public Muzix saveNewMuzix(Muzix muzix) throws MuzixAlreadyExists {
        if( muzixRepository.findById(muzix.getId()).isPresent()){
            throw new MuzixAlreadyExists("Already in the database");

        }
        return muzixRepository.save(muzix);
    }

    @Override
    public void updateMuzix(Muzix muzix) throws MuzixNotFoundException {
        if(muzixRepository.findById(muzix.getId()).isPresent()) {
            muzixRepository.save(muzix);
        } else {
            throw new MuzixNotFoundException("Not Found Muzix");
        }
    }

    @Override
    public List<Muzix> trackByName(String name) throws MuzixNotFoundException {
        if(muzixRepository.findTitleByName(name).isEmpty()){
            throw new MuzixNotFoundException("Not found in the database");
        }
        return  muzixRepository.findTitleByName(name);
    }


}

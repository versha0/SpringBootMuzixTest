package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixAlreadyExists;
import com.stackroute.MuzixApplication.exception.MuzixNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface MuzixService {
    public ArrayList<Muzix> getAllMuzix();
    void updateMuzixByComment(Muzix muzix,String comment);
    void deleteMuzixById(int id) throws MuzixNotFoundException;
    public Muzix saveNewMuzix(Muzix muzix) throws MuzixAlreadyExists;
    public void updateMuzix(Muzix muzix) throws MuzixNotFoundException;
    public List<Muzix> trackByName(String name) throws MuzixNotFoundException;

}

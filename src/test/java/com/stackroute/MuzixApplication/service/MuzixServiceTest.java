package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixAlreadyExists;
import com.stackroute.MuzixApplication.repository.MuzixRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MuzixServiceTest {

    private Muzix muzix;

    //Create a mock for UserRepository
    @Mock
    private MuzixRepository muzixRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MuzixServiceImpl muzixService;
    List<Muzix> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        muzix=new Muzix();

        muzix.setName("John");
        muzix.setId(101);
        muzix.setComment("Jenny");

        list = new ArrayList<>();
        list.add(muzix);


    }

    @Test
    public void saveUserTestSuccess() throws MuzixAlreadyExists {

        when(muzixRepository.save((Muzix) any())).thenReturn(muzix);
        Muzix savedMuzix = muzixService.saveNewMuzix(muzix);
        Assert.assertEquals(muzix,savedMuzix);

        //verify here verifies that userRepository save method is only called once
        verify(muzixRepository,times(1)).save(muzix);

    }
//
//    @Test(expected = MuzixAlreadyExists.class)
    @Test
    public void saveUserTestFailure() throws MuzixAlreadyExists {
        when(muzixRepository.save((Muzix) any())).thenReturn(muzix);
        Muzix savedMuzix = muzixService.saveNewMuzix(muzix);
        System.out.println("savedUser" + savedMuzix);
        Assert.assertEquals(muzix,savedMuzix);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }
//
    @Test
    public void getAllUser(){

        muzixRepository.save(muzix);
        //stubbing the mock to return specific data
        when(muzixRepository.findAll()).thenReturn(list);
        List<Muzix> userlist = muzixService.getAllMuzix();
        Assert.assertEquals(list,userlist);
    }
//
//
//    @Test
//    public void getAllMuzix() {
//    }
//
//    @Test
//    public void trackByName() {
//    }
}
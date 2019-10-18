package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Muzix;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest
public class MuzixRepositoryTest {
    @Autowired
    private MuzixRepository muzixRepository;
    private Muzix muzix;

    @Before
    public void setUp()
    {
        muzix=new Muzix();


        muzix.setName("John");
        muzix.setId(101);
        muzix.setComment("Jenny");

    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        muzixRepository.save(muzix);
        Muzix fetchMuzix = muzixRepository.findById(muzix.getId()).get();
        Assert.assertEquals(fetchMuzix,muzix);

    }

    @Test
    public void testSaveUserFailure(){
        Muzix testMuzix = new Muzix(34,"Harry123","jnfkdkkd");
        muzixRepository.save(muzix);
        Muzix fetchMuzix = muzixRepository.findById(muzix.getId()).get();
        Assert.assertNotSame(testMuzix,muzix);
    }
//
    @Test
    public void testGetAllUser(){
        Muzix u = new Muzix(10,"Johny12","jdjsa");
        Muzix u1 = new Muzix(11,"Harry12","jwdnkjdk");
        muzixRepository.save(u);
        muzixRepository.save(u1);

        List<Muzix> list = muzixRepository.findAll();
        Assert.assertEquals("Johny12",list.get(0).getName());




    }
//    @Test
//    public void findTitleByName() {
//    }
}
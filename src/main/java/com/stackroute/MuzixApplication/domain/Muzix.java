package com.stackroute.MuzixApplication.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "versha")

public class Muzix {


  //  @Column(name = "id")
   @Id
    public int id;
  //  @Column(name="name")

    
    String name="";

  //  @Column(name="comment")
    String comment="";

//    public Muzix(int id, String name, String comment) {
//        this.id = id;
//        this.name = name;
//        this.comment = comment;
//    }

//    public Muzix() { }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    @Override
//    public String toString() {
//        return "Muzix{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", comment='" + comment + '\'' +
//                '}';
//    }
}

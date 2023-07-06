//package kz.bitlab.techboot.springsecurityboot.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name = "profiles")
//@Getter
//@Setter
//public class Profile extends BaseModel {
//    @Column(name = "photo")
//    @Lob
//    private byte[] photo;
//
//    @Column(name = "quote")
//    private String quote;
//
//    @Column(name = "achievements")
//    private String achievements;
//
//    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
//    private User user;
//}
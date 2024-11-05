package com.illuminatechain.techtriviaquiz.user;

import com.illuminatechain.techtriviaquiz.common.GenericEnumAttributeConverter;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity

public class Account {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private String email;

    private String userName;

    @Convert(converter = GenericEnumAttributeConverter.class)
    private UserEnums.Gender gender;

    private String phoneNumber;

    private String address;

    private Date userBirth;

    private Timestamp createdAt;

    private Timestamp updatedAt;

//    @Enumerated(EnumType.STRING)
//    private UserEnums.Role role;
//
//    @Enumerated(EnumType.STRING)
//    private UserEnums.Status status;

    private String profileImageUrl;

    private Integer failedLoginCount;

    private Boolean isVerified;

    private Boolean isDeleted;


//    private GenericEnumAttributeConverter genericEnumAttributeConverter;


    public Account(String userId, String password, String email, String userName, UserEnums.Gender gender, String phoneNumber, String address, Date userBirth, Timestamp createdAt, Timestamp updatedAt, String profileImageUrl, Integer failedLoginCount, Boolean isVerified, Boolean isDeleted) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.userName = userName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userBirth = userBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.profileImageUrl = profileImageUrl;
        this.failedLoginCount = failedLoginCount;
        this.isVerified = isVerified;
        this.isDeleted = isDeleted;
    }


    public Account() {
        //asdf
    }


}

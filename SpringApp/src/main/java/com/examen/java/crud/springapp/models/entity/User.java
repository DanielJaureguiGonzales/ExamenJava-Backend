package com.examen.java.crud.springapp.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;

    @Column(name="tx_uid",nullable = false)
    private String tx_uid;

    @Column(name ="tx_user",length = 32,nullable = false)
    private String tx_user;

    @Column(name ="tx_email",length = 32,nullable = false)
    private String tx_email;

    @Column(name ="tx_pass",length = 128,nullable = false)
    private String tx_pass;

    @Column(name = "tx_rol",length = 32,nullable = false)
    private String tx_rol;

    @Column(name = "tx_fullName",length = 64,nullable = true)
    private String tx_fullName;

    @Lob
    @JsonIgnore
    @Column(name = "tx_avatar")
    private byte[] tx_avatar;

    public Integer getAvatarHashCode() {
        return (this.tx_avatar != null) ? this.tx_avatar.hashCode() : null;
    }

    public User() {
    }

    public User(Integer id_user, String tx_uid, String tx_user, String tx_email, String tx_pass, String tx_rol, String tx_fullname, byte[] tx_avatar) {
        this.id_user = id_user;
        this.tx_uid = tx_uid;
        this.tx_user = tx_user;
        this.tx_email = tx_email;
        this.tx_pass = tx_pass;
        this.tx_rol = tx_rol;
        this.tx_fullName = tx_fullName;
        this.tx_avatar = tx_avatar;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getTx_uid() {
        return tx_uid;
    }

    public void setTx_uid(String tx_uid) {
        this.tx_uid = tx_uid;
    }

    public String getTx_user() {
        return tx_user;
    }

    public void setTx_user(String tx_user) {
        this.tx_user = tx_user;
    }

    public String getTx_email() {
        return tx_email;
    }

    public void setTx_email(String tx_email) {
        this.tx_email = tx_email;
    }

    public String getTx_pass() {
        return tx_pass;
    }

    public void setTx_pass(String tx_pass) {
        this.tx_pass = tx_pass;
    }

    public String getTx_rol() {
        return tx_rol;
    }

    public void setTx_rol(String tx_rol) {
        this.tx_rol = tx_rol;
    }

    public String getTx_fullname() {
        return tx_fullName;
    }

    public void setTx_fullname(String tx_fullName) {
        this.tx_fullName = tx_fullName;
    }


    public byte[] getTx_avatar() {
        return tx_avatar;
    }

    public void setTx_avatar(byte[] tx_avatar) {
        this.tx_avatar = tx_avatar;
    }
}

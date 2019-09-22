package nes.welcome2church.po;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_friend")
@GenericGenerator(name = "friend_jpa_uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class)
public class Friend implements Serializable {
    @Id
    @Column(name = "friend_id")
    @GeneratedValue(generator = "friend_jpa_uuid")
    private String friendId;

    @Column(name = "last_name", length = 256)
    @NotBlank(message = "last name should not be empty")
    @Length(min = 2, max = 30, message = "last name should be between 2 and 30")
    private String lastName;

    @Column(name = "middle_name", length = 256)
    @NotBlank(message = "middle name should not be empty")
    @Length(min = 2, max = 30, message = "middle name should be between 2 and 30")
    private String middleName;

    @Column(name = "first_name", length = 256)
    @NotBlank(message = "first name should not be empty")
    @Length(min = 2, max = 30, message = "first name should be between 2 and 30")
    private String firstName;

    @Column(name = "gender", length = 256)
    @NotBlank(message = "gender should not be empty")
    private Integer gender;

    @Column(name = "email", length = 256)
    @NotBlank(message = "email should not be empty")
    @Length(max = 256)
    @Email
    private String email;

    @Column(name = "pic_path", length = 256)
    private String picPath;

    @Column(name = "address", length = 256)
    @Length(max = 256, message = "the length of address is too long")
    private String address;

    @Column(name = "nationality", length = 128)
    @Length(max = 256, message = "the length of nationality is too long")
    private String nationality;

    @Column(name = "hometown", length = 128)
    @Length(max = 128, message = "the length of hometown is too long")
    private String hometown;

    @Column(name = "telNumber", length = 128)
    @Length(max = 128, message = "the length of telephone number is too long")
    private String telNumber;

    @Column(name = "organization", length = 128)
    @Length(max = 128, message = "the length of organization is too long")
    private String organization;

    @Column(name = "occupation", length = 128)
    @Length(max = 128, message = "the length of occupation is too long")
    private String occupation;

    @Column(name = "first_visit_date")
    @CreatedDate
    private Date firstVisitDate;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "age")
    private Integer age;

    @Column(name = "is_christian")
    private Boolean christian;

    @Column(name = "is_interested")
    private Boolean interested;

    //private String[] hobby;
    @Column(name = "is_expired")
    private Boolean expired;

    @Column(name = "reason_to_miami")
    private String reasonToMiami;

    @Column(name = "language", length = 128)
    @NotEmpty(message = "language should not be empty")
    private String language;

    @Column(name = "insert_date")
    @CreatedDate
    private Date insertDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getFirstVisitDate() {
        return firstVisitDate;
    }

    public void setFirstVisitDate(Date firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Boolean getChristian() {
        return christian;
    }

    public void setChristian(Boolean christian) {
        this.christian = christian;
    }

    public Boolean getInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
        this.interested = interested;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getReasonToMiami() {
        return reasonToMiami;
    }

    public void setReasonToMiami(String reasonToMiami) {
        this.reasonToMiami = reasonToMiami;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

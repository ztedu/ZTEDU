package cn.everlook.myweb.persistence.entity.assort.edu.registration;

import java.io.Serializable;
import java.util.Date;

public class ZtStudent implements Serializable {
    private Long ztStudentId;

    private String ztStudentName;

    private String ztStudentIdNumber;

    private Date ztStudentBirthday;

    private String ztStudentSex;

    private String ztStudentNation;

    private String ztStudentPoliticalAppearance;

    private String ztStudentNativePlace;

    private String ztStudentWorkUnit;

    private String ztStudentWorkTel;

    private String ztStudentMobilePhone;

    private String ztStudentHomePhone;

    private String ztStudentEei;

    private String ztStudentMajor;

    private Integer ztStudentLevel;

    private Date ztStudentDateOfExam;

    private String ztStudentRegistrationFee;

    private Integer ztUserId;

    private String ztBuyBooks;

    private String ztIntroducer;

    public Long getZtStudentId() {
        return ztStudentId;
    }

    public void setZtStudentId(Long ztStudentId) {
        this.ztStudentId = ztStudentId;
    }

    public String getZtStudentName() {
        return ztStudentName;
    }

    public void setZtStudentName(String ztStudentName) {
        this.ztStudentName = ztStudentName == null ? null : ztStudentName.trim();
    }

    public String getZtStudentIdNumber() {
        return ztStudentIdNumber;
    }

    public void setZtStudentIdNumber(String ztStudentIdNumber) {
        this.ztStudentIdNumber = ztStudentIdNumber == null ? null : ztStudentIdNumber.trim();
    }

    public Date getZtStudentBirthday() {
        return ztStudentBirthday;
    }

    public void setZtStudentBirthday(Date ztStudentBirthday) {
        this.ztStudentBirthday = ztStudentBirthday;
    }

    public String getZtStudentSex() {
        return ztStudentSex;
    }

    public void setZtStudentSex(String ztStudentSex) {
        this.ztStudentSex = ztStudentSex == null ? null : ztStudentSex.trim();
    }

    public String getZtStudentNation() {
        return ztStudentNation;
    }

    public void setZtStudentNation(String ztStudentNation) {
        this.ztStudentNation = ztStudentNation == null ? null : ztStudentNation.trim();
    }

    public String getZtStudentPoliticalAppearance() {
        return ztStudentPoliticalAppearance;
    }

    public void setZtStudentPoliticalAppearance(String ztStudentPoliticalAppearance) {
        this.ztStudentPoliticalAppearance = ztStudentPoliticalAppearance == null ? null : ztStudentPoliticalAppearance.trim();
    }

    public String getZtStudentNativePlace() {
        return ztStudentNativePlace;
    }

    public void setZtStudentNativePlace(String ztStudentNativePlace) {
        this.ztStudentNativePlace = ztStudentNativePlace == null ? null : ztStudentNativePlace.trim();
    }

    public String getZtStudentWorkUnit() {
        return ztStudentWorkUnit;
    }

    public void setZtStudentWorkUnit(String ztStudentWorkUnit) {
        this.ztStudentWorkUnit = ztStudentWorkUnit == null ? null : ztStudentWorkUnit.trim();
    }

    public String getZtStudentWorkTel() {
        return ztStudentWorkTel;
    }

    public void setZtStudentWorkTel(String ztStudentWorkTel) {
        this.ztStudentWorkTel = ztStudentWorkTel == null ? null : ztStudentWorkTel.trim();
    }

    public String getZtStudentMobilePhone() {
        return ztStudentMobilePhone;
    }

    public void setZtStudentMobilePhone(String ztStudentMobilePhone) {
        this.ztStudentMobilePhone = ztStudentMobilePhone == null ? null : ztStudentMobilePhone.trim();
    }

    public String getZtStudentHomePhone() {
        return ztStudentHomePhone;
    }

    public void setZtStudentHomePhone(String ztStudentHomePhone) {
        this.ztStudentHomePhone = ztStudentHomePhone == null ? null : ztStudentHomePhone.trim();
    }

    public String getZtStudentEei() {
        return ztStudentEei;
    }

    public void setZtStudentEei(String ztStudentEei) {
        this.ztStudentEei = ztStudentEei == null ? null : ztStudentEei.trim();
    }

    public String getZtStudentMajor() {
        return ztStudentMajor;
    }

    public void setZtStudentMajor(String ztStudentMajor) {
        this.ztStudentMajor = ztStudentMajor == null ? null : ztStudentMajor.trim();
    }

    public Integer getZtStudentLevel() {
        return ztStudentLevel;
    }

    public void setZtStudentLevel(Integer ztStudentLevel) {
        this.ztStudentLevel = ztStudentLevel;
    }

    public Date getZtStudentDateOfExam() {
        return ztStudentDateOfExam;
    }

    public void setZtStudentDateOfExam(Date ztStudentDateOfExam) {
        this.ztStudentDateOfExam = ztStudentDateOfExam;
    }

    public String getZtStudentRegistrationFee() {
        return ztStudentRegistrationFee;
    }

    public void setZtStudentRegistrationFee(String ztStudentRegistrationFee) {
        this.ztStudentRegistrationFee = ztStudentRegistrationFee == null ? null : ztStudentRegistrationFee.trim();
    }

    public Integer getZtUserId() {
        return ztUserId;
    }

    public void setZtUserId(Integer ztUserId) {
        this.ztUserId = ztUserId;
    }

    public String getZtBuyBooks() {
        return ztBuyBooks;
    }

    public void setZtBuyBooks(String ztBuyBooks) {
        this.ztBuyBooks = ztBuyBooks == null ? null : ztBuyBooks.trim();
    }

    public String getZtIntroducer() {
        return ztIntroducer;
    }

    public void setZtIntroducer(String ztIntroducer) {
        this.ztIntroducer = ztIntroducer == null ? null : ztIntroducer.trim();
    }
}
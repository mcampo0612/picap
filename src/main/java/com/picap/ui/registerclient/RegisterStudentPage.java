package com.picap.ui.registerclient;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterStudentPage {

    public static final Target FIRST_NAME = Target.the("input from first name")
            .located(By.xpath("//div/input[@id='firstName']"));

    public static final Target LAST_NAME = Target.the(" input last name")
            .located(By.id("lastName"));

    public static final Target EMAIL = Target.the("input email")
            .located(By.xpath("//div/input[@id='userEmail']"));

    public static final Target GENDER = Target.the("btn gender")
            .located(By.xpath("//div[@class='col-md-9 col-sm-12']//input[@name='gender']/../label[contains(text(),'Male')]"));

    public static final Target MOBILE = Target.the("input mobile")
            .located(By.id("userNumber"));

    public static final Target BIRTHDAY = Target.the(" input birthday")
            .located(By.xpath(" //div/input[@id='dateOfBirthInput']"));

    public static final Target LIST_MONTH = Target.the("list from item month")
            .locatedBy((".react-datepicker__month-select"));

    public static final Target ITEM_MONTH = Target.the(" input month")
            .located(By.xpath("//option[. = 'December']"));

    public static final Target LIST_YEARS = Target.the("list from item year")
            .locatedBy((".react-datepicker__year-select"));

    public static final Target ITEM_YEARS = Target.the(" input year")
            .located(By.xpath("//option[. = '1989']"));

    public static final Target ITEM_DAY = Target.the("list from item day")
            .locatedBy((".react-datepicker__day--008:nth-child(6)"));


    public static final Target SELECT_SUBJECT = Target.the(" input select subject")
            .located(By.xpath("//div[@class='subjects-auto-complete__input']/input[@id='subjectsInput']"));

    public static final Target ITEM_SUBJECT = Target.the("list from item subject")
            .located(By.id("react-select-2-option-0"));

    public static final Target HOBBIES = Target.the("select hobbies")
            .located(By.xpath("//div[@class='col-md-9 col-sm-12']//input[@type='checkbox']/../label[contains(text(),'Sports')]"));

    public static final Target CURRENT_ADDRESS = Target.the(" input current address")
            .locatedBy("//div/textarea[@id='currentAddress']");

    public static final Target FILE_UPLOAD = Target.the(" upload file pdf")
            .located(By.id("uploadPicture"));

}

package com.rztk;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.SourceProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class FirstTest extends WebDriverSettings {


    @Test
    public void signUp() {

        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні"));
        driver.findElementByXPath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button").click();


        driver.findElementByXPath("//a[contains(text(),'Зареєструватися')]").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset")));
        driver.findElement(By.id("registerUserName")).sendKeys("Иван");
        driver.findElement(By.id("registerUserSurname")).sendKeys("Бугров");
        driver.findElement(By.id("registerUserPhone")).sendKeys("980000000");


        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String email = "bogrovtest" + n + "@gmail.com";
        String pass = "123456qweR";
        System.out.println(email);
        System.out.println(pass);

        driver.findElement(By.id("registerUserEmail")).sendKeys(email);
        driver.findElement(By.id("registerUserPassword")).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset/div[7]/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]")));
    }

   @Test
   public void signUpFail() {
       driver.manage().window().maximize();
       driver.get("https://rozetka.com.ua/ua/");

       String title = driver.getTitle();
       Assert.assertTrue(title.equals("Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні"));
       driver.findElementByXPath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button").click();


       driver.findElementByXPath("//a[contains(text(),'Зареєструватися')]").click();
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset")));

       driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset/div[7]/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"validation-message ng-star-inserted\"]")));

        String nameFirstErr = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset/div[1]/form-error/p")).getText();
        Assert.assertEquals(nameFirstErr,("Введіть своє ім'я кирилицею"));

        String nameSecondnameErr = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset/div[2]/form-error/p")).getText();
        Assert.assertEquals(nameSecondnameErr,"Введіть своє прізвище кирилицею");

        String telephoneErr = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset/div[3]/form-error/p")).getText();
        Assert.assertEquals(telephoneErr,"Введіть номер мобільного телефону");

        String emailErr = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/user-identification/rz-register/div/form/fieldset/div[4]/form-error/p")).getText();
        Assert.assertEquals(emailErr,"Введіть свою ел. пошту");


    }

}






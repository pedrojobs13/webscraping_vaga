package com.web.webscrapping.service;

import jakarta.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeleniumService {

  private static final String URL = "https://portal.gupy.io/";

  private final ChromeDriver driver;

  @PostConstruct
  void postContruct() {
    gulp();
  }

  private void gulp() {
    //    WebDriverWait waitEntrar = new WebDriverWait(driver, Duration.ofSeconds(40));

    driver.get(URL);

    try {
      WebElement entrar =
          driver.findElement(By.xpath("//button[@class=\"sc-crXcEl fMTMDI sc-88cb810e-3 zFNIZ\"]"));
      entrar.click();
    } catch (NoSuchElementException e) {
      System.out.println("Elemento não encontrado: ");
    }


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//ul[@class=\"sc-a01de6b-0 ypLsU\"]")));

    List<WebElement> descricoes =
        driver.findElements(By.xpath("//ul[@class=\"sc-a01de6b-0 ypLsU\"]"));
    descricoes.forEach(descricaoProdutos -> System.out.println(descricaoProdutos.getText()));
    driver.quit();
  }
}
// driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

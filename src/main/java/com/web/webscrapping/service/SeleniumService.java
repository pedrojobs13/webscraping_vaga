package com.web.webscrapping.service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeleniumService {

  private static final String URL = "https://www.linkedin.com/";

  private final ChromeDriver driver;

  @PostConstruct
  void postContruct() {
    scrape("estagio");
  }

  public void scrape(final String value) {

    driver.get(URL);
    final WebElement entrar = driver.findElement(By.xpath("//input[@id=\"session_key\"]"));
    entrar.sendKeys("pedrolucasgomesdeoliveira13@gmail.com");
    final WebElement senha = driver.findElement(By.xpath("//input[@id=\"session_password\"]"));

    senha.submit();

    waitForIt(3000);
    //    final WebElement words =
    //        driver.findElement(By.xpath("//input[@class=\"sc-84313ed3-61 eZbdmD\"]"));
    //    words.sendKeys(value);
    //    words.submit();
    //
    //    waitForIt(5000);
    //
    //    List<WebElement> descricoes =
    //        driver.findElements(By.xpath("//ul[@class=\"sc-a01de6b-0 ypLsU\"]"));

    //    List<WebElement> valoresProdutos =
    //        driver.findElements(By.xpath("//div[@class=\"a-row a-size-base a-color-base\"]"));
    //
    //    descricoes.forEach(descricaoProdutos -> System.out.println(descricaoProdutos.getText()));
    driver.quit();
  }

  private static void waitForIt(long tempo) {

    try {
      new Thread().sleep(tempo);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void gulp() {

    driver.get(URL);

    final WebElement entrar =
        driver.findElement(By.xpath("//button[@class=\"sc-crXcEl fMTMDI sc-88cb810e-3 zFNIZ\"]"));
    entrar.click();
    waitForIt(3000);
    final WebElement words =
        driver.findElement(By.xpath("//input[@class=\"sc-84313ed3-61 eZbdmD\"]"));
    words.sendKeys("estagiario");
    words.submit();

    waitForIt(5000);

    List<WebElement> descricoes =
        driver.findElements(By.xpath("//ul[@class=\"sc-a01de6b-0 ypLsU\"]"));

    List<WebElement> valoresProdutos =
        driver.findElements(By.xpath("//div[@class=\"a-row a-size-base a-color-base\"]"));

    descricoes.forEach(descricaoProdutos -> System.out.println(descricaoProdutos.getText()));
  }
}

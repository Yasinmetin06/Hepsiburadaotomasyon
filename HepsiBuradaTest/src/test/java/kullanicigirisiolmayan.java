import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class kullanicigirisiolmayan {
    @Test(priority = 1)
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        WebElement aramakısmı = driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        aramakısmı.sendKeys("whiskas kedi maması");
        WebElement aramaenter = driver.findElement(By.xpath("//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']"));
        aramaenter.click();

    }
    @Test(priority = 2)
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.hepsiburada.com/whiskas-kuru-yavru-tavuklu-2-kg-p-HBV00000225BX");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        WebElement ilkmamasepete = driver.findElement(By.xpath("//button[@id='addToCart']"));
        ilkmamasepete.click();
        WebElement cikisbir = driver.findElement(By.xpath("//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']"));
        cikisbir.click();

        WebElement ikincimamasepete = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/form[1]/button[1]"));
        ikincimamasepete.click();
        WebElement cikisiki = driver.findElement(By.xpath("//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']//*[name()='svg']"));
        cikisiki.click();
        WebElement sepetim = driver.findElement(By.xpath("//span[@id='shoppingCart']"));
        sepetim.click();
        WebElement dogrulama = driver.findElement(By.xpath("//span[@class='active_3fZys']"));
        String actualYaziStr= dogrulama.getText();
        String expectedBulunacakKelime="SEÇİLEN ÜRÜNLER (2)";
        Assert.assertTrue(actualYaziStr.contains(expectedBulunacakKelime));



    }
}


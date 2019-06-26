package seleniumimportureadgmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author chala megersa
 * Id:Atr/6239/09
 */

public class SeleniumImportUnreadGmail {
    public static void main(String[] args) throws InterruptedException, IOException{

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("http://mail.google.com");
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("chalamegersa5@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
        Thread.sleep(10000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pass.click();
        pass.sendKeys("meg.damesa");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        Thread.sleep(1000);
        List<WebElement> unread = driver.findElements(By.xpath("//*[@class='zA zE']"));
        System.out.println(unread.size() + " Unread Messages");
        
        try{
            FileWriter fw = new FileWriter("unreadGmail.txt");

            for (WebElement message: unread  ) {
                System.out.println(message.getText());
                fw.write(message.getText()+"\n");

            }
            fw.close();
        }catch(Exception e){   
        }
        System.out.println("unread gmails imported to unreadGmail.txt");
        
    }
}

package drivers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.apache.poi.POIDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class LaunchBrowser {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\saura\\Downloads\\chromedriver_win32\\chromedriver.exe");
		DateFormat formatdate = new SimpleDateFormat("ddMMyyyHHmmss");
		Date systemdate = new Date();
		String dateofsystem = formatdate.format(systemdate);
		System.out.println(dateofsystem);
		
		EdgeOptions edg = new EdgeOptions();
		edg.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(edg);
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--remote-allow-origins=*");
		//ChromeDriver driver = new ChromeDrive(co);
		
		driver.get("https://thehackernews.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='blog-posts clear']//div[1]//a[1]//div[1]//div[2]//h2[1]")).click();
	String head	= driver.findElement(By.xpath("//h1[@class='story-title']//a[1]")).getText();
	
	WebElement image = driver.findElement(By.xpath("//div[@class='post-body']//div[1]//a[1]//img[1]"));
	String imagepath = image.getAttribute("src");
	try {
		URL imageURL = new URL(imagepath);
		BufferedImage saveImage = ImageIO.read(imageURL);
		ImageIO.write(saveImage, "png", new File("D:\\Java\\Workspace\\latest news\\TechNews"+dateofsystem+".png"));
		System.out.println("Image downloaded");
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	String para1	= driver.findElement(By.xpath("//html[1]//body[1]//main[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[5]//p[1]")).getText();
	String para2	= driver.findElement(By.xpath("//html[1]//body[1]//main[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[5]//p[2]")).getText();
	//String para3	= driver.findElement(By.xpath("//p[contains(text(),'Contrary to what they claim on the Google Play Sto')]")).getText();
	//String para4	= driver.findElement(By.xpath("//p[contains(text(),'What is particularly alarming is the large amount ')]")).getText();
	//driver.findElement(By.xpath("//div[@class='post-body']//div[1]//a[1]//img[1]")).getImage();
	System.out.println(head);
	
	
		
		//click on a particular section(using xpath)
		WebDriver driver1 = driver.switchTo().newWindow(WindowType.TAB);
		Actions act = new Actions(driver1);
		driver1.get("https://quillbot.com/");
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
		driver1.findElement(By.xpath("//div[@id='paraphraser-input-box']")).sendKeys(head);
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver1.findElement(By.xpath("//span[contains(text(),'Fluency')]")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver1.findElement(By.xpath("//div[@class='css-1fz2g01']")).click();
		
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.findElement(By.xpath("//button[@aria-label='Copy Full Text']//*[name()='svg']")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String headf	= driver.findElement(By.xpath("//div[@id='paraphraser-output-box']")).getText();
		
		
		driver1.findElement(By.xpath("//div[@id='paraphraser-input-box']")).sendKeys(para1);
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver1.findElement(By.xpath("//span[contains(text(),'Fluency')]")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver1.findElement(By.xpath("//div[@class='css-1fz2g01']")).click();
		
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.findElement(By.xpath("//button[@aria-label='Copy Full Text']//*[name()='svg']")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String paraf1	= driver.findElement(By.xpath("//div[@id='paraphraser-output-box']")).getText();
		
		
		
		System.out.println(headf);
		WebDriver driver2 = driver.switchTo().newWindow(WindowType.TAB);
		driver2.get("https://www.youtube.com/");
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver2.findElement(By.xpath("//input[@id='search']")).click();
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver2.findElement(By.xpath("//input[@id='search']")).sendKeys("barish");
		
		
		  String youtubetxt1 = "barish";
		 
		 //driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[1]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(youtubetxt1);
			
		 String youtubetxt = driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[1]//div[1]//div[2]//b[1]")).getText();
		
		 System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt));
		 
		 
		   String youtubetxt2 =
		 driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[2]//div[1]//div[2]//b[1]")).getText();
		   System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt2));
		    String youtubetxt3 =
		 driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[3]//div[1]//div[2]//b[1]")).getText();
		    System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt3));
		  String youtubetxt4 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[4]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt4));
		  String youtubetxt5 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[5]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt5));
		  String youtubetxt6 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[6]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt6));
		  String youtubetxt7 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[7]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt7));
		  String youtubetxt8 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[8]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt8));
		  String youtubetxt9 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[9]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt9));
		  String youtubetxt10 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[10]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt10));
		  String youtubetxt11 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[11]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt11));
		  String youtubetxt12 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[12]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt12));
		  String youtubetxt13 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[13]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt13));
		  String youtubetxt14 =
		  driver2.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[14]//div[1]//div[2]//b[1]")).getText();
		  System.out.println(String.format ("%s%s",youtubetxt1,youtubetxt14));
		  
		  XWPFDocument document = new XWPFDocument();
		   FileOutputStream out = new FileOutputStream(new File("D:\\Java\\Workspace\\latest news\\TechNews"+dateofsystem+".docx"));
		  XWPFParagraph paragraph = document.createParagraph();
		  XWPFRun run = paragraph.createRun();
		  run.setText("Heading: "+headf+"\n");
		  
		  run.setText("Paragraph1: "+paraf1+"\n");
		  
		  run.setText("Paragraph2: "+para2+"\n");
		  
		 // run.setText("Paragraph3: "+para3+"\n"); 
		  
		 // run.setText("Paragraph4: "+para4+"\n");
		  try { 
		  document.write(out);
		  
		  out.close();
		   } catch (IOException e) { // TODO Auto-generated catch block
		  e.printStackTrace();
		   } 
		  System.out.println("Document created");
		 
		/*
		 * XWPFDocument document = new XWPFDocument(); FileOutputStream out = new
		 * FileOutputStream(new
		 * File("C:\\\\Users\\\\saura\\\\OneDrive\\\\Desktop\\\\testdemo.docx"));
		 * XWPFHeader head = document.createHeader(null); XWPFRun run = head.createRun
		 */
		//driver1.findElement(By.xpath("//div[@id='paraphraser-input-box']")).click();
		//driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//act.keyDown(Keys.CONTROL).sendKeys("a","v");
		//System.out.println(act.keyDown(Keys.CONTROL).sendKeys("a","v"));
		
		
		//driver1.findElement(By.xpath("//div[@id='paraphraser-input-box']")).click();
		//driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//act.keyDown(Keys.CONTROL).sendKeys("a");
		//act.sendKeys("v");
		//Open a new tab using Ctrl + t
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		//Switch between tabs using Ctrl + \t
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		//driver.get("https://www.blogger.com/");
		  
	}
}

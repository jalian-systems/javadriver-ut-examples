/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.jaliansystems.javadriver.examples.fx.ut;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javafx.scene.Scene;
import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchType;

public class LoginStageTest extends JavaFXTest {
	private WebDriver driver;

	@Before
	public void setup() {
		JavaProfile profile = new JavaProfile(LaunchMode.EMBEDDED);
		profile.setLaunchType(LaunchType.FX_APPLICATION);
		driver = new JavaDriver(profile);
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void loginSuccess() throws InterruptedException {
		WebElement user = driver.findElement(By.cssSelector("text-field"));
		WebElement password = driver.findElement(By.cssSelector("password-field"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[text='Login']"));
		user.sendKeys("JavaFX2");
		password.sendKeys("password");
		loginButton.click();
		WebElement messageLabel = driver.findElement(By.id("message"));
		assertEquals("Congratulations!", messageLabel.getText());
	}

	@Test
	public void loginFail() throws InterruptedException {
		WebElement user = driver.findElement(By.cssSelector("text-field"));
		WebElement password = driver.findElement(By.cssSelector("password-field"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[text='Login']"));
		user.sendKeys("JavaFX2");
		password.sendKeys("secret");
		loginButton.click();
		WebElement messageLabel = driver.findElement(By.id("message"));
		assertEquals("Incorrect user or pw.", messageLabel.getText());
	}

	@Override
	protected Scene getScene() {
		LoginStage stage = new LoginStage();
		return stage.createScene();
	}
}

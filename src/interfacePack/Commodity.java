package interfacePack;

import java.util.List;

import org.openqa.selenium.WebElement;

/*
 * This is an interface for modules at test web page
 * 
 * @author Saravanan, Arumugam
 */
public interface Commodity {
	public List<WebElement> toSendList();
	public void toSelect();
	public int totalElements();
	public boolean eachProduct(int i);
}

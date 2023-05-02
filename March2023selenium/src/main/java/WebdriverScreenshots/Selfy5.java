package WebdriverScreenshots;

import java.util.Date;

public class Selfy5 
{
	public static void main(String[] args) 
	{
		Date d = new Date();
		System.out.println(d);
		//converting date to string for elimination of : and space (require for name in screenshot)
		String dt=d.toString().replace(':', '_').replace(' ','_');
		System.out.println(dt);
	}

}

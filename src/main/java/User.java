import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class User
{
	private String userName;
	private int userID;
	private String password;
	private String jobDescription;
	private long logInTime;
	private boolean valid;
	private final static String userFile = "UserFile.txt";

	public User()
	{
		this.userID = 0;
		this.userName = null;
		this.jobDescription = null;
		this.logInTime = 0;
		this.valid = false;
	}

	public User(String name, int id, String job, long time)
	{
		this.userID = id;
		this.userName = name;
		this.jobDescription = job;
		this.logInTime = time;
		this.valid = true;
	}

	public void setUserName(String user)
	{
		this.userName = user;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setUserID(int id)
	{
		this.userID = id;
	}

	public void setJobDescription(String job)
	{
		this.jobDescription = job;
	}

	public void setLogInTime(long time)
	{
		this.logInTime = time;
	}

	public void setValid()
	{
		this.valid = true;
	}

	public boolean getValid()
	{
		return valid;
	}

	public String getJobDescription()
	{
		return jobDescription;
	}

	public boolean checkUser(String userText, String passwd)
	{
		String line;
		Scanner lineScan;

		int uID;
		String uname;
		String pword;
		String job;

		try
		{
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file = new File(classLoader.getResource(userFile).getFile());
			InputStream fileInputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
			Scanner fileScanIn = new Scanner(reader);
			while (fileScanIn.hasNext())
			{
				line = fileScanIn.nextLine();

				lineScan = new Scanner(line);
				lineScan.useDelimiter(",");

				uID = Integer.parseInt(lineScan.next());
				uname = lineScan.next();
				pword = lineScan.next();
				job = lineScan.next();

				if (uname.equalsIgnoreCase("karishma") && pword.equals("abc"))
				{
					this.userID = uID;
					this.userName = uname;
					this.password = pword;
					this.jobDescription = job;
					this.logInTime = System.currentTimeMillis();
					this.valid = true;
				}
			}
			fileScanIn.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The " + userFile + " file was not found.");
		}

		return valid;
	}

	public String toString()
	{
		String retString = "User ID: " + userID + " User name: " + userName + " Job description: " + jobDescription;
		return retString;
	}
}

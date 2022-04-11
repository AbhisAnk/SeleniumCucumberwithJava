package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir") + "\\configs\\Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			//System.out.println("propertyFilePath: "+propertyFilePath);
			try {
				properties.load(reader);
				 reader.close();
				// System.out.println("property loaded");
			} catch (IOException e) {
			//	System.out.println("prop setup error: ");
			 e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//System.out.println("prop catch error: ");
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	
	
	public String getDriverPath(){
		String projectPath = System.getProperty("user.dir");
		String driverPath =   properties.getProperty("driverPath");
		String driver = projectPath + driverPath;
		if(driver!= null) return driver;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		 
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("appURL");
		//System.out.println("url: "+url);
		if(url != null) return url;
		else throw new RuntimeException("appURL not specified in the Configuration.properties file.");
	}
	
	
	public String getBrowserValue(){
		String broswerValue = properties.getProperty("browser");
		if(broswerValue!= null) return broswerValue;
		else throw new RuntimeException("broswerValue not specified in the Configuration.properties file.");		
	}
	
	
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("iexplorer") || browserName.equalsIgnoreCase("edge") ) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	
	public String getSignupUserName() {
		
		String signupID = properties.getProperty("signupID");
		//System.out.println("signupID"+signupID);
		if(signupID != null) return signupID;
		else throw new RuntimeException("signupID not specified in the Configuration.properties file.");
		
	}
	
	
	public String getSingupPassword() {
		
		String signupPassword = properties.getProperty("signupPassword");
		//System.out.println("signupPassword: "+signupPassword);
		if(signupPassword != null) return signupPassword;
		else throw new RuntimeException("signupPassword not specified in the Configuration.properties file.");
		
	}
	
	public String getLoginUserName() {
		
		String loginID = properties.getProperty("loginID");
		//System.out.println("loginID: "+loginID);
		if(loginID != null) return loginID;
		else throw new RuntimeException("loginID not specified in the Configuration.properties file.");
		
	}
	
	
	public String getLoginPassword() {
		
		String loginPassword = properties.getProperty("loginPassword");
		//System.out.println("loginPassword: "+loginPassword);
		if(loginPassword != null) return loginPassword;
		else throw new RuntimeException("loginPassword not specified in the Configuration.properties file.");
		
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) {
		//	System.out.println("reportConfigPath1: "+reportConfigPath);
			return reportConfigPath;
		}
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
}

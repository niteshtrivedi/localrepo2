package org.testing.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class Report {

	public static ExtentReports handleReports()
	{
		ExtentReports extent=new ExtentReports("Filepath.html",false);
		return extent;
	}
}

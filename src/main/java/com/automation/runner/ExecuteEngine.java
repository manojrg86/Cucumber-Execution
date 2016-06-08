package com.automation.runner;

import org.testng.TestNG;

import com.automation.framework.ReportGenerator;
import com.automation.framework.RunCukesByFeatureAndCompositionTest;

public class ExecuteEngine {

	public static void main(String args[]){

		TestNG testNG =new TestNG();
		testNG.setTestClasses(new Class[] { RunCukesByFeatureAndCompositionTest.class });
		testNG.run();
		new ReportGenerator().generateReports();

	}
}

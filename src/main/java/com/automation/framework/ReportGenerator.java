package com.automation.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportGenerator {

	public void generateReports(){
    	File reportOutputDirectory = new File("test-output/reports");
    	List<String> jsonFiles = new ArrayList<String>();
    	jsonFiles.add("./target/cucumber-report-feature-composite.json");

    	String jenkinsBasePath = "";
    	String buildNumber = "1";
    	String projectName = "cucumber-jvm";
    	boolean skippedFails = true;
    	boolean pendingFails = false;
    	boolean undefinedFails = true;
    	boolean missingFails = true;
    	boolean runWithJenkins = false;
    	boolean parallelTesting = false;

    	Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    	// optionally only if you need
    	configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
    	configuration.setParallelTesting(parallelTesting);
    	configuration.setJenkinsBasePath(jenkinsBasePath);
    	configuration.setRunWithJenkins(runWithJenkins);
    	configuration.setBuildNumber(buildNumber);

    	ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    	reportBuilder.generateReports();
    }
}

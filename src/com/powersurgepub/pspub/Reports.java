/*
 * Copyright 2016 - 2016 Herb Bowie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powersurgepub.pspub;

  import com.powersurgepub.psdatalib.textmerge.*;
  import com.powersurgepub.pstextmerge.*;
  import com.powersurgepub.psutils.*;
  import java.io.*;
  import java.util.*;
  import javax.swing.*;

/**
 A collection of reports available within an application. Each report requires
 a matching PSTextMerge script file that can be run in order to generate the 
 report. These script files will retrieved from a folder named 'reports'. If
 an application data folder already contains such a folder, then that folder
 will be used. If not, then the reports will be loaded from the application's 
 resources folder. The first time that any report is executed for a particular
 data collection, the standard reports folder will be copied to the application
 data folder. After this initial copy, the contents of this folder may be 
 customized as needed. 

 @author Herb Bowie
 */
public class Reports {
  
  public static final String REPORTS_FOLDER = "reports";
  
  private TextMergeHarness    textMerge = null;
  
  private JMenu               reportsMenu = null;
  private File                appReportsFolder = null;
  private File                dataReportsFolder = null;
  
  private boolean             dataReportsFolderPopulated = false;
  
  private SortedMap<String, Report>   reports = new TreeMap<String, Report>();
  
  /**
   Construct a new report object. 
  
   @param reportsMenu The report menu under which the list of available
                      reports will be available. 
  */
  public Reports(JMenu reportsMenu) {
    this.reportsMenu = reportsMenu;
    textMerge = TextMergeHarness.getShared();
    textMerge.initTextMergeModules();
  }
  
 
  /**
   Provide a new folder full of application data, which may contain a 
   folder named 'reports'. The reports menu will be re-populated with 
   reports available for this data folder. 
  
   @param dataFolder The application data folder. 
  */
  public void setDataFolder(File dataFolder) {

    dataReportsFolder = new File(dataFolder, REPORTS_FOLDER);
    appReportsFolder = new File(Home.getShared().getAppFolder(), REPORTS_FOLDER);
    reports = new TreeMap<String, Report>();
    reportsMenu.removeAll();
    
    dataReportsFolderPopulated = true;
    
    if (dataReportsFolder.exists()) {
      loadReports (dataReportsFolder);
    }
    
    if (reports.isEmpty()) {
      loadReports (appReportsFolder);
      dataReportsFolderPopulated = false;
    }
    
  }
  
  /**
   Load the reports from the passed folder. 
  
   @param folder The folder to be used. 
  */
  private void loadReports (File folder) {
    if (folder != null && folder.exists() && folder.canRead()) {
      String[] fileNames = folder.list();
      for (String fileName : fileNames){
        File candidate = new File (folder, fileName);
        if (Report.isValidFile(candidate)) {
          Report report = new Report(candidate);
          reports.put(report.getKey(), report);
          JMenuItem menuItem = new JMenuItem(report.getName());
          menuItem.setActionCommand (report.getKey());
          menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              if (! dataReportsFolderPopulated) {
                dataReportsFolderPopulated = FileUtils.copyFolder(appReportsFolder, dataReportsFolder);
              }
              Report selectedReport = reports.get(evt.getActionCommand());
              runReport(selectedReport);
            } // end actionPerformed method
          }); // end add of action listener 
          reportsMenu.add(menuItem);
        } // end if the right kind of file
      } // end for each file in the folder
    } // end if good folder
  } // end loadReports method
  
  /**
   Run the report that has been requested and attempt to open the output 
   in a web browsers window. 
  
   @param report The report to be run. 
  */
  private void runReport(Report report) {
    if (report != null) {
      File reportScript 
          = new File(dataReportsFolder, report.getFileName());
      if (reportScript != null
          && reportScript.exists()
          && reportScript.canRead()) {
        textMerge.playScript(reportScript);
        String reportFileName = textMerge.getOutputFileName();
        File reportFile = new File(reportFileName);
        if (reportFile != null
            && reportFile.exists()
            && reportFile.canRead()) {
          Home.getShared().openURL(reportFile);
        }
      } // end if we have a report script to execute
    } // end if we have a selected report
  }

}

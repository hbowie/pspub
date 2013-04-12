PSPub User Guide
================

Introduction
------------

PSPub provides a standard user interface for publishing a data collection in one or more text-based formats. 

Initial use was for iWisdom. Also used for URL Union.

This class stores data about publications in multiple properties files. One file is stored in the source folder for the data collection, is named "pspub_source_parms.xml", and contains a list of the publish to locations associated with that data collection. Another file is tucked away in each publish to location, with the name "pspub_publication_parms.xml", and with each of these files containing the various properties specified by the user for that particular publication. Note that the source folder and the publish to folder may in fact refer to the same disk location. 

Rights
------

PSPub Copyright &copy; 2011 - 2013 Herb Bowie

LinkTweaker is [open source software][osd]. 

Licensed under the Apache License, Version 2.0 (the &#8220;License&#8221;); you may not use this file except in compliance with the License. You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an &#8220;AS IS&#8221; BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

User Interface
--------------

The following documentation is suitable, with perhaps minor modifications, for inclusion in the user guide for an application making use of the pspub package. 

### Publish

The publish option allows you to easily publish your data collection in an alternate format, such as a Web site or E-Book. 

See [Portable Wisdom](http://www.pagantuna.com/wisdom/index.html) for an example of a Web site that can be produced via this mechanism. 

To begin the publication process, select the **Publish...** command from the **File** menu.

You will then see a window with the following fields available to you. 

<dl>
	<dt>Publish to:</dt>
	
	<dd>You may use the Browse button above and to the right to select a folder on your computer to which you wish to publish your data collection. You may also enter or modify the path directly in the text box. When modifying this field, you will be prompted to specify whether you wish to update the existing publication location, or add a new one. By specifying that you wish to add a new one, you may create multiple publications, and then later select the publication of interest by using the drop-down arrow to the right of this field. </dd>
	
	<dt>Equivalent URL:</dt>
	
	<dd>If the folder to which you are publishing will be addressable from the World-Wide Web, then enter its Web address here. </dd>
	
	<dt>Templates:</dt>
	
	<dd>This is the address of a folder containing one or more publishing templates. This will default to the location of the templates provided along with the application executable. You may use the Browse button above and to the right to pick a different location, if you have your own templates you wish to use for publishing. </dd>
	
	<dt>Select:</dt>
	
	<dd>Use the drop-down list to select the template you wish to use. </dd>
	
	<ul>
	
		<li>E-Book -- This template will produce a file named 'iwisdom.epub'. You can drag and drop this file into iTunes, then sync it with your mobile device in order to access your collection from an iPhone, iPod Touch, or iPad. </li>
		
		<li>Web Site -- This template will produce a Web site that can be browsed from a computer or mobile device. See <a href="http://www.portablewisdom.org">PortableWisdom.org</a> for an example. Note that, if you're a <a href="http://www.me.com">Mobile Me</a> subscriber, you can easily publish to the Sites folder of your iDisk. As an example, the iDisk/Sites/wisdom/ folder on your Mac will be accessible on the Web via URL http://homepage.mac.com/membername/wisdom/.</li>
		
	</ul>
	
	<dt>Apply</dt>
	
	<dd>Press this button to apply the selected template. This will copy the contents of the template folder to the location specified above as the Publish to location. </dd>
	
	<dt>Publish Script:</dt>
	
	<dd>Specify the location of the script to be used. The <a href="http://www.powersurgepub.com/products/pstextmerge.html">PSTextMerge</a> templating system is the primary scripting language used for publishing. A PSTextMerge script will usually end with a '.tcz' file extension.  </dd>
	
	<dt>Publish when:</dt>
	
	<dd>You may specify publication 'On Close' (whenever you Quit the application or close a data collection), 'On Save' (whenever you save the data collection to disk), or 'On Demand'.  </dd>
	
	<dt>Publish Now</dt>
	
	<dd>Press this button to publish to the currently displayed location. Note that, if you've specified 'On Demand', then this is the only time that publication will occur. </dd>
	
	<dt>View:</dt>
	
	<dd>Select the local file location or the equivalent URL location.</dd>
	
	<dt>View Now</dt>
	
	<dd>Press this button to view the resulting Web site in your Web browser.</dd>
	
</dl>

[java]:       http://www.java.com/

[pspub]:      http://www.powersurgepub.com/

[osd]:				http://opensource.org/osd
[apache]:			http://www.apache.org/licenses/LICENSE-2.0.html
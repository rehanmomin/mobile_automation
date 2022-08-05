# Appium Automate UI Framework for Android and iOS Apps with Java

## Overview

### What is Appium? 

Appium is an open source test automation framework for use with native, hybrid and mobile web apps. 
It drives iOS, Android, and Windows apps using the WebDriver protocol. Appium is built on the idea that testing native apps shouldn't require including an SDK or recompiling your app. And that you should be able to use your preferred test practices, frameworks, and tools. Appium also has made design and tool decisions to encourage a vibrant contributing community.

### Why Appium? 

As a test developer it is quite hard to create a good automated test suite that works on the iOS and Android platforms. Both Android and iOS have a couple of different test frameworks that work well but have nothing to do with each other. So you then have to create and maintain two separate test suites, one for Android and one for iOS. They are also written in different languages and with different development tools (IDEs) so even if the applications work the same it is hard to share any code between the tests for the different platforms.
But this is where Appium comes in. From Appium's own website:

Appium is “cross-platform”: it allows you to write tests against multiple platforms (iOS, Android), using the same API. This enables code reuse between iOS and Android testsuites.


## System Requirements

# Prerequisite Requirement:
MacOS/Linux/Windows Download and install:-
Java : https://www.oracle.com/java/technologies/downloads/
Android Studio : https://developer.android.com/studio
Xcode : Install Xcode from appStore
Appium : https://github.com/appium/appium-desktop/releases/tag/v1.22.0
IntelliJ Idea : https://www.jetbrains.com/idea/download/

# Environment Setup:

## Linux/MacOS add Java_Home(Java8 or onward) & Android_Home in .bashrc file:
	export JAVA_HOME=/usr/java/<your version of java>
	export PATH=${PATH}:${JAVA_HOME}/bin

	export ANDROID_HOME=$HOME/Android/Sdk
	export PATH=$PATH:$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

## Windows JAVA_HOME & ANDROID_HOME setup:
	1. Right-click the My Computer icon on your desktop and select Properties.
	2. Click the Advanced tab, then click the Environment Variables button.
	3. Under System Variables, click New.
	4. Enter the variable name as JAVA_HOME.
	5. Enter the variable value as the installation path for the Java Development Kit.
	6. Click OK.
	7. Click Apply Changes.

	1. Right-click on ‘My Computer’ and select Properties. Go to Advanced system settings and select ‘Environmental Variables’ option.
	2. Under the User Variable table, click New to open New User Variable dialog.
	3. Put ANDROID_HOME as Variable name and provide the path of the SDK folder next to Variable value.
	4. Click OK to close the dialog box.
	5. Go to the folder where SDK has been installed.
	6. Inside the SDK folder look for ‘tools’ and ‘platform-tools’ folder.
	7. Copy the path for both tools and platform-tools.
	8. Open ‘Environmental Variables’ dialog box.
	9. Go to System Variables table and locate the Path variable.
	10. Edit the path variable from ‘Edit system Variables’ dialog box.
	11. Add the ‘tools’ and platform-tools’ folder’s full path, as shown below.

# GIT Clone project: git clone https://github.com/hubilo/Mobile_Automation.git
	Start IntelliJ Idea > Open Project > Mobile_Automation and wait for all dependencies get loaded.


# Add dependencies to maven POM.xml > 
	<dependencies>
		<dependency>
		<groupId>io.appium</groupId>
		<artifactId>java-client</artifactId>
		<version>7.6.0</version>
		</dependency>
		<dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>7.5</version>
		</dependency>
		<dependency>
		<groupId>commons-io</groupId>
		<artifactId>commons-io</artifactId>
		<version>2.11.0</version>
		</dependency>
		<dependency>
		<groupId>io.rest-assured</groupId>
		<artifactId>rest-assured</artifactId>
		<version>4.4.0</version>
		</dependency>
		<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
		<version>2.13.0</version>
		</dependency>
		<dependency>
		<groupId>com.googlecode.json-simple</groupId>
		<artifactId>json-simple</artifactId>
		<version>1.1.1</version>
		</dependency>
		<dependency>
		<dependency>
		<groupId>com.jayway.jsonpath</groupId>
		<artifactId>json-path</artifactId>
		<version>2.7.0</version>
		</dependency>
		<dependency>
		<groupId>javax.annotation</groupId>
		<artifactId>javax.annotation-api</artifactId>
		<version>1.3.2</version>
		</dependency>
		<dependency>
		<groupId>log4j</groupId>
		<artifactId>log4j</artifactId>
		<version>1.2.17</version>
		</dependency>
		<dependency>
		<groupId>io.qameta.allure</groupId>
		<artifactId>allure-testng</artifactId>
		<version>${allure-testng-version}</version>
		</dependency>
	</dependencies>

# Add TestNG configuration to Maven POM.xml>
Plugin configuration {
	<configuration>
		<suiteXmlFiles>
		<suiteXmlFile>TestNG.xml</suiteXmlFile>
		</suiteXmlFiles>
	</configuration>

# How to Run > 
	start Appium Server.
		Simulator/Emulator/real device should online
		add deviceId to /src/main/resources/jsonfiles/Appium_Config.json
		Go to the project Home path and run command line **mvn clean test**




# Serenity JUnit Starter project


This is the simplest possible build script setup for Serenity BDD using Java.

This is a very minimal sample project using JUnit and Serenity BDD in Java.
You can use this project as a quick starting point for your own projects.

## Get the code

Git:

    git clone https://github.com/serenity-bdd/serenity-junit-com.git
    cd serenity-junit-com


Or simply [download a zip](https://github.com/serenity-bdd/serenity-junit-starter/archive/master.zip) file.

## Use Maven

Open a command window and run:

    mvn clean verify

## Use Gradle

Open a command window and run:

    gradlew test -Denvironment=qa
    gradlew test -Denvironment=pre

## Running tests by tags     

    ./gradlew clean test -Dtags='login' -Denvironment=qa

## Run in firefox

    ./gradlew clean test -Pwebdriver.driver=firefox


## Run in Remote - Selenoid

    ./gradlew clean test -Dtags='login' -Denvironment=qa -Dwebdriver.remote.url=http://52.167.170.77:4444/wd/hub -Dwebdriver.remote.driver=chrome -Dserenity.driver.capabilities=enableVNC:true -Dwebdriver.remote.timeouts.implicitlywait=30000 -Dwebdriver.remote.timeouts.fluentwait=10000


## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!


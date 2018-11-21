-------------------------Build & Run---------------------------

Tag Feature Run
    
    `mvn clean install -Dtag=@journey_casestudy -f parallelpom.xml`

All Feature Single Run 
     
    mvn test -Dcucumber.options="classpath:features/"

All Feature Parallel Run

    mvn clean install -DforkCount=5

Travis-CI Latest Build&Run
    
    https://travis-ci.com/yalcingunal/acceptance-test/builds/92165010


-------------------------Configuration---------------------------

UsingSeleniumGrid

   `true`  Getting browser session from SeleniumGrid Hub
            
            Selenium Grid Url   : http://46.101.144.215:4444/wd/hub
            Zalenium Dashboard  : http://46.101.144.215:4444/dashboard/#
            
   
   `false`  Getting browser session from local webdriver
   
            Chrome v69-71
            src/test/resources/drivers
                               ../linux
                               ../windows
                               ../mac os
                               
---------------------------Report--------------------------------

            ../target/TrackMergeReport/donut-report.html       
set projectLocation=E:\SELENIUMSCRIPT\ExerciseFrameworkWebDriverTestNGJava
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\library\*
java org.testng.TestNG %projectLocation%\FinalRelease.xml
pause
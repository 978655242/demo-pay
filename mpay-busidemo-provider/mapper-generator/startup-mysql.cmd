@echo off

echo start to generate mapper ......
set "CURRENT_DIR=%cd%"
set "EXEC_JAR=%CURRENT_DIR%/lib/framework-mapper-generator-1.0.0-RELEASE.jar"
set "CONFIG_PATH=%CURRENT_DIR%/conf/generatorConfig-mysql.xml"
java -jar %EXEC_JAR% %CONFIG_PATH%

if %errorlevel% == 0 echo mapper generate successfully, press any key to exit.
if %errorlevel% == 1 echo mapper generate failed.
pause

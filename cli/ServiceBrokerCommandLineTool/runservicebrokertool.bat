{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fnil\fcharset0 Courier New;}{\f1\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1507;}\viewkind4\uc1\pard\f0\fs20 @echo off\par
set JAVA_HOME="C:\\Program Files\\Java\\jdk1.5.0_06"\par
set EXTRA="C:\\Program Files\\Coadunation\\lib\\jacorb.jar;C:\\Program Files\\Coadunation\\lib\\log4j-1.2.13.jar;C:\\Program Files\\Coadunation\\lib\\logkit-1.2.jar;C:\\Program Files\\Coadunation\\lib\\CoadunationClient.jar;C:\\Program Files\\Coadunation\\clientlib\\ServiceBrokerClient.jar;"\par
set JAVA="C:\\Program Files\\Java\\jre1.5.0_06/bin/java"\par
set JAVA_OPTS=-Dcoad.config=com.rift.coad.lib.configuration.xml.XMLConfigurationFactory\par
set JAVA_OPTS=%JAVA_OPTS% -Dxml.config.path="C:\\Program Files\\Coadunation/etc/config.xml"\par
set JAVA_OPTS=%JAVA_OPTS% -DLog.File="C:\\Program Files\\Coadunation/etc/log4j.properties"\par
set JAVA_OPTS=%JAVA_OPTS% -Djava.security.policy=="C:\\Program Files\\Coadunation/etc/server.policy"\par
set JAVA_OPTS=%JAVA_OPTS% -Djava.security.manager\par
set JAVA_OPTS=%JAVA_OPTS% -Djava.rmi.server.RMIClassLoaderSpi=com.rift.coad.RemoteClassLoaderSpi\par
set CURRENT_DIR=./\par
set COAD_LIB_DIRS=C:\\Program Files\\Coadunation/lib;C:\\Program Files\\Java\\jdk1.5.0_06/lib/tools.jar;\par
                                                                                                                     \par
echo %JAVA% %JAVA_OPTS% -Xmx128M -cp %EXTRA% -jar "C:\\Program Files\\Coadunation/tools/ServiceBrokerCommandLineTool.jar" glynn:2000 java:network/env/glynn/ServiceBroker -r -s bob -j here\par
%JAVA% %JAVA_OPTS% -Xmx128M -cp %EXTRA% -jar "C:\\Program Files\\Coadunation/tools/ServiceBrokerCommandLineTool.jar" glynn:2000 java:network/env/glynn/ServiceBroker -r -s bob -j here\f1\par
}
 
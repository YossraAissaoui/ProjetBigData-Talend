%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-jcl-2.13.2.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-lang-2.6.jar;../lib/commons-logging-1.1.3.jar;../lib/bcprov-jdk15on-1.68.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/crypto-utils-0.31.12.jar;../lib/ojdbc8-19.3.0.0.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/hsqldb.jar;../lib/ucanaccess-2.0.9.5.jar;../lib/jackcess-encrypt-2.1.4.jar;../lib/talend-ucanaccess-utils-1.0.0.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/jackcess-2.1.12.jar;../lib/jxl.jar;../lib/talend-oracle-timestamptz.jar;../lib/trove.jar;job03_organization_dim_0_1.jar; projetdatav1.job03_organization_dim_0_1.Job03_Organization_Dim %*

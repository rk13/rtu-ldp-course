#!/bin/sh

java -cp ".:bin:lib/hibernate3.jar:lib/mappings.jar:lib/commons-logging.jar:lib/log4j.jar:lib/mysql-connector-java-5.0.7-bin.jar:lib/dom4j-1.6.1.jar:lib/commons-collections-2.1.1.jar:lib/cglib-2.1.3.jar:lib/asm.jar:lib/jta.jar:lib/project.jar" lv.rtu.vladkoto.test.App  > run.log


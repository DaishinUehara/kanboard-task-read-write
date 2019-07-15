@ECHO OFF

chcp 65001
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8
java -jar target\kb-task-read-write-0.0.1-SNAPSHOT-jar-with-dependencies.jar %1 %2

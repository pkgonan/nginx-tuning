#!/usr/bin/env bash

if [ -n "$JMX_OPTS" ]; then
        IP_ADDR=`curl -s http://169.254.169.254/latest/meta-data/local-ipv4`
        var_jmx_opts="$JMX_OPTS"" -Djava.rmi.server.hostname=""$IP_ADDR"
fi


AGENT_ID=`wget -q -O - http://169.254.169.254/latest/meta-data/instance-id`

JAVA_OPTS="$JAVA_OPTS -javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.0.jar"
JAVA_OPTS="$JAVA_OPTS -Dpinpoint.agentId=$AGENT_ID"
JAVA_OPTS="$JAVA_OPTS -Dpinpoint.applicationName=nginx-tuning"


exec java $JAVA_OPTS $var_jmx_opts \
    -Duser.timezone=Asia/Seoul \
    -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE \
    -Dsentry.environment=$SPRING_PROFILES_ACTIVE \
    -Dsentry.servername=nginx-tuning \
    -Dsentry.release=0.0.0 \
    -jar nginx-tuning-0.0.0.jar

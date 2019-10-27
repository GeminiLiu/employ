DATE=$(date +%Y%m%d%H%M%S)
export JAVA_HOME PATH CLASSPATH
JAVA_HOME=/usr/local/java/jdk8
PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH
CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib:$CLASSPATH

DIR=/root/market
JARFILE=*.jar
JVM="-Xms256m -Xmx1024m"

if [ ! -d $DIR/backup ];then
  mkdir -p $DIR/backup
fi
echo "init success!!"
cd $DIR

ps -ef | grep .jar | grep -E 'service-|single-' | grep java | grep -v grep | awk '{print $2}' | xargs kill -9
echo "stop success!!"

mkdir backup/$DATE
mv $JARFILE backup/$DATE/
echo "backup success!!"

mv -f $DIR/in/sub/$JARFILE .
echo "move jar success!!"

rm -rf *.log
echo "delete log success!!"

startProject(){
  echo "-----------------------"
  echo "start-->"$1"......."
  echo "profile-->"$2"......."
	
#  JVM_OPT="-Djava.ext.dirs="$JAVA_HOME"/jre/lib/ext:./in/common"
#  echo "jvm-opt-->"$JVM_OPT
  echo "jvm-->"$JVM
	
  eurekaJar=$(ls|grep eureka|grep .jar)
  java -jar $JVM $1 --spring.profiles.active=$2> ${1/.jar/.log} &
  sleep 1
}

waitStart(){
  logName=${1/.jar/.log}
  echo $1" find log ......."
  while [ -f $logName ]
    do
      result=$(grep "Tomcat started on port" $logName)
      errorRes=$(grep "Caused by:" $logName)
      if [[ "$result" != "" ]]
      then
        echo " Started ......."
        break
      elif [[ "$errorRes" != "" ]] 
      then
        echo " Exception ......."
        break
      else
        echo " running ......."
        sleep 3
      fi
    done
}

otherJars=$(ls | grep .jar | grep -E 'service-|single-' | grep -v config | grep -v eureka)
for jar in $otherJars
do
  startProject $jar "pro"
  waitStart $jar
done

#保留近5次备份，其余删除
cd backup/
ls -lt|awk 'NR>5{print $NF}'|xargs rm -rf

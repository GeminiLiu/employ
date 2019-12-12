############# NEED TO CHANGE ################
if [ "$1" ]; then
  PROJEC_NAME=$1
else
  PROJEC_NAME="employ"
fi

if [ "$2" ]; then
  ENV=$2
else
  ENV="dev"
fi

if [ "$3" ]; then
  JVM=$3
else
  JVM="-server -XX:CICompilerCount=2 -XX:+UseG1GC -XX:ConcGCThreads=1 -XX:ParallelGCThreads=4 -Xms256m -Xmx2048m -Xmn128m -XX:+ExplicitGCInvokesConcurrent"
fi

############################

DATE=$(date +%Y%m%d%H%M%S)
export JAVA_HOME PATH CLASSPATH
JAVA_HOME=/usr/local/java/jdk8
PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH
CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib:$CLASSPATH

JARFILE=$PROJEC_NAME".jar"
HOME="/home/viewinter/project"
DIR=$HOME"/"$PROJEC_NAME

if [ ! -d $DIR/backup ];then
  mkdir -p $DIR/backup
fi
mkdir -p $HOME/in
echo "init success!!"
cd $DIR

ps -ef | grep $JARFILE | grep java | grep -v grep | awk '{print $2}' | xargs kill -9
echo "stop success!!"

mkdir backup/$DATE
mv $JARFILE backup/$DATE/
echo "backup success!!"

mv -f $HOME/in/$JARFILE .
echo "move jar success!!"

rm -rf *.log
echo "delete log success!!"

startProject(){
  echo "-----------------------"
  echo "start-->"$1"......."
  echo "profile-->"$ENV
  echo "jvm-->"$JVM
	
  java -jar $JVM $1 --spring.profiles.active=$ENV> ${1/.jar/.log} &
  sleep 1
}

waitStart(){
  logName=${1/.jar/.log}
  echo $1" find log ......."
  while [ -f $logName ]
    do
      result=$(grep "Started ServiceApplication in" $logName)
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

export MALLOC_ARENA_MAX=1
#eurekaJar=$(ls|grep eureka|grep .jar)
startProject $JARFILE
waitStart $JARFILE

echo "success!!"

#leave the last 5 bak files and remove other
cd backup/
ls -lt|awk 'NR>5{print $NF}'|xargs rm -rf

echo "end!!"
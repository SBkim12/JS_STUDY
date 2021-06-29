//로그 관리하기
const winston = require("winston");
const winstonDaily = require("winston-daily-rotate-file"); //로그파일 일자별 생성
const appRoot = require("app-root-path"); // app root 경로를 가져오는 lib
const process = require("process");

const logDir = `${appRoot}/logs`; //logs 디렉토리 하위에 로그 파일 저장

const { combine, timestamp, label, printf } = winston.format;

const logFormat = printf(({ level, message, label, timestamp }) => {
  return `${timestamp} [${label}] ${level}: ${message}]`; // log 출력 포멧 정의
});

// Log level
// error:0, warn: 1, info: 2, http: 3, verbose: 4, debug:5, silly:6
const logger = winston.createLogger({
  //level, message는 자동으로 입력되므로
  //label과 timestamp의 정의가 필요함
  format: combine(
    label({
      label: "LogTestSystem", //System Name
    }),
    timestamp({
      format: "YYYY-MM-DD HH:mm:ss",
    }),
    logFormat // log 출력 포멧
  ),
  transports: [
    // info 로그를 저장할 파일 설정
    new winstonDaily({
      level: "info", //info 레벨(2)보다 높은(0,1)을 관리하도록함
      datePattern: "YYYY-MM-DD",
      dirname: logDir,
      filename: `%DATE%.log`,
      maxFiles: 30, //30일치 로그 파일 저장
      zippedArchive: true,
    }),
    //error 레벨 로그를 저장할 파일 설정
    new winstonDaily({
      level: "error", // info에 error도 포함되어 있지만 따로 빼서 또 관리
      datePattern: "YYYY-MM-DD",
      dirname: logDir,
      filename: `%DATE%.error.log`,
      maxFiles: 30,
      zippedArchive: true,
    }),
  ],
  exceptionHandlers: [
    //uncaughtException 발생시
    new winstonDaily({
      level: "error",
      datePattern: "YYYY-MM-DD",
      dirname: logDir,
      filename: `%DATE%.exception.log`,
      maxFiles: 30,
      zippedArchive: true,
    }),
  ],
});

// Production 환경이 아닌경우(dev 등) => 콘솔에도 추가로 찍어줌
if (process.env.NODE_ENV !== "production") {
  logger.add(
    new winston.transports.Console({
      format: winston.format.combine(
        winston.format.colorize(), //색깔 넣어서 출력
        winston.format.simple() //`${info.level}: ${info.message} JSON.stringfy({...rest})` 포맷으로
      ),
    })
  );
}

module.exports = logger;

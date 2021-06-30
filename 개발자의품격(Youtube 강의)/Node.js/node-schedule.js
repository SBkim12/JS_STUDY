//node.js로 스케쥴링 동작시키기

//node-schedule을 통한 스케쥴링
const schedule = require("node-schedule");

let scheduleObj = null;

const set = (s) => {
  const rule = new schedule.RecurrenceRule();
  rule.dayOfWeek = s.dayOfWeek;
  rule.hour = s.hour;
  rule.minute = s.minute;

  //실행 내용
  const job = schedule.scheduleJob(rule, function () {
    console.log("Scheduler has excecuted");
  });

  scheduleObj = job;
};

//이전에 있던 스케쥴 초기화(계속 만들기만하면 스케쥴이 계속 축적됨)
//여러개있을경우 리스트에 넣어서 관리
const cancel = () => {
  if (scheduleObj != null) {
    scheduleOBj.cancel();
  }
};

const setSchedule = (s) => {
  cancel();
  set(s);
};

//테스트 데이터
const scheduleData = {
  dayOfWeek: [4, 5], //목요일(4), 금요일(5)
  hour: 1,
  minute: 43,
};

//프로그램 실행
setSchedule(scheduleData);

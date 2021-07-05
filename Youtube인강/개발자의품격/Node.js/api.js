//node.js를 통한 간단한 api 서버 구현

//uuid-apikey => API 키를 생성해주는 모듈
const uuidAPIKey = require("uuid-apikey");
//서버 구축 모듈
const express = require("express");
const app = express();

const server = app.listen(3001, () => {
  console.log("start Server : localhost:3001");
});

const key = {
  apiKey: "0GVZRF5-EPW4T6Z-JDAGHM3-H2J8Z4Q",
  uuid: "0437fc3c-75b8-4d1b-9355-08d088a48f92",
};

//콜론이 있는 path에는 어떤 값이든 들어올수 있다.
//콜론 path에 들어오는 값을 파라미터로 받을수 있다.
app.get("/api/sales/:apikey/:year", async (req, res) => {
  let { apikey, year } = req.params;

  //api키 체크
  if (!uuidAPIKey.isAPIKey(apikey) || !uuidAPIKey.check(apikey, key.uuid)) {
    res.send("apikey is not valid.");
  }

  if (year == "2019") {
    let data = [
      { product: "반도체", amount: 20282028 },
      { product: "반도체", amount: 20282029 },
    ];
    res.send(data);
  } else if (year == "2020") {
    let data = [
      { product: "반도체", amount: 20282030 },
      { product: "반도체", amount: 20282031 },
    ];
    res.send(data);
  } else {
    res.send("Type is not correct.");
  }
  console.log(type);
  res.send("ok");
});

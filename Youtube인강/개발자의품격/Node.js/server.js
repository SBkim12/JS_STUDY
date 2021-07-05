//localhost 서버 열어서 사용하기

//express module 설치 - npm install express --save
const express = require("express");
const app = express();

const server = app.listen(3000, () => {
  console.log("Start Server : localhost:3000");
});

//app 설정
//ejs 사용 전 설치 - npm install ejs --save
//__dirname => 현재 폴더
app.set("views", __dirname + "/views");
//ejs => embedded javascript tempalte(jsp와 비슷함)
app.set("view engine", "ejs");
app.engine("html", require("ejs").renderFile);

app.get("/", function (req, res) {
  res.render("index.html");
});

app.get("/about", function (req, res) {
  res.render("about.html");
});

//서버와 DB의 연동
//mysql module 설치 npm install mysql --save
var mysql = require("mysql");
var pool = mysql.createPool({
  host: "host",
  user: "id",
  password: "pwd",
  database: "DB명",
});

app.get("/db", function (req, res) {
  pool.getConnection(function (err, connection) {
    if (err) throw err; // not connected!

    // Use the connection
    connection.query(
      "SELECT * from EPL_TEAMS",
      function (error, results, fields) {
        res.send(JSON.stringify(results));
        console.log("results", results);

        connection.release();

        if (error) throw error;
      }
    );
  });
});

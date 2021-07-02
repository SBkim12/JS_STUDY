//node.js로 메일 보내기

//mailtrap.io - 메일 테스트 사용시 사용하는 사이트
//npm 필요한도구 -> 구글 검색해서 사용하기
//node 실행법 - node ***.js
const nodemailer = require("nodemailer");
const email = {
    host: "smtp.mailtrap.io",
    port: 2525,
    auth: {
        user: "8f41704fd6cf83",
        pass: "b493ad6e0d9ce3",
    },
};

const send = async (option) => {
    nodemailer.createTransport(email).sendMail(option, (error, info) => {
        if (error) {
            console.log(error);
        } else {
            console.log(info);
            return info.response;
        }
    });
};

let email_data = {
    from: "wleo5924@gmail.com",
    to: "mar5924@naver.com",
    subject: "node.js에서 nodemailer로 메일 보내기 - 제목",
    html: "<h2>test</h2>"
};

send(email_data);

//js041_today.js

let dateBtnNode = document.querySelector("button");

dateBtnNode.onclick = () => {
  let pNode = document.querySelector("p");

  //날짜는 무조건 new로 객체생성을 해야한다.
  let today = new Date();
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  let date = today.getDate();
  let hour = today.getHours();
  let minute = today.getMinutes();
  let second = today.getSeconds();

  pNode.innerText = `${year}-${month}-${date} ${hour}:${minute}:${second}`;
};

// let arr = [1, 2, 3];
// let obj = { a: 1, b: 2 };

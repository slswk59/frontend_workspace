// js044_propagation.js

document.querySelector(".red").onclick = (e) => {
  alert("red");
  e.stopPropagation();
};

document.querySelector(".green").onclick = (e) => {
  alert("green");
  e.stopPropagation();
};

document.querySelector(".blue").onclick = (e) => {
  alert("blue");
  e.stopPropagation();
};

document.querySelector("a").onclick = (e) => {
  alert("안녕하세요");
  //   e.preventDefault();
  return false;
};

/*
[1] Event Progapation (이벤트 전파)
 캡쳐링(capturing phase) : 부모요소에서 Target요소로
 이벤트 전파
 버블링(bubling phase) : Target요소에서 부모요소로 이벤트 전파

[2] 이벤트 차단
 stoPropagation()

[3] stopPropagation() 와 proventDafault() 비교
   stopPropagation() : 이벤트 전파 차단 return false
   (jQuery)
   proventDafault() : 디폴트 이벤트 차단 retrun flase
   (javascript, jQuery)

   https://www.w3schools.com/jsref/envent_preventdefault.asp
   https://developer.mozilla.org/en-US/docs/Wep/API/Event/stopPropagation
*/

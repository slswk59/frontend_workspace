//js042_checkbox_2.js

//Array Function에서 this는 브라우저 최상위 객체인 Window를 의미한다.

let allcheckNode = document.frm.allcheck;
document.frm.allcheck.ocnclick = () => {
  //console.log(this);

  document.frm.subject1.checked = allcheckNode.checked;
  document.frm.subject2.checked = allcheckNode.checked;
  document.frm.subject3.checked = allcheckNode.checked;

}; //////////////////////////////////////

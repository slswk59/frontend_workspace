//js036_dom.js

let myNode = document.getElementById("p2");
// <p id="p2">content2</p>
console.log(myNode);
// myNode: [object HTMLParagraphElement]
console.log(`myNode: ${myNode}`);

////////////////////////////////////////////
let ptNode = myNode.parentNode;
//div#wrap
console.log(ptNode);
// ptNode: [object HTMLDivElement]
console.log(`ptNode: ${ptNode}`);

myNode.style.color = "blue";
///////////////////////////////////////////
// previousSibling : 모든
let prevNode = myNode.previousSibling;
console.log(`prevNode:${prevNode}`);

prevNode = prevNode.previousSibling;
console.log(prevNode); //p#p1
//prevNode:[object HTMLParagraphElement]
console.log(`prevNode:${prevNode}`);
/////////////////////////////////////////////
// previousElementSibling : element node 만 검색한다.
let prevElementNode = myNode.previousElementSibling;
//<p id="p1">content1</p>
console.log(prevElementNode);
//[object HTMLParagraphElement]
console.log(`${prevElementNode}`);

///////////////////////////////////////////////
// nextSibling
let nextNode = myNode.nextSibling;
//[object Text]
console.log(`${nextNode}`);

nextNode = nextNode.nextSibling;
//<p id="p3">content3</p>
console.log(nextNode);
//[object HTMLParagraphElement]
console.log(`${nextNode}`);

////////////////////////////////////////////
//nextElementSibling
let nextElementSibling = myNode.nextElementSibling;
//[object HTMLParagraphElement]
console.log(`${nextElementSibling}`);

//////////////////////////////////////////
//childNode

let divNode = document.getElementById(`wrap`);
//[object HTMLDivElement]
console.log(`${divNode}`);

let divChilesNode = divNode.childNodes;
//[object NodeList]
console.log(`${divChilesNode}`);
//NodeList(9) [text, p#p1, text, p#p2, text, p#p3, text, p#p4, text]
console.log(divChilesNode);

////////////////////////////////////////////
//childrn
let divChildren = divNode.children;
//[object HTMLCollection]
console.log(`${divChildren}`);
//HTMLCollection(4) [p#p1, p#p2, p#p3, p#p4, p1: p#p1, p2: p#p2, p3: p#p3, p4: p#p4]
console.log(divChildren);

let p4Node = document.querySelector("#p4");
//<p id="p4">
console.log(p4Node);
//[object HTMLParagraphElement]
console.log(`${p4Node}`);

let aNode = p4Node.firstElementChild;
//<img src="images/gosu.jpg" alt="영화배우">
console.log(aNode);
//[object HTMLImageElement]
console.log(`${aNode}`);

/////////////////////////////////////////
// 객체.getAttribute('속성명'),   객체.setAttribute('속성명','값')
// 객체.속성명,   객체.속성명 ='값'

let aAttrNode = aNode.getAttribute("src");
//images/gosu.jpg
console.log(aAttrNode);

aAttrNode = aNode.src;
//http://127.0.0.1:5500/javascriptdemo/images/gosu.jpg
console.log(aAttrNode);

aNode.setAttribute("title", "스타배우");

aNode.id = "imgGosu";

let aAttrList = aNode.getAttributeNode;
//1
console.log(aAttrList.length);
//getAttributeNode() { [native code] }
console.log(aAttrList);

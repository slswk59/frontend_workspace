//js029_array.js

let score = [100, 90, 100];
console.log(score[0]); //100
console.log(score[1]); //90
console.log(score[2]); //100
console.log(score[3]); //undefined
console.log(score.length); //3

let person = ["John", "Doe", 26, true];

for (let idx in person) {
  console.log(person[idx], typeof person[idx]);
}

let cars = new Array("Sasb", "Volvo", "BMW");
for (let idx in cars) {
  console.log(cars[idx], typeof cars[idx]);
}

let color = [];
console.log(color.length); //0
color[0] = "red";
console.log(color.length); //1
color.push(1);
console.log(color.length); //2
color.push(759);
console.log(color.length); //3
color[8] = "blue";
console.log(color.length); //9

for (let idx in color) {
  console.log(`${idx} : ${color[idx]}`);
}

for (let i = 0; i < color.length; i++) {
  console.log(`${i} : ${color[i]} => ${typeof color[i]}`);
}

//3개의 크기를 가진 배열을 생성
let point = new Array(3);
console.log(`point length : ${point.length}`); //3

//2개의 요소를 가진 배열을 생성
let shape = new Array(10, 20);
console.log(`shape length: ${shape.length}`); //2

shape[2] = 50;
console.log(shape.length); //3

/*
 for()
 for ~ in : index
 for ~ of : element
*/

//forEach() : 배열 전용 메소드
//배열.forEach(element => {수행문장})
// Array.array.forEach(element => {
//     console.log(`${element}`);
// });

let choice = "javascript";
//문자열은 forEach를 제공하지 않으므로 사용할 수 없다.
// choice.forEach((element) => {
//     console.log(element);
// })

//배열명.map(callback);
const numbers = [4, 9, 16, 25];
const res = numbers.map(function (value, index) {
  return value * 2;
});

console.log(res); // [8, 18, 32, 50]

const sqt = numbers.map(Math.sqrt);
console.log(`sqt: ${sqt}`); //2,3,4,5

function getSum(total, num) {
  return total + num;
}

const sum = numbers.reduce(getSum);
console.log(`sum: ${sum}`); //54

const ages = [32, 33, 16, 40];
const per = ages.filter((value, index) => {
  return value >= 18;
});

console.log(`per : ${per}`); //32, 33, 40

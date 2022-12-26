//js030_array.js

const fruits = ["Banana", "Orange", "Apple", "Mango"];

console.log(fruits);
console.log(fruits.toString()); //Banana,Orange,Apple,Mango
console.log(`${typeof fruits.toString()}`); //string

console.log(typeof fruits.join()); //string
console.log(fruits.join("*")); //Banana*Orange*Apple*Mango
console.log(fruits.join("_")); //Banana_Orange_Apple_Mango

//배열의 끝에 요소 추가
fruits[4] = "kiwi";
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']
console.log(fruits.push("Melon")); //6
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi', 'Melon']

//배열의 끝에 요소 제거
console.log(fruits.pop()); //Melon
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

//배열의 앞에 요소 추가
console.log(fruits.unshift("Melon")); //6
console.log(fruits); //['Melon', 'Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

//베열의 앞에 요소 제거
console.log(fruits.shift()); // Melon
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

//특정 위치의 요소제거(자리는 확보하고 있음)
delete fruits[3];
console.log(fruits); //['Banana', 'Orange', 'Apple', 비어 있음, 'kiwi']

fruits[3] = "Mango";
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

//특정 범위의 요소를 가져옴
console.log(fruits.slice(1, 3)); //['Orange', 'Apple']
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

console.log(fruits.slice(-4, -2)); //['Orange', 'Apple']
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

//1인덱스부터 마지막까지 가져옴
console.log(fruits.slice(1)); //['Orange', 'Apple', 'Mango', 'kiwi']
console.log(fruits); //['Banana', 'Orange', 'Apple', 'Mango', 'kiwi']

//오름차순 정렬
console.log(fruits.sort()); //['Apple', 'Banana', 'Mango', 'Orange', 'kiwi']

//내림차순 정렬
console.log(fruits.sort().reverse()); //['kiwi', 'Orange', 'Mango', 'Banana', 'Apple']

let point = [40, 100, 1, 5, 10];
console.log(point.sort()); //[1, 10, 100, 40, 5]

//오름차순
//[1, 5, 10, 40, 100]
point.sort(function (a, b) {
  return a - b;
});
console.log(point);

//내림차순
//[100, 40, 10, 5, 1]
point.sort(function (a, b) {
  return b - a;
});
console.log(point);

let xData = [1, 2, 3];
let yData = [4, 5, 6];
let zData = xData.concat(yData);
console.log(zData.length); //6
console.log(zData); //[1, 2, 3, 4, 5, 6]

let aData = [[1, 2, 3]];
let bData = [[4, 5, 6]];
let arr2 = aData.concat(bData);
// 0(3) [1, 2, 3]
// 1(3) [4, 5, 6]
console.log(arr2);

let arr3 = [1, 3, [[[4, 5]]], [7, 8], [[[9, 10]], 12]];

console.log(arr3);
console.log(arr3[2][0][0][0]); //4
console.log(arr3[4][0][0]);
console.log(arr3.flat()); // [1, 3, Array(1), 7, 8, Array(2), 12]
console.log(arr3); //[1 ,3 Array(1),Array(2), Array(2)]
console.log(arr3[0]); //1
console.log(arr3[2][0][0]);
console.log(arr3[4][0]);
console.log(arr3.flat(1)); //[1, 3, Array(1), 7, 8, Array(2), 12]
console.log(arr3.flat(2));
console.log(arr3.flat(3)); //[1, 3, 4, 5, 7, 8, 9, 10, 12]
console.log(arr3); //[1, 3, Array(1), Array(2), Array(2)]
let kdata = arr3.flat(2);
console.log(kdata);
console.log(kdata[2][0]); //4
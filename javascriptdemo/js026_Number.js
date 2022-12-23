//js026_Number.js

let data = 10;
let fData = Number(data);
let nObj = new Number(data);
console.log(`data=${typeof data}`); //number
console.log(`fData=${typeof fData}`); //number
console.log(`nObj=${typeof nObj}`); //object

//toString() : number, Number -> string
console.log(typeof nObj.toString()); //string
console.log(typeof data.toString()); //string

console.log(data + fData); //number + number = 20
console.log(data + nObj); //number + object = 20

// Number -> number
// valueOf() : object -> primitive
console.log(typeof nObj.valueOf()); // number
console.log(typeof new String("javascript").valueOf()); //string

//let val = '10.0';
//let val = '10.3';
//let val = 'A';
let val = "10A";
//let val = 'A10';
console.log(val + val); //1010
console.log(val);

//Number(), parseInt()
console.log(Number(val) + Number(val)); //20 20.6  NaN NaN NaN
console.log(parseInt(val) + parseInt(val)); //20 20   NaN 20 NaN
console.log(parseFloat(val) + parseFloat(val)); // 20 20.6 NaN 20 NaN

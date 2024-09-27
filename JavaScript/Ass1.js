//1. What is the difference between let, var, const in JavaScript?
console.log("******1. What is the difference between let, var, const in JavaScript?******")

var a= 12
var a =2    // we can re-declare the var 
let b = 3
b = 7       //we cant re-declare the let but we can assign the let
const c = 12
//c = 1       //we cant re-declare nor assign the const
console.log(c)

//2. What are the various data types that exist in JavaScript?
console.log("******2. What are the various data types that exist in JavaScript?*******")

// Numbers:
let length = 16;
let weight = 7.5;
console.log(length)

// Strings:
let color = "Yellow";
let name = "Kanna";
console.log(color)

// Booleans
let x = true;
let y = false;
console.log(x)

// Object:
const person = {firstName:"Durga", lastName:"prasad"};
console.log(person)

// Array object:
const cars = ["Saab", "Volvo", "BMW"];
console.log(cars)
console.log(typeof(cars))

// Date object:
const date = new Date("2023-11-4");
console.log(date)

//3. What are Global, function, block scopes of a variable in JavaScript?
console.log("*******3. What are Global, function, block scopes of a variable in JavaScript?******")

//Global Scope
var G1 = 1
let G2 = 2
const G3 = 3
console.log(G1)
console.log(G2)
console.log(G3)

//Function Scope
function F1() 
{
    var carName1 = "BMW";   // Function Scope
}
function F2() 
{
    let carName2 = "Volvo";   // Function Scope
}
function F3() 
{
    const carName3 = "Saab";   // Function Scope
}
// console.log(F1(carName1))


// Block Scope
{
    let B1 = 2;
}
{
    var B2 = 4;
}
// console.log(B1)
console.log(B2)

//4. How do you create an array and object in JavaScript?
console.log("*********4. How do you create an array and object in JavaScript?********")

a1 = [1,3,2,6,4,7,8]
console.log(typeof(a1))
o1 = {name:"prasad",age:16}
console.log(typeof(o1))

//5. What are the built-in methods in JavaScript?
console.log("*********5. What are the built-in methods in JavaScript?*********")

no1 = "one"
console.log(toString(no1))


//6. What is the difference between Function declaration and Function expression?
console.log("********6. What is the difference between Function declaration and Function expression?*******")

//Function declaration
function fd(fd1,fd2)
{
    console.log(fd1+fd2)
}
fd(4,4)

//Function expression
var fe= function()
{
    console.log("This is Function expression")
}
console.log(fe)
fe()

const fe2 = function (width, height) {
    return width * height;
  };
  
  console.log(fe2(3, 4));


//7. What is arrow function in JavaScript?
console.log("*******7. What is arrow function in JavaScript?*******")
const arr = () =>
{
    console.log("Hi All!");
}
arr()


//8. Difference between “ == “ and “ === “ operators ?
console.log("*********8. Difference between “ == “ and “ === “ operators ?**********")
//==
op1=4
op2="4"
de=op1==op2
//===
te=op1===op2
console.log(op1)
console.log(op2)

//9. What is Callback function?
console.log("*********9. What is Callback function?***********")
function c1()
{
    console.log("This is 1 st Function")
    c2()
}
function c2()
{
    console.log("This is 2 nd Function")
}
c1()


//10. What are the popular JavaScript Array methods: map, filter, find, reduce, and forEach?
console.log("*******10. What are the popular JavaScript Array methods: map, filter, find, reduce, and forEach?*******")

//filter
var scores = [12,13,14,16]
let newFilterEvenScores =scores.filter(score=>score%2==0)
//Map
console.log(newFilterEvenScores) 
let mappedArray=newFilterEvenScores.map(score=>score*3)
//reduce
console.log(mappedArray)
let totalVal=scores.reduce((sum,val)=>sum+val,0)
console.log(totalVal)
console.log(scores)
//find
let findNo=scores.find((elemant)=>elemant>15)
console.log(findNo)

//Foreach
scores.forEach((elemant1) => console.log(elemant1))


// g = "8"
// r = "24"
g = 8
r = 24
e = "jsg"
console.log((g,r).concat(e))
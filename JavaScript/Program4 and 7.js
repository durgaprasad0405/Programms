// Calculate the sum of numbers in an array of numbers
console.log("*************Calculate the sum of numbers in an array of numbers********")
Array = [1,2,3,4,5,6]
sum = 0
for (i=0; i<Array.length; i++)
{
    sum = sum+Array[i]
}
console.log(sum)

//for loop in single line is declared in below
console.log("**********for loop in single line is declared in below*********")
let total =Array.reduce((sum,Array)=>sum+Array,0)
console.log(total)

//-----------------------------------------------------------
//Reverse an array
console.log("********************Reverse an array***********************")
console.log(Array)
console.log(Array.reverse())
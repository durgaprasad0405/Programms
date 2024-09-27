//Create a function that receives an array of numbers and returns an array containing only the positive numbers
// var numbers=[10,-12,89,56,-83,8,90,-8]
// var pos_count=neg_count=0
// numbers.map(function(element)
// {
//     if (element<0)
//     neg_count++;
//     else
//     pos_count++;
// });
// console.log(`The positive numbers in an array is ${pos_count}`)
// console.log(`The negative numbers in an array is ${neg_count}`)

function countNumbers(array, index, pos_count) 
{
	if (index < array.length)
     {
		if (array[index] > 0)
        {
			pos_count++;
		}
		return countNumbers(array, index + 1, pos_count);
	}
    else 
    {
		return { pos_count};
	}
}

var array=[-8,10,23,44,-80,-15,44,-1]
var counts = countNumbers(array, 0, 0);
console.log("The positive numbers in an array is "+counts.pos_count)

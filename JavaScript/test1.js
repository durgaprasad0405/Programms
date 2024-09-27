// let a = [2,4,6,8,6,3]
// let c = []
// // a.forEach((elemet)=>console.log(elemet%2==0))
// function arr (element)
// {
//     if (element%2==0)
//     {
//         c.push(element)
//     }
//     return c
// }
// var b = a.forEach(arr)
// console.log(b)


let a = [2,5,6,8,6,3];
let c=[];
function arr(element, index, a)
{
    if(element%2==0)
    {
        c.push(element)
    }
}
a.forEach(arr)
console.log(c)
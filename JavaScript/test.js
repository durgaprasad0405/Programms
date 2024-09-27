let a = {"name":"prasad", "age":23}
console.log(a)
let b = new Object();
b.name="kanna"
b.age=24
console.log(b)
function Name(name, age)
{
    this.name=name;
    this.age=age;
}
let c = new Name("durga", 22);
console.log(c.name + " " +c.age);

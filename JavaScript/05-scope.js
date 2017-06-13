var emp1;//undefined

function foo(){
console.log("In foo "+emp1);
emp1 = "some name";
}

console.log("1. "+emp1);
foo();

console.log("Out foo "+emp1);

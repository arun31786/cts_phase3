//es5
function Employee(fName, lName, dept, salary){
	this.fName = fName;
	this.lName = lName; 
	this.dept = dept;
	this.salary = salary;
	
	this.showDetails = function(){
		console.log("FirstName: "+this.fName);
		console.log("LastName: "+this.lName);
		console.log("Department: "+this.dept);
		console.log("Salary: "+this.salary);
	}
}

var ram = new Employee("Ram", "Kapoor", "HR", 5.4)
var mark = new Employee("Mark", "Smith", "Security", 5)



//es6
class Manager{

	constructor(fName, lName, dept, salary){
		this.fName = fName;
		this.lName = lName;
		this.dept = dept;
		this.salary = salary;
	}
	showDetails(){
		console.log("FirstName: "+this.fName);
		console.log("LastName: "+this.lName);
		console.log("Department: "+this.dept);
		console.log("Salary: "+this.salary);
	}
}

var ram = new Manager("Ram", "Kapoor", "HR", 5.4)

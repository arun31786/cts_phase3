function add(){
	console.log(3+7);
}

add(); // 10

function add(fn, sn){
	console.log(fn+sn);
	return fn+sn;
}
var sum = add(3,9);
sum  // 12


function addAll(){
	//console.log(arguments);
	var sum = 0;
	for(var i=0;i<arguments.length;i++){
		//console.log(arguments[i]);
		sum = add(sum, arguments[i])
	}
	return sum;
}
var result = addAll(5,2,8,5,9);


function addAll(){
	//console.log(arguments);
	var sum = 0;
	for(var i=0;i<arguments.length;i++){
		//console.log(arguments[i]);
		sum = add(sum, +arguments[i])
	}
	return sum;
}
var result = addAll(3, 7, '100')
 

function addAll(){
	//console.log(arguments);
	var sum = 0;
	for(var i=0;i<arguments.length;i++){
		//console.log(arguments[i]);
		if(!isNaN(arguments[i])){
			sum = add(sum, +arguments[i])
		}
	}
	return sum;
}
var result = addAll(3, 7, '100', 'ten')










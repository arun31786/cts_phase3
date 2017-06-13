var operators = {
	'+' : function(fn, sn){return fn + sn},
	'*' : function(fn, sn){return fn * sn},
	'/' : function(fn, sn){return fn / sn}
} 

function cal(operand1, operand2, operator){
	var func = operators[operator];
	var output = func(operand1, operand2);
	return output;
}

function cal(operand1, operand2, operator){
	return operators[operator](operand1, operand2);
}

cal(4,7, '+');
cal(4,7, '*');
cal(4,7, '/');


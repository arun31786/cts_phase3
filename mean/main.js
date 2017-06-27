var express = require('express');

var server = express();

server.get("/hello/:name", function(req, res){
    var name = req.params.name;
    res.json({"success": true, "name": name});
})
server.post("/hello", function(req, res){
    res.json({success: true});
})

server.listen(4545, function(err){
    if(err){
        console.log("error found")
    } else {

        console.log("Server is running at 4545");
    }
})
// console.log(typeof express);
$(document).ready(function () {
    $("#submit").click(function(){
        $.ajax({
            type: "POST",
            url: "gym/addGym",
            data: JSON.stringify({
                "gymID" : 1000,"gymName" : "Test",
                "login" : "tet",
                "email" : "asd@asd.hu",
                "city" : "testCity"
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){alert(data);},
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
});
/*
$( "#regform" ).submit(function( event ) {
    var gymname = document.getElementById("gymName").value;
    var login = document.getElementById("login").value;
    var email = document.getElementById("email").value;
    var city = document.getElementById("city").value;
    var parameters = '{' +
        '"gymID":"1000",' +
    '"gymName":"' + gymname +'",' +
    '"login":"' +login +'",' +
    '"email:"'+email + '",' +
    '"city":"'+city+'"' +
    '}';

    $.ajax({
        url: '/gym/addGym', // url where to submit the request
        type : "POST", // type of action POST || GET
        dataType : 'application/json', // data type
        data : parameters, // post data || get data
        success : function(result) {
            // you can see the result from the console
            // tab of the developer tools
            console.log(result);
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })
});
*/
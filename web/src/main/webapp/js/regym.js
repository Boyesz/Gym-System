$(document).ready(function () {
    var dataWait;
    $.ajax({
        type: "GET",
        url: "gym/getMaxID",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){dataWait = data;},
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
    $("#submit").click(function(){
        var gymname = document.getElementById("gymName").value;
        var login = document.getElementById("login").value;
        var email = document.getElementById("email").value;
        var city = document.getElementById("city").value;
        var parameters = '{' +
            '"gymID":'+dataWait+',' +
            '"gymName":"' + gymname +'",' +
            '"login":"' +login +'",' +
            '"email":"'+email + '",' +
            '"city":"'+city+'"' +
            '}';
        $.ajax({
            type: "POST",
            url: "gym/addGym",
            data: parameters,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){alert(data);},
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
});
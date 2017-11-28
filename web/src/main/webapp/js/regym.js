function validate() {
    var gymname = document.getElementById("gymName");
    var login = document.getElementById("login");
    var email = document.getElementById("email");
    var city = document.getElementById("city");
    if (gymname.value == "") {
        gymname.style.backgroundColor = "red";
        document.getElementById("gymName").placeholder = "Kérlek add meg a konditerem nevét.";
        gymname.style.color = "snow";
        return false;
    }
    else{
        gymname.style.backgroundColor = "green";
        gymname.style.color = "snow";
    }
    if (login.value == "") {
        login.style.backgroundColor = "red";
        document.getElementById("login").placeholder = "Kérlek add meg a felhasználó neved.";
        login.style.color = "snow";
        return false;
    }
    else{
        login.style.backgroundColor = "green";
        login.style.color = "snow";
    }
    if (email.value == "") {
        email.style.backgroundColor = "red";
        document.getElementById("email").placeholder = "Kérlek add meg az e-mail címed.";
        email.style.color = "snow";
        return false;
    }
    else{
        email.style.backgroundColor = "green";
        email.style.color = "snow";
    }
    if (city.value == "") {
        city.style.backgroundColor = "red";
        document.getElementById("city").placeholder = "Kérlek add meg a város nevét.";
        city.style.color = "snow";
        return false;
    }
    else{
        city.style.backgroundColor = "green";
        city.style.color = "snow";
    }
}
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
        if(validate() == false)
            return;
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
            success: function(data){window.location.href = "succes.html";},
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
});
function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function validateGym() {
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
        if(validateEmail(email.value)){
            email.style.backgroundColor = "green";
            email.style.color = "snow";
        }
        else{
            email.style.backgroundColor = "red";
            alert("Kérlek helyes e-mailt adj meg.");
            email.style.color = "snow";
            return false;
        }
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

function gymRegInit() {
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
    $("#submitGym").click(function(){
        if(validateGym() == false)
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
            success: function(data){
                if(data == 1)
                {
                    $.get("success.html", function (data) {
                        document.getElementById('content').innerHTML = data;
                        custRegInit();
                    });}
                },
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
}
function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
function validate() {
    var name = document.getElementById("name");
    var login = document.getElementById("login");
    var email = document.getElementById("email");
    var gym = document.getElementById("gym");
    var birth = document.getElementById("birth");
    if (name.value == "") {
        name.style.backgroundColor = "red";
        document.getElementById("name").placeholder = "Kérlek add meg a saját neved.";
        name.style.color = "snow";
        return false;
    }
    else{
        name.style.backgroundColor = "green";
        name.style.color = "snow";
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
    if(email.value == ""){
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
    if (birth.value == null) {
        birth.style.backgroundColor = "red";
        document.getElementById("gym").placeholder = "Kérlek add meg a szülteséi éved.";
        birth.style.color = "snow";
        return false;
    }
    else{
        birth.style.backgroundColor = "green";
        birth.style.color = "snow";
    }
}
$(document).ready(function () {
    var id;
        function makeOptions(data){
        var element = document.getElementById("gym")
        for(j = 0;j<data.length;j++){
            var opt = document.createElement('option');
            opt.value =data[j][1];
            opt.text= data[j][0];
            element.add(opt) ;
        }
        }
        $.ajax({
        type: "GET",
        url: "gym/getAllGymNameAndGymID",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){makeOptions(data);},
        failure: function(errMsg) {
        alert(errMsg);
    }
    });
    $.ajax({
        type: "GET",
        url: "customer/getMaxID",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){id = data;},
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
    $("#submit").click(function(){
        if(validate() == false)
            return;
        var name = document.getElementById("name").value;
        var login = document.getElementById("login").value;
        var email = document.getElementById("email").value;
        var birth = document.getElementById("birth").value;
        var gym = document.getElementById("gym").value;
        var parameters = '{' +
            '"gymid":'+gym+',' +
            '"login":"' + login +'",' +
            '"birth":"' +birth +'",' +
            '"email":"'+email + '",' +
            '"name":"'+name+'",' +
            '"id":'+id +
            '}';
        $.ajax({
            type: "POST",
            url: "customer/addCustomer",
            data: parameters,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
                if(data == 1)
                window.location.href = "success.html";},
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
});
function onSubmit(event) {

    event.preventDefault();
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var age = document.getElementById('age').value;
    var phone = document.getElementById('phone').value;
    var password = document.getElementById('password').value;

    if (name == '' || email == '' || age == '' || phone == '') {

        alert("Please enter all the fields before registering");
        return false;
    }

    if (CheckPassword(password)) {
        $("#forhide").hide();
        $("#msg").show();
        $.when(ajax1(name, email, age, phone, password)).then(function (response) {

                alert("Registration is successful .\nAfter pressing \"ok\" button you'll be redirected to the login page ...");
                window.location = "/Login/Login.html";
            },
            function (response) {
                alert(response)
                location.reload();
            }
        );
    }
    return true;
}

function ajax1(name, email, age, phone, password) {
    var settings = {
        "url": "http://localhost:8080/api/v1/signUp",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({name: name, email: email, password: password, phone: phone, age: age}),
    };
    return $.ajax(settings);
}

function CheckPassword(inputtxt) {
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    if (inputtxt.match(passw)) {
        return true;
    } else {
        alert('Password needs to be 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter]')
        return false;
    }
}
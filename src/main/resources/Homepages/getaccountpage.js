let _userID = localStorage.getItem("userId");

window.onload = GetApi(_userID)

function GetApi(id) {
    var settings = {
        "url": "http://localhost:8080/users/" + id,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };

    $.ajax(settings).done(function (response) {
        DisplayDetails(response)
    });


}

function DisplayDetails(user) {
    console.log(user)
    document.getElementById("name").textContent = user.name;
    document.getElementById("phone").textContent = user.phone;
    document.getElementById("email").textContent = user.username;
    document.getElementById("age").textContent = user.age;
}

//------func for edit phone number-------------------
function EditPhone() {
    let _phone = document.getElementById('newphone').value;
    if(CheckPhone(_phone))
    {
        var settings = {
            "url": "http://localhost:8080/updateAccount/changePhone",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"id": _userID, "phone": _phone}),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("your phone number has been updated :)")

        });
    }
}

//------func for edit password-------------------
function EditPassword() {
    let _password = document.getElementById('newpass').value;
    if (CheckPassword(_password)) {
        var settings = {
            "url": "http://localhost:8080/updateAccount/changePassword",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"id": _userID, "password": _password}),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("your password has been updated :)")
        });
    }
}

//------func for edit name-------------------
function EditName() {
    let _name = document.getElementById('newname').value;
    if(CheckName(_name))
    {
        var settings = {
            "url": "http://localhost:8080/updateAccount/changeName",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"id": _userID, "name": _name}),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("your name has been updated :)")
        });
    }
}

//------func for edit email-------------------
function EditEmail() {
    let _email = document.getElementById('newemail').value;
    if (CheckEmail(_email)) {
        var settings = {
            "url": "http://localhost:8080/updateAccount/changeEmail",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"id": _userID, "email": _email}),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("your email has been updated :)")
        });
    }
}

//======================CHECK FUNCTIONS============================//
function CheckPassword(inputtxt) {
    if(inputtxt==""){
        alert('please insert something!')
        return false;
    }
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    if(inputtxt.match(passw)) {
        return true;
    }
     else {
        alert('Password needs to be 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter]')
        return false;
    }
}

function CheckEmail(inputtxt) {
    if(inputtxt==""){
        alert('please insert something!')
        return false;
    }
    var email = /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
    if (inputtxt.match(email)) {
        return true;
    } else {
        alert('the email must be like xxxxx@examble.com')
        return false;
    }
}

function CheckPhone(inputtxt) {
    if(inputtxt==""){
        alert('please insert something!')
        return false;
    }
    var Phone = /^\d{10}$/;
    if (inputtxt.match(Phone)) {
        return true;
    }
    else
      {
        alert('phone number must be 10 digits')
        return false;
    }
}

function CheckName(inputtxt) {
    if(inputtxt==""){
        alert('please insert something!')
        return false;
    }
    var name = /[a-zA-Z]{2,20}$/;
    if (inputtxt.match(name)) {
        return true;
    } else {
        alert('name must be only between 2 and 20 charachters')
        return false;
    }
}
//--------------func for delete account--------------

function DeleteAccount() {
    var settings = {
        "url": "http://localhost:8080/editUser/deleteUser/" + _userID,
        "method": "DELETE",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
        alert("your account has been deleted, Thanks")
        localStorage.clear();
        window.location = "/Login/Login.html";
    });
}

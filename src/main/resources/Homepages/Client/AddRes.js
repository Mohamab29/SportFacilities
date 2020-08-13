window.onload = getADs();
let _adverId = localStorage.getItem('toAdd');
let _userId = localStorage.getItem("userId");

function getADs(id) {
    var settings = {
        "url": "http://localhost:8080/Reservation/getListReservationById/5eb9caf2fa2069679d7cbd8a",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
        "success": function (e) {
            //sending the list
            checkAdId(e);
        }
    };


    $.ajax(settings)
}

function checkAdId(Ads) {
    //storing as a string in local storage
    localStorage.setItem("Ads", JSON.stringify(Ads));
    //parsing back the list
    var storedNames = JSON.parse(localStorage.getItem("Ads"));
    //first elemnt in the list
    console.log(storedNames);
}

//-------------------------------------------------//
function Submit() {
    //event.preventDefault();
    var _num = document.getElementById('numberplayers').value;
    var _start = document.getElementById('start').value;
    var _end = document.getElementById('end').value;
    if (_num == '' || _end == '' || _start == '' || _adverId == '' || _userId == '') {

        alert("Please enter all the fields before requestig")
        return false;
    }
    var settings = {
        "url": "http://localhost:8080/Reservation/addReservation",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "end": _end,
            "idAdvertisement": _adverId,
            "idApplicationUser": _userId,
            "numberTeam": _num,
            "start": _start
        }),
    };

    $.ajax(settings).done(function (response) {
        if(response == "Your Reservation Reject!"){
            let ans = confirm ("ההזמנה ששלחתה היא לא תקינה \nרוצה לנסות שוב ?");
            if (ans){
                location.reload();
            }else{
                window.location = "/Homepages/Client/Clienthomepage.html";
            }
        }else{
            alert("ההזמנה שלך התקבלה בהצלחה \nתלחץ על אוקיי בשביל לחזור לדף הבית");
            window.location = "/Homepages/Client/Clienthomepage.html";
        }
        
    });
}
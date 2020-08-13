let _InspecId = localStorage.getItem("userId");
let _userID = localStorage.getItem("IdUser");
let _comID = localStorage.getItem("ToRes");
if (!_InspecId) {
    window.location = "/Login/Login.html";
} else if (!_userID || !_comID) {
    alert("An error accrued with getting the data needed to respond\nyou will be sent back to the complains page after pressing ok .")
    window.location = "/Homepages/Inspector/Inspectorshomepage.html";
} else {
    document.getElementById("TextArea").style.display = "none";
    GetComplaints();
}

function GetComplaints() {
    // Gettign all the complaints
    var settings = {
        "url": "http://localhost:8080/complaint/findAllComplaint",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };

    $.ajax(settings).done(function (response) {
        look_for_complaint(response);
    });
}

function look_for_complaint(complaints) {
    /* in this function were gonna look for the proper complaint's body and title that matches the user id and the complaint id */
    let title, body;
    for (let i = 0; i < complaints.length; i++) {
        if (complaints[i].id == _comID && complaints[i].idUser == _userID) {
            body = complaints[i].body;
            title = complaints[i].subject;

        }
    }
    document.getElementById("comptitle").innerHTML = title;
    document.getElementById("compbody").innerHTML = body;
}

function show_text_editor() {
    let x = document.getElementById("TextArea");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function send_respond() {
    /* in this function we take the value from the text editor and we send it back to the server */
    let __response = tinyMCE.activeEditor.getContent({format: 'text'});
    var settings = {
        "url": "http://localhost:8080/complaint/addResponseComplaint",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
            "Content-Type": "application/json ; charset=utf-8 "
        },
        "data": JSON.stringify({"idComplaint": _comID, "responseComplaint": __response}),
    };

    $.ajax(settings).done(function (response) {
        alert("התלונה שלך נשלחה בהצלחה!");
        localStorage.removeItem("IdUser");
        localStorage.removeItem("ToRes");
        window.location = "/Homepages/Inspector/Inspectorshomepage.html";
    });

}
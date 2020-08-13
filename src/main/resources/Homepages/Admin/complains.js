let _adminId = localStorage.getItem("userId");
if (!_adminId) {
    window.location = "/Login/Login.html"
} else {
    GetApi();
}

function GetApi() {
    // Gettign all the complains 
    var settings = {
        "url": "http://localhost:8080/complaint/findAllComplaint",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };

    $.ajax(settings).done(function (response) {
        BuildTable(response)
    });


}

function BuildTable(complains) {
    // building the table rows per complain 
    complains.sort(function (a, b) {
        return new Date(b.created) - new Date(a.created)
    });
    let _row = "";
    let index = 1;
    for (let i = 0; i < complains.length; i++) {
        _row =
            `<tr>
            <td style="text-align: center;">
            <span class="table-remove">
            <button type="button" class="btn btn-danger btn-rounded btn-sm my-0 ">Delete
            </button>
            </span>
            </td>`
            +
            `
            <td style="text-align: center;">
            <span class="table-answer">
            <button type="button" class="btn btn-primary btn-rounded btn-sm my-0 onclick="SaveAndLoad(${1},${2})" ">Answer
            </button>
            </span>
            </td>`
            +
            `<td style="text-align: center;" id="idUser">` + complains[i].idUser + "</td>" +
            `<td style="text-align: center;">` + to_date(complains[i].created) + "</td>" +
            `<td style="text-align: center;">` + complains[i].status + "</td>" +
            `<td style="text-align: center;">` + complains[i].subject + "</td>" +
            `<td style="text-align: center;">` + complains[i].userName + "</td>" +
            `<td style="text-align: center;" id="idCom" hidden>` + complains[i].id + "</td>" +
            `<td style="text-align: center;">` + (index) + "</th>" +
            "</tr>"

        $('tbody').append(_row)
        index++;
    }


}

const $tableID = $('.table');
const _ResId = "";
$tableID.on('click', '.table-remove', function () {
    // when the delete button is pressed this fucntion will be activiated 
    // and in this function we take id of the complain in th same row ,
    // then we send a delete requset to our data base to delete the specified complain 
    let confirm_delete = confirm("האם אתה בטוח שאתה רוצה למחוק את התלונה הזו?")
    if (confirm_delete) {
        let idCom = $(this).parents('td').siblings("#idCom").html();
        var settings = {
            "url": "http://localhost:8080/complaint/deleteComplaint/" + idCom,
            "method": "DELETE",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
            },
        };

        $.ajax(settings).done(function (response) {

            console.log(response);

        });
        $(this).parents('tr').detach();

    }
});
///////////////////////answer buttton
$tableID.on('click', '.table-answer', function () {
    // when the answer button is pressed this fucntion will be activiated 
    // and in this function will take id of the complain in the same row and the user id
    //and then saving them to local stoarge to be used in the response page
    let idCom = $(this).parents('td').siblings("#idCom").html();
    let idUser = $(this).parents('td').siblings("#idUser").html();
    localStorage.setItem("ToRes", idCom);
    localStorage.setItem("IdUser", idUser);
    window.location = "/Homepages/Admin/restocomp.html";

});


function Search() {
    // a search methode when we search this is activated and it will check the values
    // of all the name and subject and status of each row and check if what is written in the search
    // matches anything in these fields throught the table
    let input, filter, table, tr, td0, td1, td2, i, txtValue0, txtValue1, txtValue2;
    input = document.getElementById("search");
    filter = input.value;
    table = document.getElementById("ResTable");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
        td0 = tr[i].getElementsByTagName("td")[4];
        td1 = tr[i].getElementsByTagName("td")[5];
        td2 = tr[i].getElementsByTagName("td")[6];
        if (td0 || td1 || td2) {
            txtValue0 = td0.textContent || td0.innerText;
            txtValue1 = td1.textContent || td1.innerText;
            txtValue2 = td2.textContent || td2.innerText;
            txtValue1 = txtValue1.toLowerCase();
            txtValue2 = txtValue2.toLowerCase();
            if (txtValue0.indexOf(filter) > -1 || txtValue1.indexOf(filter) > -1 || txtValue2.indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function to_date(_time) {
    //The toUTCString() method converts a date to a string, using the UTC time zone.
    let temp_time = new Date(Date.parse(_time));
    return temp_time.toLocaleString('en-GB')
}
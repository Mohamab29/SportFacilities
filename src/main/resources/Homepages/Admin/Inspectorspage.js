let _adminId = localStorage.getItem("userId");
if (!_adminId) {
    window.location = "/Login/Login.html"
} else {
    GetApi();
}

function GetApi() {
    // Gettign all the users 
    var settings = {
        "url": "http://localhost:8080/users",
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

function BuildTable(users) {
    // building the table rows per user 
    let _row = "", options;
    let index = 1;
    for (let i = 0; i < users.length; i++) {
        if (users[i].role == "1" || users[i].role == "2") {
            options = build_options(users[i].role);
            row =
                `<tr>
                <td style="text-align: center;">
                <span class="table-remove">
                <button type="button" class="btn btn-danger btn-rounded btn-sm my-0 ">Delete
                </button>
                </span>
                </td>`
                +

                `<td style="text-align: center;">` + to_date(users[i].join) + "</td>" +
                `<td style="text-align: center;">
                    <select class="custom-select" onchange="change_role(this)" id="roles">
                    <option value="${options[0]}">${options[0]}</option>
                    <option value="${options[1]}">${options[1]}</option>
                    <option value="${options[2]}">${options[2]}</option>
                    </select>
                </td>` +
                `<td style="text-align: center;">` + users[i].age + "</td>" +
                `<td style="text-align: center;">` + users[i].phone + "</td>" +
                `<td style="text-align: center;">` + users[i].username + "</td>" +
                `<td style="text-align: center;">` + users[i].name + "</td>" +
                `<td style="text-align: center;" id="idUser" hidden>` + users[i].id + "</td>" +
                `<td style="text-align: center;">` + (index) + "</th>" +
                "</tr>"

            $('tbody').append(row)
            index++;
        }
    }

}

function build_options(role) {
    /* in this function we are gonna check what kind of role
     the user has to be able to show the right roles
     in the dropdown box
    */
    let options = ["0", "0", "0"];
    if (role == "2") {
        options[0] = "2";
        options[1] = "1";
        options[2] = "3";
    } else if (role == "1") {
        options[0] = "1";
        options[1] = "2";
        options[2] = "3";
    }
    return options;

}

const $tableID = $('.table');
const _ResId = "";
$tableID.on('click', '.table-remove', function () {
    // when the delete button is pressed this fucntion will be activiated 
    // and in this function we take id of the user in th same row ,
    // then we send a delete to our data base to delete the specified user 
    let confirm_delete = confirm("are you sure you want to delete this user ?")
    if (confirm_delete) {
        let idRes = $(this).parents('td').siblings("#idUser").html();
        var settings = {
            "url": "http://localhost:8080/editUser/deleteUser/" + idRes,
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


function change_role(_this) {
    // this methode is activated when the admin changes the role 
    // we take the values of the specified option and the user of the same row
    // and send a post request to change the role 
    let _op = _this.value;
    let confirm_change = confirm("You have changed the type of this user ! \n are you sure you want to change it ?")
    if (confirm_change) {
        let _id = $(_this).parents("td").siblings("#idUser").html();
        var settings = {
            "url": "http://localhost:8080/updateAccount/updateRole",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"id": _id, "role": _op}),
        };

        $.ajax(settings).done(function (response) {
            alert("The type of this user has been chnaged !");
        });

    } else {
        $(_this).val("1")
    }
}


function Search() {
    // a search methode when we search this is activated and it will check the values
    // of all the name and email and phone number of each row and check if what is written in the search
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
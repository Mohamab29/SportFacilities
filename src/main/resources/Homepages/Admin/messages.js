let _adminId = localStorage.getItem("userId");
const userEmail = localStorage.getItem('userEmail');
const userEmail_Sent = localStorage.getItem("selectedInspectorEmail");

console.log('email', userEmail_Sent);
window.onload = GetApi(_adminId)

function GetApi(id) {
    var settings = {
        "url": `http://localhost:8080/managementEmail/viewSendEmails/${userEmail}`,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };

    $.ajax(settings).done(function (response) {
        BuildTable(response);
    });


}

function BuildTable(message) {
    let _row = "";
    message.sort(function (a, b) {
        return new Date(b.created) - new Date(a.created)
    });
    console.log(message)
    for (let i = 0; i < message.length; i++) {

        _row =
        `<tr>
        <td style="text-align: center;">
        <span class="table-remove">
        <button type="button" class="btn btn-danger btn-rounded btn-sm my-0 ">Delete
        </button>
        </span>
        </td>`
            +

            `<td style="text-align: center;">` +to_date( message[i].created) + "</td>" +
            `<td style="text-align: center;">` + message[i].body + "</td>" +
            `<td style="text-align: center;">` + message[i].subject + "</td>" +
            `<td style="text-align: center;" id="idRes">` + message[i].recipientEmail + "</td>" +
            `<td style="text-align: center;">` + (i + 1) + "</th>" +
            "</tr>"

        $('tbody').append(_row)
    }

}

const $tableID = $('.table');
const _ResId = "";
$tableID.on('click', '.table-remove', function () {

    let idRes = $(this).parents('td').siblings("#idRes").html();
    // TODO - REQUEST DELETE IN THE BACKEND


    // var settings = {
    //   "url": "http://localhost:8080/Reservation/" + idRes,
    //   "method": "DELETE",
    //   "timeout": 0,
    //   "headers": {
    //     "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
    //   },
    // };

    // $.ajax(settings).done(function (response) {
    //   console.log(response);
    // });

    $(this).parents('tr').detach();
});

function Search() {
    let input, filter, table, tr, td0, td1, td2, i, txtValue0, txtValue1, txtValue2;
    input = document.getElementById("search");
    filter = input.value;
    table = document.getElementById("ResTable");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
        td0 = tr[i].getElementsByTagName("td")[2];
        td1 = tr[i].getElementsByTagName("td")[3];
        td2 = tr[i].getElementsByTagName("td")[4];
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
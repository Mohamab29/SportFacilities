let _adminId = localStorage.getItem("userId");
window.onload = GetApi(_adminId)

function GetApi(id) {
    var settings = {
        "url": "http://localhost:8080/Reservation/getListReservationById/" + id,
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

function BuildTable(reservations) {
    let _row = "";
    reservations.sort(function (a, b) {
        return new Date(b.created) - new Date(a.created)
    });
    console.log(reservations)
    for (let i = 0; i < reservations.length; i++) {

        _row =
            `<tr>
        <td >
        <span class="table-remove">
        <button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove
        </button>
        </span>
        </td>`
            +
            "<td>" + to_date(reservations[i].end) + "</td>" +
            "<td>" + to_date(reservations[i].start) + "</td>" +
            "<td>" + to_date(reservations[i].created) + "</td>" +
            `<td style="text-align: center;">` + reservations[i].nameAdvertisement + "</td>" +
            `<td style="text-align: center;">` + reservations[i].reservationNumber + "</td>" +
            "<td>" + reservations[i].emailApplicationUser + "</td>" +
            `<td style="text-align: center;">` + reservations[i].nameApplicationUser + "</td>" +
            `<td style="text-align: center;" id="idRes">` + reservations[i].id + "</td>" +
            `<td style="text-align: center;">` + (i + 1) + "</th>" +
            "</tr>"

        $('tbody').append(_row)
    }

}

const $tableID = $('.table');
const _ResId = "";
$tableID.on('click', '.table-remove', function () {

    let idRes = $(this).parents('td').siblings("#idRes").html();
    var settings = {
        "url": "http://localhost:8080/Reservation/" + idRes,
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
});

function Search() {
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("search");
    filter = input.value;
    table = document.getElementById("ResTable");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
        td0 = tr[i].getElementsByTagName("td")[7];
        td1 = tr[i].getElementsByTagName("td")[8];
        if (td0 || td1) {
            txtValue0 = td0.textContent || td0.innerText;
            txtValue1 = td1.textContent || td1.innerText;

            if (txtValue0.indexOf(filter) > -1 || txtValue1.indexOf(filter) > -1) {
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
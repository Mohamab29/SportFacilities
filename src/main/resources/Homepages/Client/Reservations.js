let _userID = localStorage.getItem("userId");
window.onload = GetApi(_userID)

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
        return  new Date(a.start) - new Date(b.start);
    });
    let _adName = [];
    console.log(reservations)
    for (let i = 0; i < reservations.length; i++) {

        _adName = getAd(reservations[i].idAdvertisement);

        _row =
            `<tr>
        <td >
        <span class="table-remove">
        <button type="button" class="btn btn-danger btn-rounded btn-sm my-0">Remove
        </button>
        </span>
        </td>`
            +
            `<td style="text-align: center;">` + to_date(reservations[i].end) + "</td>" +
            `<td style="text-align: center;">` + to_date(reservations[i].start) + "</td>" +
            `<td style="text-align: center;">` + reservations[i].nameAdvertisement + "</td>" +
            `<td style="text-align: center;">` + reservations[i].reservationNumber + "</td>" +
            `<td style="text-align: center;" id="idRes">` + reservations[i].id + "</td>" +
            `<td style="text-align: center;">` + (i + 1) + "</th>" +
            "</tr>"

        $('tbody').append(_row)
    }

}

function getAd(_adId) {
    let nameofAd = "";
    var settings = {
        "url": "http://localhost:8080/category/" + _adId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };

    $.ajax(settings).done(function (response) {
        nameofAd = response.name;
    });
    return nameofAd;
}

//Delete button has been checked and works fine
const $tableID = $('.table');
const _ResId = "";
$tableID.on('click', '.table-remove', function () {

    let idRes = $(this).parents('td').siblings("#idRes").html();
    let confirm_delete = confirm("האם אתה בטוח ?")
    if (confirm_delete) {
        var settings = {
            "url": "http://localhost:8080/Reservation/" + idRes,
            "method": "DELETE",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
            },
        };

        $.ajax(settings).done(function (response) {
            
        });
    }
    $(this).parents('tr').detach();
});

function Search() {
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("search");
    filter = input.value;
    table = document.getElementById("ResTable");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
        td0 = tr[i].getElementsByTagName("td")[5];
        if (td0) {
            txtValue0 = td0.textContent || td0.innerText;
            //bug fixed now the user can search by res id

            if (txtValue0.indexOf(filter) > -1) {
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
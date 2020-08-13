let _adverId = localStorage.getItem('toEdit');

function getAd() {
    let settings = {
        "url": "http://localhost:8080/category/" + _adverId,
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
        "success": function (e) {
            EditedAd(e);
        }
    };

    $.ajax(settings);
    event.preventDefault();
}

function EditedAd(AdValues) {
    let _save = confirm("Are you sure you want to save these changes ?");
    if (_save) {

        let _name = $('#name')[0].value;
        let _cond = $('#cond')[0].value;
        let _light = $('#light')[0].value;
        let _fence = $('#fence')[0].value;
        if (_name) {
            AdValues.name = _name;
        }

        if (_cond) {
            AdValues.condition = _cond;

        }
        if (_light) {
            AdValues.lighting = _light;
        }
        if (_fence) {
            AdValues.fencing = _fence;
        }

        var settings = {
            "url": "http://localhost:8080/category/updateAdvertisement",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=",
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({
                "activity": AdValues.activity, "association": AdValues.association, "condition": AdValues.condition,
                "fencing": AdValues.fencing, "forSchool": AdValues.forSchool, "handicapped": AdValues.handicapped,
                "houseNumber": AdValues.houseNumber, "id": AdValues.id, "lat": AdValues.lat,
                "lighting": AdValues.lighting, "lon": AdValues.lon, "name": AdValues.name,
                "neighborhood": AdValues.neighborhood, "operator": AdValues.operator,
                "owner": AdValues.owner, "seats": AdValues.seats, "sportType": AdValues.sportType,
                "street": AdValues.street, "type": AdValues.type
            }),
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert("Changes have been saved !\nYou can return by using the homepage button .");
        });
    }

}   
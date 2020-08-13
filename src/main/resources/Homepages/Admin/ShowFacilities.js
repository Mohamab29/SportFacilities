//var btn = document.getElementById("btn").addEventListener("click",getPost);
window.onload = getPost();

function SaveAndLoad(index) {

    localStorage.setItem("toEdit", $("#hiddenId" + index)[0].innerHTML);
    window.location = "/Homepages/Admin/EditSF.html";

}

//window.onload=function(){getPost()};

function getPost() {
    let row;

    fetch('http://localhost:8080/category/getCategoryAd')
        .then((res) => {
            return res.json();
        })
        .then((post) => {
            for (let index = 0; index < 169; index++) {

                row = `
            <div class="grid-item">
            <div class="card text-center " style="width: 20rem; ">
            <div class="card-body"  style = "font-size: large;">
            <h5 class="card-title">סוג מתקן : ${post[index].type}</h5>
            <p class="card-text">שם :${post[index].name}</p>
            <p class="card-text">כתובת : ${post[index].neighborhood} |${post[index].houseNumber}|${post[index].street}</p>
            <p class="card-text">נגישות : ${post[index].handicapped}</p>
            <p class="card-text">זמינות : ${post[index].condition}</p>
            <p class="card-text">תיאורה : ${post[index].lighting}</p>
            <p class="card-text">גידור : ${post[index].fencing}</p>
            <p class="card-text"  hidden id="hiddenId${index}">${post[index].id}</p>
            <div class="row " >
            <button  type="button" class="btn btn-primary  col-3"  id="editSF" onclick="SaveAndLoad(${index})" style="margin-right:1rem;">Edit</button>
            <a href="https://www.google.com/maps/?q=${post[index].lat},${post[index].lon}" type="button" class="btn btn-success col-3 " style="margin-right: 1.5rem;" >Map</a>
            <button  type="button" class="btn btn-danger btn-rounded btn-sm my-0 "style="margin-right: 2rem;" id="removeSF" onclick="removeAd(${index})">Remove
            </button>
            </div>
            </div>
            </div>
            </div>
            `
                $(".grid-container").append(row);
                row = '';
            }

        })
        .catch((error) => {
            console.log(error);
        })
}

const _AdsId = "";

function removeAd(index) {
    let confirm_delete = confirm("האם אתה בטוח שאתה רוצה למחוק את המתקן הזה?")
    if (confirm_delete) {

    console.log("heeeeree");
    let _AdsId = $("#hiddenId" + index)[0].innerHTML;
    console.log(_AdsId);
    var settings = {
        "url": "http://localhost:8080/category/delete/" + _AdsId,
        "method": "DELETE",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ="
        },
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });

    $("#hiddenId" + index).parents('.grid-item').detach();

    }
}

// function ShowMiniMap(lat,lon) {
//     <button  type="button" class="btn btn-success col-3 " style="margin-right: 1.5rem;" onclick="ShowMiniMap(${post[index].lat},${post[index].lon})"  data-toggle="modal" data-target="#myModal">Map</a>
//     $(document).on('shown.bs.modal','#myModal', (function() {
//     // var mapIsAdded = false;
//     // console.log(mapIsAdded);

//     //   if (!mapIsAdded) {
//         // console.log(mapIsAdded);
//         console.log("here");

//         $('.modal-body').html(`<iframe id="map_frame" 
//         width="100%" height="600px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" 
//         src="https://www.google.com/maps?f=q&amp;output=embed&amp;source=s_q&amp;hl=com&amp;geocode=&amp;q=https:%2F%2Fwww.google.com%2Fmaps%2Fms%3Fauthuser%3D0%26vps%3D5%26hl%3Dsk%26ie%3DUTF8%26oe%3DUTF8%26msa%3D0%26output%3Dkml%26msid%3D205427380680792264646.0004fe643d107ef29299a&amp;aq=&amp;sll=48.669026,19.699024&amp;sspn=4.418559,10.821533&amp;ie=UTF8&amp;ll=
//         ${lat},${lon}&amp;spn=0.199154,0.399727&amp;t=m&amp"></iframe>`);


//         // mapIsAdded = true;
//     //   }

//     }));
// }
window.onload = function () {
    getPost()
};

function getPost() {
    let row;
    fetch('http://localhost:8080/category/getCategoryAd')
        .then((res) => {
            return res.json();
        })

        .then((post) => {
            for (let index = 0; index < 12; index++) {

                row = `
          <div class="grid-item">
          <div class="card text-center " style="width: 20rem; ">
          <div class="card-body" style = "font-size: large;">
          <h5 class="card-title">סוג מתקן : ${post[index].type}</h5>
          <p class="card-text" >שם :${post[index].name}</p>
          <p class="card-text">כתובת : ${post[index].neighborhood} |${post[index].houseNumber}|${post[index].street}</p>
          <p class="card-text">נגישות : ${post[index].handicapped}</p>
          <p class="card-text">זמינות : ${post[index].condition}</p>
          <p class="card-text">תיאורה : ${post[index].lighting}</p>
          <p class="card-text">גידור : ${post[index].fencing}</p>
          <p class="card-text"  hidden id="hiddenId${index}">${post[index].id}</p>
          <div class="row"  >
          <a href="https://www.google.com/maps/?q=${post[index].lat},${post[index].lon}" type="button" class="btn btn-success col-6 " style="margin-right: 4.5rem;" >Map</a>
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

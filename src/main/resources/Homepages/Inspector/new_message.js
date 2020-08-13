const dropDownNamesElemenet = document.getElementById("namesList");
const statusElement = document.getElementById("statusValue");
const dropdownValue = document.getElementById("dropdownValue");
const messageElement = document.getElementById("inputMessage");
const titleElement = document.getElementById("titleInput");
const successNotification = document.getElementById("successNotification");

const userId = localStorage.getItem("userId");
const userEmail = localStorage.getItem("userEmail");

let selectedFacility = null;

dropdownValue.innerText = "בחירת נמען";
successNotification.classList.add("hide");

fetch("");

const isValid = () => {
    const _isValid =
        dropdownValue.value !== "בחירת נמען" &&
        !!messageElement.value &&
        !!titleElement.value;
    const errorMessage = document.getElementById("errorMessage");
    errorMessage.innerText = _isValid ? "" : "Please fill those requiered fields";
    return _isValid;
};

const postMessage = () => {
  var myHeaders = new Headers();
  myHeaders.append("Authorization", "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=");
  myHeaders.append("Content-Type", "application/json");
  
const selectedInspector = _users.find(({name}) => name === dropdownValue.innerHTML);
const userEmailSent=localStorage.setItem("selectedInspectorEmail", selectedInspector.username);

var raw = JSON.stringify({
  body: messageElement.value,
    idUser: userId,
    recipientEmail: selectedInspector.username,
    subject: titleElement.value,
    userNameSending: userEmail,
  });

  var requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch(
    "http://localhost:8080/managementEmail/inspectorToAdmin",
    requestOptions
  )
    .then((response) => response.text())
    .then((result) => {
      onSuccess();
    })
    .catch((error) => console.log("error", error));
};

const setDefaultFormFiels = () => {
    dropdownValue.innerText = "בחירת נמען";
    messageElement.value = "";
    titleElement.value = "";
};

const onSuccess = () => {
  setDefaultFormFiels();
  successNotification.classList.add("show");
  setTimeout(() => {
    successNotification.classList.remove("show");
    successNotification.classList.add("hide");
    window.location = "/Homepages/Inspector/Inspectorshomepage.html";
  }, 3000);
};

const onSubmit = (event) => {
    event.preventDefault();
    const _isValid = isValid();
    if (!_isValid) return;
    postMessage();
};

const onClickFacilityItem = (list) => (event) => {
    const {textContent} = event.target;
    selectedFacility = list.find((value) => value.name === textContent);
    dropdownValue.innerText = selectedFacility.name;
};

const mapFacilityItem = (list) => (facility) => {
    const nameElement = document.createElement("li");
    const {name} = facility;

    nameElement.addEventListener("click", onClickFacilityItem(list));
    nameElement.appendChild(document.createTextNode(name));
    dropDownNamesElemenet.appendChild(nameElement);
};

const myHeaders = new Headers();
let _users = [];

myHeaders.append("Authorization", "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=");

const requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow",
};

const filterUsersByRole = (_role) => (users) => {
    _users = (users || []).filter(({role}) => role == _role);
    _users.forEach(mapFacilityItem(_users));
};

fetch("http://localhost:8080/users", requestOptions)
    .then((response) => response.json())
    .then(filterUsersByRole(1))
    .catch((error) => console.log("error", error));

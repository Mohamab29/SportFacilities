const mockUserId = '5eb9caf2fa2069679d7cbd8a';

const dropDownNamesElemenet = document.getElementById('namesList');
const statusElement = document.getElementById('statusValue');
const dropdownValue = document.getElementById('dropdownValue');
const messageElement = document.getElementById('inputMessage');
const titleElement = document.getElementById('titleInput');
const successNotification = document.getElementById('successNotification');

const userId = localStorage.getItem("userId");

let selectedFacility = null;
let facilitiesNames = [];

dropdownValue.innerText = 'בחירת מתקן';
statusElement.innerText = 'Low';
successNotification.classList.add('hide');

const isValid = () => {
    const _isValid = dropdownValue.value !== 'בחירת מתקן' &&
        !!messageElement.value &&
        !!titleElement.value;
    const errorMessage = document.getElementById('errorMessage');
    errorMessage.innerText = _isValid ? '' : 'Please fill those requiered fields';
    return _isValid;
}

const postDemmage = () => {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", "Basic YWRtaW5AYWRtaW4uY29tOjEyMzQ=");
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "date": new Date().getUTCDate(),
        "documentation": messageElement.value,
        "id": userId,
        "idAdvertisement": selectedFacility.meta.id,
        "reason": titleElement.value,
        "status": statusElement.innerText
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/damage/addDamage", requestOptions)
        .then(response => response.text())
        .then(result => onSuccess())
        .catch(error => onerror(error));
}

const setDefaultFormFiels = () => {
    statusElement.innerText = 'Low';
    dropdownValue.innerText = 'בחירת מתקנים';
    messageElement.value = '';
    titleElement.value = '';
}

const onSuccess = () => {
    setDefaultFormFiels();
    successNotification.classList.add('show');
    setTimeout(() => {
        successNotification.classList.remove('show');
        successNotification.classList.add('hide');
        window.location = "/Homepages/Inspector/Inspectorshomepage.html";
    }, 3000);
}

const onSubmit = (event) => {
    event.preventDefault();
    const _isValid = isValid();
    if (!_isValid) return;
    postDemmage();
}

const onClickFacilityItem = (event) => {
    const {textContent} = event.target;
    selectedFacility = facilitiesNames.find((value) => value.name === textContent);
    dropdownValue.innerText = selectedFacility.name;
};

const mapFacilityItem = (facility) => {
    const nameElement = document.createElement('LI');
    const {name} = facility;

    nameElement.addEventListener('click', onClickFacilityItem)
    nameElement.appendChild(document.createTextNode(name))
    dropDownNamesElemenet.appendChild(nameElement);
};

const createfacilitiesNamesElements = (facilities) => {
    facilities.forEach(mapFacilityItem);
};

const onStatusChange = () => {
    const {checked} = document.getElementById('status');
    statusElement.innerText = checked ? 'High' : 'Low';
}

if (facilitiesNames.length === 0) {
    fetch('http://localhost:8080/category/getCategoryAd')
        .then((res) => res.json()
        ).then((data) => {
        const _data = []
        data.forEach(element => {
            _data.push({name: element.name, meta: element});
        });
        facilitiesNames = _data.filter((value, index) => _data.indexOf(value) === index);
        createfacilitiesNamesElements(facilitiesNames);
    });
}
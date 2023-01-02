const API_URL = 'http://localhost:8080/user/registration';
let form = {};

const getData = () => {
    fetch(API_URL)
    .then(response => response.json)
    .then(data => {
        console.log(data)
    })
}
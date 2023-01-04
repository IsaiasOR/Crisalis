var formElement = document.getElementById('form_reg');

formElement.addEventListener('submit', (event) => {
    event.preventDefault();

    let data = {
        firstname: document.getElementById('inputFirstname').value,
        lastname: document.getElementById('inputLastname').value,
        dni: document.getElementById('inputDNI').value,
        phoneNumber: document.getElementById('inputPhoneNumber').value,
        role: document.getElementById('inputRole').value,
        email: document.getElementById('inputEmail').value,
        password: document.getElementById('inputPassword').value
    };

    fetch('http://localhost:8080/user/register', {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(json => console.log(json))
        .catch(error => console.log(error));
})


/* add hovered class in selected list item */
let list = document.querySelectorAll('.navigation li');
function activeLink() {
    list.forEach((item) => 
    item.classList.remove(''));
    this.classList.add('hovered');
}
list.forEach((item ) => 
item.addEventListener('mouseover', activeLink));

/* Menu toggle */
let toggle = document.querySelector('.toggle');
let navigation = document.querySelector('.navigation');
let topB = document.querySelector('.top');

toggle.onclick = function() {
    navigation.classList.toggle('active');
    topB.classList.toggle('active');
}
var formulario = document.getElementById('form_reg');

formulario.addEventListener('submit', function(e){
    var datosForm = new FormData(formulario);

    let datos = {
        firstname: datosForm.get('firstname'),
        lastname: datosForm.get('lastname'),
        email:datosForm.get('email'),
        mobileNumber: datosForm.get('mobileNumber'),
        dni: datosForm.get('dni'),
        password: datosForm.get('password'),
    }

    fetch('jdbc:sqlserver://localhost:1433/User', {
        method: "POST",
        body: JSON.stringify(datos),
    })
        .then(response => response.json()) 
        .then(json => console.log(json))
        .catch(error => console.log(error));

})
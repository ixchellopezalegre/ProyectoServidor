
window.onload = function () {
    console.log("Cargando validacion de formulario");
    document.getElementById("formDireccion").addEventListener("submit", function(event) {
        validarFormulario(event);
    });
}

//Realizamos la validación del formulario
    function validarFormulario(event) {
        // Limpiamos los mensajes de error
        document.getElementById("calleError").textContent = "";
        document.getElementById("numeroError").textContent = "";
        document.getElementById("localidadError").textContent = "";
        document.getElementById("codigoPostalError").textContent = "";

        console.log("Validando formulario");
        // Validación de campos del formulario
          let valido = true;
            valido = validarCalle() && valido;
            valido = validarNumero() && valido;
            valido = validarLocalidad() && valido;
            valido = validarCodigoPostal() && valido;
            if (!valido) {
                // Si hubo un error en la validación, prevenimos que el formulario se envíe
                event.preventDefault();
                alert("Hay errores en el formulario");
            }
    }

    //Validamos la calle
    function validarCalle() {
        let calle = document.getElementById("calle").value;
        if (calle.length === 0) {
            document.getElementById("calleError").textContent = "La calle no puede estar vacia.";
            return false;
        }
        return true;
    }

    //Validamos el número
    function validarNumero() {
        let numero = document.getElementById("numero").value;
        if (numero.length === 0) {
            document.getElementById("numeroError").textContent = "El numero no puede estar vacio.";
            return false;
        }
        return true;
    }

    //Validamos la localidad
    function validarLocalidad() {
        let localidad = document.getElementById("localidad").value;
        if (localidad.length === 0) {
            document.getElementById("localidadError").textContent = "La localidad no puede estar vacia.";
            return false;
        }
        return true;
    }

    //Validamos el código postal
    function validarCodigoPostal() {
        let codigoPostal = document.getElementById("codigoPostal").value;
        const regex = new RegExp("^([0-4][0-9]|5[0-2]|(0[1-9]|[1-4][0-9])[0-9])[0-9]{3}$");
        const valido = regex.test(codigoPostal);

        if (codigoPostal.length === 0) {
            document.getElementById("codigoPostalError").textContent = "El codigo postal no puede estar vacio.";
            return false;
        }else if (codigoPostal.length !== 5) {
            document.getElementById("codigoPostalError").textContent = "El codigo postal debe tener 5 digitos";
            return false;
        }else if (!valido) {
            document.getElementById("codigoPostalError").textContent = "El codigo postal debe ser de España.";
            return false;
        }
        return true;
    }
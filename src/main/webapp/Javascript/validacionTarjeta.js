
    window.onload = function () {
        console.log("Cargando validación de formulario");
        document.getElementById("formTarjeta").addEventListener("submit", function(event) {
            validarFormulario(event);
        });
}

    //Realizamos la validación del formulario
     function validarFormulario(event) {
         // Limpiamos los mensajes de error
         document.getElementById("titularError").textContent = "";
         document.getElementById("numeroTarjetaError").textContent = "";
         document.getElementById("fechaCaducidadError").textContent = "";
         document.getElementById("cvvError").textContent = "";

        console.log("Validando formulario");
         // Validación de campos del formulario
         let valido = true;
            valido = validarTitular() && valido;
            valido = validarNumTarjeta() && valido;
            valido = validarFechaCaducidad() && valido;
            valido = validarCVV() && valido;
            if (!valido) {
                // Si hubo un error en la validación, prevenimos que el formulario se envíe
                event.preventDefault();
                alert("Hay errores en el formulario");
            }

    }
    //Validamos el titular
    function validarTitular() {
        let titular = document.getElementById("titular").value;
        if (titular.length === 0) {
            document.getElementById("titularError").textContent = "El titular no puede estar vacio.";
            return false;
        }
        return true;
    }

    //Validamos el número de tarjeta
    function validarNumTarjeta() {
        let numTarjeta = document.getElementById("numeroTarjeta").value;

        //La expresión regular valida que el número de tarjeta tenga 16 dígitos
        const regex = new RegExp("^[0-9]{16}$");
        const valido = regex.test(numTarjeta);

        if (numTarjeta.length === 0) {
            document.getElementById("numeroTarjetaError").textContent = "El numero de tarjeta no puede estar vacio.";
            return false;
        }else if (!valido) {
            document.getElementById("numeroTarjetaError").textContent = "El numero de tarjeta debe tener 16 digitos.";
            return false;
        }
        return true;
    }

    //Validamos la fecha de caducidad
    function validarFechaCaducidad() {
        let fechaCaducidad = document.getElementById("fechaCaducidad").value;

        //Comprobamos que la fecha de caducidad no sea anterior a la fecha actual
        const fechaActual = new Date();
        const fechaCaducidadDate = new Date(fechaCaducidad);

        if (fechaCaducidad.length === 0) {
            document.getElementById("fechaCaducidadError").textContent = "Debes introducir una fecha de caducidad.";
            return false;
        }else if (fechaCaducidadDate < fechaActual) {
            document.getElementById("fechaCaducidadError").textContent = "La fecha de caducidad no puede ser anterior a la fecha actual.";
            return false;
        }
        return true;
    }

    //Validamos el CVV
    function validarCVV() {
        let cvv = document.getElementById("cvv").value;
    console.log(cvv);
        //La expresión regular valida que el CVV tenga 3 dígitos
        const regex = new RegExp("^[0-9]{3}$");
        const valido = regex.test(cvv);

        if (cvv.length === 0) {
            document.getElementById("cvvError").textContent = "El CVV no puede estar vacio.";
            return false;
        }else if (!valido) {
            document.getElementById("cvvError").textContent = "El CVV debe tener 3 digitos.";
            return false;
        }
        return true;
    }



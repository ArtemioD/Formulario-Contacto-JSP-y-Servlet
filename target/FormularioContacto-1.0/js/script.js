/*
Desarrollar un formulario validado.
*/

let mi_error;
let nombre;
let apellido;
let correo;
let tel;
let mensaje;

let expresion = /\w+@\w+\.+[a-z]/; // para validar el correo

const validar = () => {
    nombre = document.getElementById("nombre").value;
    apellido = document.getElementById("apellido").value;
    correo = document.getElementById("correo").value;
    tel = document.getElementById("tel").value;
    mensaje = document.getElementById("mensaje").value;

    //let b = (!nombre); // nombre vasio de falso y lo cambiamos a true
    //console.log(b);

    // podemos poner (!nombre || !apellido || !correo || !tel || !mensaje) campo vasio da siempre falso y lo cambiamos a true
    // es lo mismo que (nombre === "" || apellido === "" || correo === "" || tel === "" || mensaje === "") compos vasios da true

    switch(true) {
        case (!nombre || !apellido || !correo || !tel || !mensaje):
            validar_campo(nombre, 0, 0);
            break;
        case (nombre.length > 30):
            validar_campo(nombre, 1, 30);
            break;
        case (apellido.length > 50):
            validar_campo(apellido, 1, 50)
            break;
        case (correo.length > 100):
            validar_campo(correo, 1, 100);
            break;
        case (tel.length > 20):
            validar_campo(tel, 1, 20);
            break;
        case (isNaN(tel)):
            validar_campo(tel, 2, 0);
            break;
        case (!expresion.test(correo)):
            validar_campo(correo, 3, 0);
            break;
        default:
            return true;
    }
    return false;
}

const validar_campo = (algo, i, carac) => {
    mi_error = document.getElementById("error");
    if (i === 0) mi_error.innerHTML = "<p>¡¡Todos los campos son obligatorios!!</p>";
    else if (i === 1) mi_error.innerHTML = `<p>${algo} es muy largo, maximo ${carac} caracteres</p>`;
    else if (i === 2) mi_error.innerHTML = `<p>${algo} no es un numero!</p>`;
    else if (i === 3) mi_error.innerHTML = "<p>El correo no es valido</p>";
    return false;
}
class Var {
    constructor(type, id, val, mode, process, noExec) {
        this.type = type;
        this.id = id;
        this.val = val;
        this.mode = mode;
        this.process = process;
        this.noExec = noExec;
    }
}

function setValue(id, process, val) {
    let variable = vars.find(e => e.id == id && e.process == process);
    variable.val = val;
}

function getValue(id, process) {
    let variable = vars.find(e => e.id == id && e.process == process);
    return variable.val;
}



let vars = new Array();

/*vars.push(new Var('integer', 'numero', 26 * 78, '@global', 'p1', 1));
vars.push(new Var('string', 'cadena', "hola"+" mundo", '-', 'p2', 1));
vars.push(new Var('string', 'cadena2', ", Java-JS", '-', 'p2', 1));
vars.push(new Var('integer', 'numero2', 100, '@global', 'p1', 1));
vars.push(new Var('integer', 'numero3', getValue('numero', 'p1') / getValue('numero2', 'p1'), '@global', 'p1', 1));
vars.push(new Var('integer', 'cadena3', getValue('cadena', 'p2') + getValue('cadena2', 'p2'), '@global', 'p2', 1));
vars.push(new Var('integer', 'cadena4', null, '@global', 'p2', 1));
vars.push(new Var('integer', 'numero2', 25+(3<55 && 25>100), '-', 'ON_LOAD', 1));*/

vars.push(new Var('integer', 'num', null, '-', 'ON_LOAD', 1));
vars.push(new Var('decimal', 'lll', 1598.222, '-', 'ON_LOAD', 1));
vars.push(new Var('integer', 'numero1', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(new Var('integer', 'numero2', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(new Var('integer', 'numero3', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(new Var('integer', 'numero4', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(new Var('string', 'mensaje', "Este es un mensaje", '-', 'ON_LOAD', 1));

vars.push(new Var('decimal', 'float', getValue('numero1', 'ON_LOAD') * getValue('numero2', 'ON_LOAD') - ('s'.charCodeAt(0) - 25.3), '-', 'ON_LOAD', 1));

console.log(getValue('float', 'ON_LOAD'));
console.log(NUM_ALEATORIO());
console.log(CARACTER_ALEATORIO());
console.log(ASC("hola"));
console.log(DESC("hola"));
console.log(REVERSE("hola"));
console.log(getValue('mensaje', 'ON_LOAD'));
setValue('mensaje', 'ON_LOAD', "Este es un mensaje con mas palabas jasjsjsjsjs");
console.log(getValue('mensaje', 'ON_LOAD'));
console.log(LETPAR_NUM(getValue('mensaje', 'ON_LOAD')));
console.log(LETIMPAR_NUM(getValue('mensaje', 'ON_LOAD')));


function CARACTER_ALEATORIO() {
    let code = Math.floor(Math.random() * (126 - 33)) + 33;
    return String.fromCharCode(code);
}

function NUM_ALEATORIO() {
    return Math.floor(Math.random() * 1000)
}

function ASC(str) {
    return str.split("").sort().join("");
}

function DESC(str) {
    return str.split("").sort().reverse().join("");
}

function REVERSE(str) {
    return str.split("").reverse().join("");
}

function LETPAR_NUM(str) {
    let array = new Array();
    str.split("").forEach((s, i) => {
        if ((i + 1) % 2 == 0) {
            array.push(s.charCodeAt(0));
        } else {
            array.push(s);
        }
    });
    return array.join("");
}

function LETIMPAR_NUM(str) {
    let array = new Array();
    str.split("").forEach((s, i) => {
        if ((i + 1) % 2 != 0) {
            array.push(s.charCodeAt(0));
        } else {
            array.push(s);
        }
    });
    return array.join("");
}
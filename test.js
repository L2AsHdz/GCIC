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

function increaseNoExec(id, process) {
    let variable = vars.find(e => e.id == id && e.process == process);
    variable.noExec = variable.noExec + 1;
    console.log("aumentando", variable.id, variable.process);
}

function addVar(type, id, val, mode, process, noExec) {
    if(vars.find(e => e.id == id && e.process == process) == undefined) {
        vars.push(new Var(type, id, val, mode, process, noExec));
    } else {
        let variable = vars.find(e => e.id == id && e.process == process);
        variable.val = val;
    }
}

function increaseNoExecs(process) {
    vars.forEach(e => {
        if (e.process == process) {
            increaseNoExec(e.id, process);
        }
    });
}

let vars = new Array();

addVar('integer', 'num', null, '-', 'ON_LOAD', 1);
addVar('integer', 'num', null, '-', 'ON_LOAD2', 1);
//addVar('decimal', 'lll', 1598.222, '-', 'ON_LOAD', 1);
/*vars.push(addVar('integer', 'numero1', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(addVar('integer', 'numero2', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(addVar('integer', 'numero3', 25 + (3 < 55), '-', 'ON_LOAD', 1));
vars.push(addVar('integer', 'numero4', 25 + (3 < 55), '-', 'ON_LOAD', 1));*/
//addVar('string', 'mensaje', "Este es un mensaje", '-', 'ON_LOAD', 1);

//vars.push(new Var('decimal', 'float', getValue('numero1', 'ON_LOAD') * getValue('numero2', 'ON_LOAD') - ('s'.charCodeAt(0) - 25.3), '-', 'ON_LOAD', 1));

increaseNoExecs("ON_LOAD");
increaseNoExecs("ON_LOAD");
increaseNoExecs("ON_LOAD");
console.log(vars);

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
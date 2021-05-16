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

let vars = new Array();

function setValue(id, process, val) {
    let variable = vars.find(e => e.id == id && e.process == process);
    variable.val = val;
}

function getValue(id, process) {
    let variable = vars.find(e => e.id == id && e.process == process);
    return variable.val;
}

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

function crear(){
    let tabla="<table class=\"table table-bordered table-dark\">";

    tabla+="<tr><th>ID</th><th>TIPO</th><th>VALOR</th><th>CONTEXTO</th>";
    variables.forEach(a => {
        tabla+="<tr><td>"+a.id+"</td>";
			if(a.tipo !=null){
				tabla += "<td>"+a.tipo+"</td>";
			}else{
				tabla += "<td>----</td>";
			}
			tabla+="<td>"+a.valor+"</td><td>"+a.contexto+"</td>";
    });
    tabla+="</table>";
    document.getElementById("tabla").innerHTML=tabla;
}
function crear2() {
    document.getElementById("tabla").innerHTML="";
}
crear();


<tr>
    <td>${status.count}</td>
    <td>${form.id}</td>
    <td>${form.nombre}</td>
    <td>${form.titulo}</td>
    <td>${form.tema}</td>
    <td>${form.fechaCreacion}</td>
    <td>
        <button type="button" class="btn btn-outline-info" onclick="copyTC('http://localhost:8080/${pageContext.request.contextPath}/builder?id=${form.id}');">Copiar link</button>
    </td>
    <td>
        <a href="${pageContext.request.contextPath}/export?id=${form.id}" class="btn btn-secondary">
            <i class="fas fa-file-export"></i> Exportar
        </a>
    </td>
</tr>
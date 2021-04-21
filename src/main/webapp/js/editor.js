'use strict';

const btnReset = document.querySelector('#reset');
const btnPrint = document.querySelector('#print');
const inputFile = document.querySelector('#archivoEntrada');

let codeEditor = ace.edit("textEditor");

let editorLib = {
    init() {
        codeEditor.setValue('');
        
        //Tema
        codeEditor.setTheme("ace/theme/dreamweaver");
        
        //Language
        codeEditor.session.setMode("ace/mode/text");
        
        //Options
        codeEditor.setOptions({
            fontFamily: 'Inconsolata',
            fontSize: '12pt'
        });
    }
};

btnReset.addEventListener('click', () => {
    codeEditor.setValue('');
    inputFile.value = '';
});

btnPrint.addEventListener('click', () => {
    console.log(codeEditor.getValue());
});

editorLib.init();
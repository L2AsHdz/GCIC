'use strict';

const btnReset = document.querySelector('#reset');
const inputFile = document.querySelector('#archivoEntrada');
const inputText = document.querySelector('#inputText');

let codeEditor = ace.edit("textEditor");

let editorLib = {
    init() {
        codeEditor.setValue('');

        //Tema
        codeEditor.setTheme("ace/theme/merbivore");

        //Language
        codeEditor.session.setMode("ace/mode/html_ruby");

        //Options
        codeEditor.setOptions({
            fontFamily: 'Inconsolata',
            fontSize: '14pt',
            printMarginColumn: 100
        });
    }
};

codeEditor.getSession().on('change', () => {
    inputText.innerHTML = codeEditor.getValue();
});

btnReset.addEventListener('click', () => {
    codeEditor.setValue('');
    inputFile.value = '';
});

editorLib.init();
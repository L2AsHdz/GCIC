'use strict';

const btnReset = document.querySelector('#reset');
const inputFile = document.querySelector('#archivoEntrada');

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
            fontSize: '14pt'
        });
    }
};

btnReset.addEventListener('click', () => {
    codeEditor.setValue('');
    inputFile.value = '';
});

editorLib.init();
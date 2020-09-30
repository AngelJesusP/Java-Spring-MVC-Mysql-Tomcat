/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function enviarRegistroInputsEditar(x) {
    let fila = x.rowIndex;
    let tabla = document.getElementById('tabla');
    $('#codigoId').val(tabla.rows[fila].cells[0].innerHTML);
    $('#nombre').val(tabla.rows[fila].cells[1].innerHTML);
    $('#apellido').val(tabla.rows[fila].cells[2].innerHTML);
    $('#sueldo').val(tabla.rows[fila].cells[3].innerHTML);
}

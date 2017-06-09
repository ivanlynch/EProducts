/* global self */

$(document).ready(function(){

    $('#register-form').on('submit', function(event){
        event.preventDefault();
        var self = this;
        var form = $(this); 
        var errorMsg = $('#errorMsg');
        $.ajax({
           url: 'index.htm',
           type: 'POST',
           data: form.serialize(),
           success: function(result){
               
               var returnedErrorMsg = $(result).find('#errorMsg');
               returnedErrorMsg.addClass("alert alert-danger");
               errorMsg.replaceWith(returnedErrorMsg);
               if(!(errorMsg.text() === 'El correo o contraseña son incorrectos') && !(errorMsg.text() === 'El Correo electronico ' + $('#correo').val() + ' no es valido') &&
                  !(errorMsg.text() === 'El Campo Contraseña es obligatorio') && !(errorMsg.text() === 'El Campo Correo es obligatorio')){
                   self.submit();
               }
           }
           
        });
        
    });
});

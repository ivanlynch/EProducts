$(document).ready(function(){

    $('#login-form').on('submit', function(event){
        
        var self = this;
        var form = $(this); 
        var errorMsg = $('#errorMsg');
        
        
        if (form.data('requestRunning')) {
            return;
        }
        
        form.data('requestRunning', true);
        event.preventDefault();
        $.ajax({
            url: form.attr("action"),
            type: form.attr("method"),
            data: form.serialize(),
            success: function(result){
                
               console.log(result.login);
               if(result.login == undefined){
                   self.submit();
               }else{
                   errorMsg.text(result.login.FAILURE).addClass("alert alert-danger");
                   agitar('#errorMsg');
               }
               
            },
            complete: function (e) {               
                form.data('requestRunning', false);
           }
           
        });
        
    });
    
});

function agitar(idElemento){   
    
    var intervalo = 100;                                                                                                 
    var distancia = 10;                                                                                                  
    var veces = 4;
    var iterar = 0;

    $(idElemento).css('position','relative');                                                                                  

    for(iterar ; iterar < (veces+1) ; iterar++){                                                                              
        $(idElemento).animate({ 
            left:(( iterar % 2 == 0 ? distancia : distancia *- 1))
            }, intervalo);                                   
    }                                                                                                             

    $(idElemento).animate({ left: 0 }, intervalo);                                                                                

}

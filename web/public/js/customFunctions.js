$(document).ready(function(){

    $('#login-form').on('submit', function(event){
        
        var self = this;
        var form = $(this); 
        var errorMsg = $('#errorMsg');
        event.preventDefault();
        
        if (form.data('requestRunning')) {
            return;
        }
        
        form.data('requestRunning', true);
        
        $.ajax({
            url: '/EProducts/j_spring_security_check',
            type: 'POST',
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

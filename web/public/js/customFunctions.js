$(document).ready(function(){
    
    /* Inicializamos las variables */
    var total = 0;
    
    /* Almacenamos todos los elementos que tengan clase precioUnitario */
    var preciosUnitarios = document.getElementsByClassName("precioUnitario");
    
    /* Inicializamos los elementos con clase totalQty pasandole el valor unitario de cada elemento */
    $('.totalQty').each(function(index, value){
       $(value).text(new Intl.NumberFormat("es-ES", { style: "currency", currency: "ARS"}).format($($(preciosUnitarios)[index]).val())); 
    });
    
    /* Creamos el total inicial */
    $('.cantidad').each(function(input, value){
       var precioUnitario = $(value).next('.precioUnitario').val();
       total += parseInt(precioUnitario);
       $('#totalPrice').text(new Intl.NumberFormat("es-ES", { style: "currency", currency: "ARS"}).format(total));
    });
    
    /* En cada incremento o decremento de los elementos volvemos a hacer la suma */
    $('.cantidad').on('click', function(){
       var total = 0;
       $('.cantidad').each(function(input, value){
           var precioUnitario = $(value).next('.precioUnitario').val();
           var cantidad = $(value).val();
           cantidad = cantidad === "" ? 0 : cantidad;
           var totalQty = cantidad * precioUnitario;
           $('.totalQty').each(function(index, value){
               if(index == input){
                   $(value).text(new Intl.NumberFormat("es-ES", { style: "currency", currency: "ARS"}).format(totalQty));
               }
           });
           total += parseInt(cantidad) * parseInt(precioUnitario);
       });
       $('#totalPrice').text(new Intl.NumberFormat("es-ES", { style: "currency", currency: "ARS"}).format(total));
    });
    
    /* Ajax Call al controllador de login */
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


/* Funcion que agita el div en caso de error */
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

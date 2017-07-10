$(document).ready(function(){
    
    /* Tomamos la variable global del contexto definida en las dependecias */
    var contextPath = $('#contextPath').val();
    
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
    
    /* Enviamos los datos ingresados al controlador checkout */
    $('#checkout').on('click', function(event){
        
        /* Declaramos el array que va a contener todos los items */
        var ItemList = [];
        
        /* Iteramos cada fila de la tabla */
        $(".tableRow").each(function(input, value){
            
            /* Inicializamos un objecto Items vacio */
            var Items = {
                product: {},
                quantity: ""
            };
            
            /* Seteamos todos los valores de objeto */
            Items.product.id = $(value).find("#productId").val();
            Items.product.productName = $(value).find("#productName").val();
            Items.product.productDescription = $(value).find("#productDescription").val();
            Items.product.productPrice = $(value).find("#productPrice").val();
            Items.quantity = $(value).find("#quantity").val();
            
            /* guardamos el objeto dentro del array */
            ItemList.push(Items);
        });
        
        /* Hacemos la llamada usando ajax al controllador */
        $.ajax({
            url: contextPath+"/checkout",
            type: 'POST',
            dataType: 'json',
            data: {"ItemList":JSON.stringify(ItemList)},
            complete: function(result){
                /* una vez terminada la llamada redireccionamos a la vista checkout */
                window.location.href = contextPath+"/checkout";
            }
        });
        
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
    
    /* Seteamos la los valores en la url para pasarle al controlador del carrito*/
    $('.form-control.qty').on('click',function(index, value){
            var value = $(this).val();
            var parentElement = $(this).parent().parent().parent();
            var productId = parentElement.find("#productId").val();
            var newUrl = contextPath + "/cart/add/" + productId + "/" + value;
            parentElement.find("#addToCart").attr("href", newUrl);
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

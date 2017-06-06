//function doNotTurnOffModelDialog() {
//    $('#login-form').submit(function (e) {
//
//        var me = $(this);
//        e.preventDefault();
//
//        if (me.data('requestRunning')) {
//            return;
//        }
//        
//        var submission;
//        function test(data){
//            return submission = data;
//        }
//        
//        me.data('requestRunning', true);
//        
//        
//        var correo = $('#correo').val();
//        var password = $('#password').val();
//
//        Materialize.toast('Enviando correo : ' + correo + ' y password : ' + password, 4000);
//
//        $.ajax({
//
//            type: "POST",
//            url: "/EProducts/index.htm",
//            data: $('#login-form').serialize(),
//            success: function (response) {
//                Materialize.toast(response, 4000);
//                $('#correo').val('');
//                $('#password').val('');
//                if(response !== "Usuario incorrecto"){
//                    setTimeout(10);
//                    $('#correo').val('');
//                    $("#login-form")[0].submit();
//                }
//                
//            },
//            complete: function (e) {
//                me.data('requestRunning', false);
//            }
//            
//        });
//       
//    });
//    
//}

$('form').on('submit', function(event){
   event.preventDefault();
   
   var form = $(this);
   if (form.data('requestRunning')) {
       return;
   }
   
   form.data('requestRunning', true);
   
   
   $.ajax('/index.htm', {
       
       type: 'POST',
       data: form.serialize(),
       
       success: function(result){
          
       },
       complete: function(){
           
           form.data('requestRunning', false);
           
       }
       
   });
   
   
   
});
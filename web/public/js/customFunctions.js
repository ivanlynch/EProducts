//function checkIfUserIsCorrect(){
//    var me = $(this);
//    var correo = $.ajax({
//            
//            type: "POST",
//            url: "/EProducts/index.htm",
//            data: me.serialize(),
//            success: function (response) {
//                Materialize.toast(response, 4000);
//                
//            }
//            
//            
//    });
//    
//    
//}
//
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
//        me.data('requestRunning', true);
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
//            data: me.serialize(),
//            success: function (response) {
//                
//                Materialize.toast(response, 4000);
//                me.remove();
//                me.submit();
//                
//            },
//            complete: function (e) {
//                me.data('requestRunning', false);
//            }
//            
//        });
//    });
//    
//}

function doNotTOMD(){
    
    $('#register-form').submit(function(e){
        e.preventDefault();
    });
    
}

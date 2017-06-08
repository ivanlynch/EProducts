$(document).ready(function(){
    $('#register-form').on('submit', function(event){
        event.preventDefault();
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
               console.log($('#errorMsg').text());
               
           }
           
        });
    });
});
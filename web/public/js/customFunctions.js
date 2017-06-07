$(document).ready(function(){
    $('#register-form').on('submit', function(event){
        event.preventDefault();
        var form = $(this);
        $.ajax({
           url: 'index.htm',
           type: 'POST',
           data: form.serialize(),
           success: function(result){
               alert(result);
           }
        });
    });
});
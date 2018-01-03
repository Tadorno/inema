$(document).ready((function() {
    $(".positive-integer").numeric({ decimal: false, negative: false }, function() { alert("Positivos apenas"); this.value = ""; this.focus(); });
    $(".positive-decimal-2").numeric({ decimal: '.', negative: false }, function() { alert("Positivos apenas"); this.value = ""; this.focus(); });
    
    $(".positive-decimal-1").numeric({ decimal: '.', negative: false }, function() { alert("Positivos apenas"); this.value = ""; this.focus(); });
    $(".positive-decimal-3").numeric({ decimal: '.', negative: false }, function() { alert("Positivos apenas"); this.value = ""; this.focus(); });
    
    $(".positive-decimal-4").numeric({ decimal: '.', negative: false }, function() { alert("Positivos apenas"); this.value = ""; this.focus(); });

    $(".positive-decimal-2").blur(function(e){
        value = testeNaN($(this).val()); 
        if(value>=0){
             $(this).val(value.toFixed(2)); 
        }else{
            $(this).val("0.00"); 
        }
     });
     
     $(".positive-decimal-1").blur(function(e){
        value = testeNaN($(this).val()); 
        if(value>=0){
             $(this).val(value.toFixed(1)); 
        }else{
            $(this).val("0.0"); 
        }
     });
     
     $(".positive-decimal-3").blur(function(e){
        value = testeNaN($(this).val()); 
        if(value>=0){
             $(this).val(value.toFixed(3)); 
        }else{
            $(this).val("0.000"); 
        }
     });
     
     $(".positive-decimal-4").blur(function(e){
        value = testeNaN($(this).val()); 
        if(value>=0){
             $(this).val(value.toFixed(4)); 
        }else{
            $(this).val("0.0000"); 
        }
     });

     $(".positive-integer").blur(function(e){
        value = testeNaN($(this).val()); 
        if(value>=0){
             $(this).val(value); 
        }else{
            $(this).val("0"); 
        }
     });
 }));
 
 function testeNaN(valor){
     if(valor==''){
         return 0;
     }else{
         return parseFloat(valor);
     }
 }
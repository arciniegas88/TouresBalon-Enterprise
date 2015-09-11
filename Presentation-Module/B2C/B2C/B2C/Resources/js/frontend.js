$.validator.setDefaults({
    submitHandler: function () {
        submit();
    }
});

$(document).ready(function () {
    $("#login").click(function (event) {

        if ($("#navPanel").css('display') == 'block')
        {
            $('#navToggle').click();
        }

        $("#login_form").dialog(
           {
               height: 600,
               width: 450,
               modal: true
           });
    });

    $("#btn_register").click(function () {
        $("#login_div").hide();
        $("#register_div").show();
    });

    $("#btn_login").click(function () {
        $("#login_div").show();
        $("#register_div").hide();
    });

    $("#loginForm").validate({
        rules: {
            "form.Password": {
                required: true,
                minlength: 6
            },
            "form.Email": {
                required: true,
                email: true
            },
        },
        messages: {
            "form.Password": {
                required: "Por favor ingrese el password",
                minlength: "Tu password debe tener mas de 6 caracteres"
            },
            "form.Email": "Ingrese un email valido"
        }
    });

    $("#registerForm").validate({
        rules: {
            "form.FirstName": {
                required: true,
                minlength: 6
            },
            "form.LastName": {
                required: true,
                minlength: 6
            },
            "form.PhoneNumber": {
                required: true,
                minlength: 7
            },
            "form.Password": {
                required: true,
                minlength: 6
            },
            "form.Email": {
                required: true,
                email: true
            },
        },
        messages: {
            "form.FirstName": {
                required: "Por favor ingrese el nombre",
                minlength: "Tu nombre debe tener mas de 6 caracteres"
            },
            "form.LastName": {
                required: "Por favor ingrese el apellido",
                minlength: "Tu apellido debe tener mas de 6 caracteres"
            },
            "form.PhoneNumber": {
                required: "Por favor ingrese el telefono",
                minlength: "Tu telefono debe tener mas de 7 numeros"
            },
            "form.Password": {
                required: "Por favor ingrese el password",
                minlength: "Tu password debe tener mas de 6 caracteres"
            },
            "form.Email": "Ingrese un email valido"
        }
    });


    $(".get_order").click(function () {
        
        var id = $(this).attr("id");
        var temp = id.split("_");

        $.get("/order/get/" + temp[1], function (data) {
            $("#order_detail").html(data);
            $("#order_detail").dialog(
              {
              height: '400',
              width: '500',
              modal: true
          });
        });
    });

    $(".buy").click(function () {
        //pro_id
        var value = $(this).attr("id");
        var id = value.split("_")[1];
        var name = $(this).attr("dataname");

        $.post("/shoppingcart/add", { id: id, name: name }, function (data) {
            alert(data.message);
        });
        return false;
    });

    $('.delete_item').click(function () {
        var r = confirm("Esta seguro que desea eliminar este item?");

        if( r )
        {
            //delete_ID_POS
            var value = $(this).attr("id");
            value = value.split("_");
            var id = value[1];
            var pos = value[2];
            $.post("/shoppingcart/delete", { id: id, pos: pos }, function (data) {
                if (data.success)
                {
                    $("#car_item_" + id).remove();
                    alert(data.message);
                } else {
                    alert(data.message);
                }
            });
            return false;
        }

    });

    
});
/*$.validator.setDefaults({
    submitHandler: function () {
        submit();
    }
});*/

function showMessage(title, message)
{
    $('body').css('overflow-y', 'hidden');
    $("#lightbox_message").fadeIn();
    $("#overlay_message").fadeIn();
    $("#message_alert").html(message);
    $("#title_alert").html(title);
}

function showLoading()
{
    $("#loading").show();
    $('body').css('overflow-y', 'hidden');
}

function hideLoading() {
    $("#loading").fadeOut('slow');
    $('body').css('overflow-y', '');
}


$(document).ready(function () {

    $("#login").click(function () {
        var inputEmail = $("#inputEmail").val();
        var inputPassword = $("#inputPassword").val();
        showLoading();
        $.post("/security/login/", { email: inputEmail, password: inputPassword }, function (response) {
            hideLoading();
            if (response.success)
            {
                document.location.href = response.url;
            } else {
                showMessage("Logueo", response.message);
            }

        }, 'json');

    });

    $("#register").click(function () {
        var document_type = $("#form_Document_Type").val();
        var id = $("#form_Id").val();
        var first_name = $("#form_FirstName").val();
        var last_name = $("#form_LastName").val();
        var phone = $("#form_PhoneNumber").val();
        var email = $("#form_Email").val();
        var password = $("#form_Password").val();
        var franchise = $("#form_Franchise").val();
        var number = $("#form_Number").val();
        var type = $("#form_Type").val();
        
        var error = false;

        $(".error").html("");

        if (document_type == "")
        {
            error = true;
            $(".error").append("Ingrese el tipo de documento <br />");
        }

        if (id == "") {
            error = true;
            $(".error").append("Ingrese el documento <br />");
        }
        if (first_name == "") {
            error = true;
            $(".error").append("Ingrese el Nombre <br />");
        }
        if (last_name == "") {
            error = true;
            $(".error").append("Ingrese el Apellido <br />");
        }
        if (phone == "") {
            error = true;
            $(".error").append("Ingrese el Telefono <br />");
        }
        if (email == "") {
            error = true;
            $(".error").append("Ingrese el Email <br />");
        }
        if (password == "") {
            error = true;
            $(".error").append("Ingrese el Password <br />");
        }
        if (franchise == "") {
            error = true;
            $(".error").append("Ingrese la franquicia <br />");
        }
        if (number == "") {
            error = true;
            $(".error").append("Ingrese la tarjeta de credito <br />");
        }
        if (type == "") {
            error = true;
            $(".error").append("Ingrese el tipo de cliente <br />");
        }


        if (!error)
        {
            showLoading();
            $('#error').hide();
            $.post("/customer/create/", { email:email, password:password, document_type:document_type, id:id, first_name:first_name, last_name:last_name, phone:phone, franchise:franchise, number:number, type:type }, function (response) {
                hideLoading();
                if (response.success) {
                    document.location.href = response.url;
                } else {
                    showMessage("Logueo", response.message);
                }

            }, 'json');
        } else {
            $('#error').show();
        }

    });

    $(".buy").bind("click", function () {
        var value = $(this).attr("id");
        var id = value.split("_")[1];
        var name = $(this).attr("dataname");
        var cost = $(this).attr("datacost");

       $("#account").val(1);

        $("#name_product").html(name);
        $("#name_product").attr('data-id', id);

        $("#cost_product").html(cost);

        $(".overlay").show();
        $(".lightbox").show();
        $('body').css('overflow-y', 'hidden');
        $(document).scrollTop(0);

        return false;
    });

    $('#buyproduct').click(function () {
        var account = $("#account").val();

        if (account > 0) {
            var id = $("#name_product").attr('data-id');
            var name = $("#name_product").html();
            var cost = $("#cost_product").html();
            showMessage();
            $.post("/shoppingcart/add", { id: id, name: name, account: account, cost: cost }, function (data) {
                hideLoading();
                $("#close_lightbox").click();
                showMessage('Carrito de compras', data.message);

            });
        } else {
            alert("No se aceptan valores negativos.");
        }

        return false;
    });

    $('.delete_item').click(function () {
        var r = true;//confirm("Esta seguro que desea eliminar este item?");

        if (r) {
            //delete_ID_POS
            var value = $(this).attr("id");
            value = value.split("_");
            var id = value[1];
            var pos = value[2];

            var cost = $(this).attr("datacost");

            showLoading();
            $.post("/shoppingcart/delete", { id: id, pos: pos }, function (data) {
                hideLoading();
                if (data.success) {
                    $("#car_item_" + id).remove();
                    var total = $("#total_car").html() - cost;
                    $("#total_car").html(total);
                    showMessage("Elemento eliminado", data.message);
                } else {
                    showMessage("Error", data.message);
                }
            }, 'json');
            return false;
        }

    });

    $('.get_pager').click(function () {
        var url = $(this).attr("href");
        showLoading();
        $.post(url, {}, function (data) {
            hideLoading();
            $("#list_items").html(data);
            $(".buy").bind("click", function () {

                var value = $(this).attr("id");
                var id = value.split("_")[1];
                var name = $(this).attr("dataname");
                var cost = $(this).attr("datacost");

                $("#account").val(1);

                $("#name_product").html(name);
                $("#name_product").attr('data-id', id);

                $("#cost_product").html(cost);

                $("#lightbox_buy").dialog(
                {
                    height: 300,
                    width: 450,
                    modal: true
                });

                return false;
            });
        });

        $("#pagination .disable").addClass("pager");
        $("#pagination .disable").removeClass("disable");
        $(this).addClass("disable");
        return false;
    });

    $(".get_order").click(function () {

        var id = $(this).attr("id");
        var temp = id.split("_");
        id = temp[1];

        $.get("/order/get/" + id, function (data) {
            $("#order_detail").html(data);
            $('body').css('overflow-y', 'none');
            $(".lightbox_big").show();
            $(".overlay").show();
        });
        return false;
    });

    $("#proccess_button").click(function () {
        $(".overlay").show();
        $(".lightbox_big").show();
        $('body').css('overflow-y', 'hidden');
        $(document).scrollTop(0);
    });

    $('.cancel_order').click(function () {
        var id = $(this).attr("id");
        var temp = id.split("_");
        id = temp[1];

        $.post("order/cancel/" + id, function (data) {
            if (data.success) {
                showMessage("Cancelacion orden", data.message);
                $("#close_message").click(function () {
                    location.reload();
                });
            }
        }, 'json');
    });



    $("#close_lightbox").click(function () {
        $('.overlay, .lightbox').fadeOut('slow', function () {
            $('body').css('overflow-y', 'auto');
        });
    });

    $("#close_lightbox_big").click(function () {
        $('.overlay, .lightbox_big').fadeOut('slow', function () {
            $('body').css('overflow-y', 'auto');
        });
    });
    

    $("#close_message").click(function () {
        $('#lightbox_message, #overlay_message').fadeOut('slow', function () {
            $('body').css('overflow-y', 'auto');
        });
    });

    $(".btn_action").click(function()
    {
        showLoading();
        document.location.href = $(this).attr("dataurl");
    });

    /*
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

    $("#creditCardForm").validate({
        rules: {
            "form.Franchise": {
                required: true,
            },
            "form.Number": {
                required: true,
                minlength: 12
            },
            "form.SECRET_CODE": {
                required: true,
                minlength: 4
            },
            "form.Year": {
                required: true,
            },
            "form.Month": {
                required: true,
            },
            "form.Dues": {
                required: true,
                minlength: 1
            },
        },
        messages: {
            "form.Dues": {
                required: "Por favor ingrese Las cuotas",
                minlength: "Tu password debe tener mas de 6 caracteres"
            },
            "form.Month": "Por favor ingrese el mes",
            "form.Year": "Por favor ingrese el año",
            "form.SECRET_CODE": "Por favor ingrese el Codigo",
            "form.Number": "Por favor ingrese el Numero",
            "form.Franchise": "Por favor ingrese la franquicia",
        }
    });


    $(".get_order").click(function () {
        
        var id = $(this).attr("id");
        var temp = id.split("_");
        id = temp[1];

        $.get("/order/get/" + id, function (data) {
            $("#order_detail").html(data);
            $("#order_detail").dialog(
              {
              height: '400',
              width: '500',
              modal: true
          });
        });
    });

   



   


   

    $('.disable').click(function () {
        return false;
    });
    */
    
});
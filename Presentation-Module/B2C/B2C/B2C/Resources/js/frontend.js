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
});
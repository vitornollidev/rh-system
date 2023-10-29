function registerDepartment(name){
    $.ajax({
        url: "http://localhost:8080/department",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            name: name
        }),
        success: function(response){
            $("#modal-register").modal('hide');
            $("#modal-title").text("Cadastrado!");
            $("#p-modal-body").text("O departamento foi cadastrado com sucesso!");
            $("#modal-information").modal('show');
            setTimeout(function() {
                $('#modal-information').modal('hide');
                window.location.reload();
            }, 1500);
        },
        error: function(response){
            $("#modal-register").modal('hide');
            $("#modal-title").text("Erro!");
            $("#p-modal-body").text("Erro ao cadastrar departamento: " + response);
            $("#modal-information").modal('show');
            setTimeout(function() {
                $('#modal-information').modal('hide');
                window.location.reload();
            }, 1500);
        }
    })
}